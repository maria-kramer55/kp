package dao;

import dao.sql.ConnectionSource;
import dao.sql.DBPool;
import dao.sql.PoolException;
import model.Entity;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseEntityDao<E extends Entity<K>, K extends Serializable> implements EntityDAO<E, K> {

    private ConnectionSource connectionSource;

    public BaseEntityDao() {
        this.connectionSource = DBPool.getInstance();
    }

    public BaseEntityDao(ConnectionSource connectionSource) {
        this.connectionSource = Objects.requireNonNull(connectionSource);
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    protected boolean remove(K id, String sql) throws DAOException {
        Objects.requireNonNull(id, "Param Id could not be null");

        boolean isRemoved = false;

        try (Connection con = getConnectionSource().getConnection();
             PreparedStatement st = con.prepareCall(sql)) {

            st.setObject(1, id);
            int i = st.executeUpdate();

            isRemoved = i > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }

        return isRemoved;
    }

    protected K create(E entity, EntityMapper<E> mapper, String sql) throws DAOException {
        K id = null;
        try (Connection con = connectionSource.getConnection();
             PreparedStatement st = con.prepareCall(sql)) {
            mapper.write(st, entity);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = (K) Long.valueOf(rs.getLong(1));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }

        return id;
    }


    protected boolean update(E entity, EntityMapper<E> mapper, String sql) throws DAOException {
        Objects.requireNonNull(entity, "Param Entity could not be null");
        Objects.requireNonNull(mapper, "Param Mapper could not be null");

        boolean isCreated = false;

        try (Connection con = getConnectionSource().getConnection();
             PreparedStatement st = con.prepareCall(sql)) {

            mapper.write(st, entity);

            int i = st.executeUpdate();
            isCreated = i > 0;

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    protected List<E> getByIds(EntityMapper<E> mapper, String sql, List<K> ids) throws DAOException {
        Objects.requireNonNull(mapper, "Param Mapper could not be null");

        List<E> list = new ArrayList<>();

        try (Connection con = connectionSource.getConnection();
             PreparedStatement st = con.prepareCall(sql)) {

            for (int i = 0; i < ids.size(); i++) {
                st.setObject(i + 1, ids.get(i));
            }

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                E obj = mapper.parse(rs);
                list.add(obj);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Allows to get {@link List} of {@link Entity} from database using input SQL query string,
     * input {@link EntityMapper} and array of {@link Object} params
     * also it checks input {@link EntityMapper} to null
     * findAllMethod gets connection from {@link ConnectionSource#getConnection()}, creates {@link PreparedStatement}
     * checks array to null and array size
     * fills {@link PreparedStatement} with input params,execute this statement and assign to {@link ResultSet}
     * Further in the cycle there is a creation of {@link Entity} objects and addition to {@link List} of {@link Entity}
     *
     * @param mapper {@link EntityMapper}
     * @param sql    SQL query string
     * @param params array of {@link Object}
     * @return {@link List} of {@link Entity}
     * @throws DAOException {@link DAOException}
     */
    protected List<E> findAll(EntityMapper<E> mapper, String sql, Object... params) throws DAOException {
        Objects.requireNonNull(mapper, "Param Mapper could not be null");

        List<E> list = new ArrayList<>();

        try (Connection con = connectionSource.getConnection();
             PreparedStatement st = con.prepareCall(sql)) {

            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    Object prm = params[i];
                    st.setObject(i + 1, prm);
                }
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                E obj = mapper.parse(rs);
                list.add(obj);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected E find(EntityMapper<E> mapper, String sql, Object... params) throws DAOException {
        Objects.requireNonNull(mapper);

        E obj = null;

        try (Connection con = connectionSource.getConnection();
             PreparedStatement st = con.prepareCall(sql)) {
            if (params != null && params.length > 0) {
                for (int i = 0, length = params.length; i < length; i++) {
                    Object prm = params[i];
                    st.setObject(i + 1, prm);
                }
            }
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                obj = mapper.parse(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }
        return obj;
    }

    protected E getById(K id, EntityMapper<E> mapper, String sql) throws DAOException {
        return find(mapper, sql, id);
    }

    protected int countAll(String sql) throws DAOException {
        int count = 0;

        try (Connection con = connectionSource.getConnection();
             Statement st = con.createStatement()) {

            ResultSet resultSet = st.executeQuery(sql);
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }
        return count;
    }

    protected int countAll(String sql, Object... params) throws DAOException {
        int count = 0;
        E obj = null;

        try (Connection con = connectionSource.getConnection();
             PreparedStatement st = con.prepareCall(sql)) {
            if (params != null && params.length > 0) {
                for (int i = 0, length = params.length; i < length; i++) {
                    Object prm = params[i];
                    st.setObject(i + 1, prm);
                }
            }

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (PoolException e) {
            e.printStackTrace();
        }
        return count;
    }
}
