package dao;


import model.TimeTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TimeTableDAO extends BaseEntityDao<TimeTable, Long> {

    private static final String SQL_UPDATE_TIMETABLE_BY_ID =
            "UPDATE Master SET date = ?, id_user = ?,  id_proc=? WHERE id_timetable = ?";
    private static final String SQL_GET_TIMETABLE_BY_ID =
            "SELECT * FROM Timetable WHERE id_timetable=?";

    private static final String SQL_CREATE_TIMETABLE =
            "INSERT INTO Timetable (date, id_user, id_proc, id_timetable) VALUES (?,?,?,?)";

    private static final String SQL_DELETE_TIMETABLE_BY_ID =
            "DELETE FROM Timetable WHERE id_timetable=?";

    private static final String SQL_GET_ALL =
            "SELECT * FROM user JOIN timetable ON user.id_user=timetable.id_user JOIN procedure ON timetable.id_proc=procedure.id_proc";


    private final EntityMapper<TimeTable> timeTableMapper = new EntityMapper<TimeTable>() {
        //ЭТО ДЛЯ ГЕТ
        @Override
        public TimeTable parse(ResultSet rs) throws SQLException {
            TimeTable timeTable = new TimeTable();
            timeTable.setId(rs.getLong("id_timetable"));
            timeTable.setDateTime(rs.getDate("date"));
            timeTable.setClient(rs.getLong("id_user"));
            timeTable.setProcedure(rs.getLong("id_proc"));


            return timeTable;
        }

        @Override
        public void write(PreparedStatement st, TimeTable timeTable) throws SQLException {
            st.setDate(1, timeTable.getDateTime());
            st.setLong(2, timeTable.getClient());
            st.setLong(3, timeTable.getProcedure());

            if (timeTable.getId() != null) {
                st.setLong(4, timeTable.getId());
            }
        }
    };

    @Override
    public TimeTable getById(Long id) throws DAOException {
        return super.getById(id, timeTableMapper, SQL_GET_TIMETABLE_BY_ID);
    }

    @Override
    public TimeTable update(TimeTable timeTable) throws DAOException {
        super.update(timeTable, timeTableMapper, SQL_UPDATE_TIMETABLE_BY_ID);
        return getById(timeTable.getId());
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return super.remove(id, SQL_DELETE_TIMETABLE_BY_ID);

    }

    @Override
    public boolean create(TimeTable timeTable) throws DAOException {
        return super.update(timeTable, timeTableMapper, SQL_CREATE_TIMETABLE);
    }

    public List<TimeTable> getAllTimeTables() throws DAOException {
        return super.findAll(timeTableMapper, SQL_GET_ALL);
    }
}
