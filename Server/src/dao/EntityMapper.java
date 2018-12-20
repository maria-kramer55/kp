package dao;

import model.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapper<T extends Entity> {
    T parse(ResultSet rs) throws SQLException, DAOException;

    void write(PreparedStatement st, T entity) throws SQLException;
}
