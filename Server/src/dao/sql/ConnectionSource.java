package dao.sql;

import java.sql.Connection;

public interface ConnectionSource {
    Connection getConnection() throws PoolException;

    void returnConnection(Connection con);

    void freeConnection(Connection con);
}
