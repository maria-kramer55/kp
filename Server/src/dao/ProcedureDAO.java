
package dao;


import model.Procedure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProcedureDAO extends BaseEntityDao<Procedure, Long> {

    private static final String SQL_UPDATE_PROCEDURE_BY_ID =
            "UPDATE Procedure SET type = ?, price = ?, id_discount = ? WHERE id_proc = ?";
    private static final String SQL_GET_PROCEDURE_BY_ID =
            "SELECT * FROM Procedure WHERE id_procedure=?";

    private static final String SQL_CREATE_PROCEDURE =
            "INSERT INTO Procedure (type, price,   id_proc, id_discount) VALUES (?,?,?,?)";

    private static final String SQL_DELETE_PROCEDURE_BY_ID =
            "DELETE FROM Procedure WHERE id_procedure=?";

    private static final String SQL_GET_ALL =
            "SELECT Procedure.id_proc, Procedure.type, Procedure.price, Procedure.id_proc, Procedure.id_discount, Discount.id_discount, Discount.date, Discount.id_proc\n" +
                    "FROM Procedure\n" +
                    "INNER JOIN Discount\n" +
                    "ON Procedure.id_proc=Discount.id_proc;";


    private final EntityMapper<Procedure> procedureMapper = new EntityMapper<Procedure>() {
        //ЭТО ДЛЯ ГЕТ
        @Override
        public Procedure parse(ResultSet rs) throws SQLException {
            Procedure procedure = new Procedure();
            procedure.setId(rs.getLong("id_proc"));
            procedure.setType(rs.getString("name"));
            procedure.setCost(rs.getBigDecimal("salary"));
            procedure.setDiscount(rs.getInt("id_proc"));

            return procedure;
        }

        @Override
        public void write(PreparedStatement st, Procedure procedure) throws SQLException {
            st.setString(1, procedure.getType());
            st.setBigDecimal(2, procedure.getCost());
            st.setLong(3, procedure.getDiscount());

            if (procedure.getId() != null) {
                st.setLong(4, procedure.getId());
            }
        }
    };

    @Override
    public Procedure getById(Long id) throws DAOException {
        return super.getById(id, procedureMapper, SQL_GET_PROCEDURE_BY_ID);
    }

    @Override
    public Procedure update(Procedure procedure) throws DAOException {
        super.update(procedure, procedureMapper, SQL_UPDATE_PROCEDURE_BY_ID);
        return getById(procedure.getId());
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return super.remove(id, SQL_DELETE_PROCEDURE_BY_ID);

    }

    @Override
    public boolean create(Procedure procedure) throws DAOException {
        return super.update(procedure, procedureMapper, SQL_CREATE_PROCEDURE);
    }

    public List<Procedure> getAllProcedures() throws DAOException {
        return super.findAll(procedureMapper, SQL_GET_ALL);
    }
}

