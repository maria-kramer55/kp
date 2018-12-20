package dao.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Database Connection Pool provides
 */
public final class DBPool extends DBPoolBase {

    private static final ReentrantLock LOCK = new ReentrantLock();

    /**
     * Pool max connections number
     */
    private static final int SIZE = 8;

    /**
     * Pool state
     */
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);

    /**
     * current pool instance *
     */
    private static DBPool instance;

    /**
     * available connections
     */
    private BlockingQueue<Connection> free;

    /**
     * used connections
     */
    private BlockingQueue<Connection> used;

    private DBPool() {
        super(
                "com.mysql.jdbc.Driver",
                "admin",
                "root",
                "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false");
    }

    /**
     * Pool instance creation, we need to create it once.
     *
     * @return {@link ConnectionSource} instance
     */
    public static ConnectionSource getInstance() {
        if (!isInitialized.get()) {
            LOCK.lock();
            try {
                if (!isInitialized.get()) {
                    instance = new DBPool();
                    instance.initialize();
                    isInitialized.set(true);
                }
            } finally {
                LOCK.unlock();
            }
        }
        return instance;
    }

    /**
     * Internal pool load
     */
    @Override
    protected void initialize() {
        if (!validate()) {
            throw new RuntimeException("Failed to initialize DBPool");
        }

        try {

            free = new ArrayBlockingQueue<>(SIZE);
            used = new ArrayBlockingQueue<>(SIZE);

            /* Database connection driver */
            Driver driver = super.loadJdbcDriver();

            for (int i = 0; i < SIZE; i++) {
                Connection connection = super.newConnection(driver);
                free.add(connection);
            }

        } catch (SQLException | PoolException e) {
            e.printStackTrace();
        }
    }

    /**
     * Provides available connection from the pool.
     *
     * @return {@link Connection}
     */
    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            con = free.poll(1, TimeUnit.SECONDS);
            used.put(con);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return con;
    }

    /**
     * Return connection back in the pool of free connections
     *
     * @param con {@link Connection}
     */
    @Override
    public void returnConnection(Connection con) {
        if (con == null) {
            return;
        }

        free.add(con);
        used.remove(con);
    }

    /**
     * Removes connection from the pool, only free connections can be removed.
     *
     * @param con {@link Connection}
     */
    @Override
    public void freeConnection(Connection con) {
        Objects.requireNonNull(con);

        free.remove(con);

        try {
            if (!con.isClosed()) con.close();
        } catch (SQLException ignored) {
        }
    }
}
