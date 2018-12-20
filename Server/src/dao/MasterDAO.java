package dao;


import model.Master;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MasterDAO extends BaseEntityDao<Master, Long> {

    private static final String SQL_UPDATE_MASTER_BY_ID =
            "UPDATE Master SET name = ?, salary = ?,  phone_number=?, id_proc = ? WHERE id_master = ?";
    private static final String SQL_GET_MASTER_BY_ID =
            "SELECT * FROM Master WHERE id_master=?";

    private static final String SQL_CREATE_MASTER =
            "INSERT INTO Master (name, salary,  phone_number, id_proc, id_master) VALUES (?,?,?,?,?)";

    private static final String SQL_DELETE_MASTER_BY_ID =
            "DELETE FROM Master WHERE id_master=?";

    private static final String SQL_GET_ALL =
            "SELECT Master.id_master, Master.name, Master.salary, Master.phone_number, Master.id_proc, Procedure.id_proc, Procedure.proc_type, Procedure.price\n" +
                    "FROM Master\n" +
                    "INNER JOIN Procedure\n" +
                    "ON Master.id_proc=Procedure.id_proc;";


    private final EntityMapper<Master> masterMapper = new EntityMapper<Master>() {
        //ЭТО ДЛЯ ГЕТ
        @Override
        public Master parse(ResultSet rs) throws SQLException {
            Master master = new Master();
            master.setId(rs.getLong("id_master"));
            master.setName(rs.getString("name"));
            master.setSalary(rs.getBigDecimal("salary"));
            master.setPhoneNumber(rs.getString("phone_number"));
            master.setProcedure(rs.getLong("id_proc"));

            return master;
        }

        @Override
        public void write(PreparedStatement st, Master master) throws SQLException {
            st.setString(1, master.getName());
            st.setBigDecimal(2, master.getSalary());
            st.setString(3, master.getPhoneNumber());
            st.setLong(4, master.getProcedure());
            if (master.getId() != null) {
                st.setLong(5, master.getId());
            }
        }
    };

    @Override
    public Master getById(Long id) throws DAOException {
        return super.getById(id, masterMapper, SQL_GET_MASTER_BY_ID);
    }

    @Override
    public Master update(Master master) throws DAOException {
        super.update(master, masterMapper, SQL_UPDATE_MASTER_BY_ID);
        return getById(master.getId());
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return super.remove(id, SQL_DELETE_MASTER_BY_ID);

    }

    @Override
    public boolean create(Master master) throws DAOException {
        return super.update(master, masterMapper, SQL_CREATE_MASTER);
    }

    public List<Master> getAllUsers() throws DAOException {
        return super.findAll(masterMapper, SQL_GET_ALL);
    }
}
