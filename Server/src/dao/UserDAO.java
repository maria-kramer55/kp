package dao;

import model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public final class UserDAO extends BaseEntityDao<Client, Long> {
    private static final String SQL_UPDATE_USER_BY_ID =

            "UPDATE User SET login = ?, password = ?, first_name = ?, last_name=?, phone_number=? WHERE id_user = ?";

    private static final String SQL_GET_USER_BY_ID =
            "SELECT * FROM User WHERE id_user=?";

    private static final String SQL_CREATE_USER =
            "INSERT INTO User (login, password,  first_name, last_name,phone_number,id_user) VALUES (?,?,?,?,?,?)";

    private static final String SQL_DELETE_USER_BY_ID =
            "DELETE FROM User WHERE id_user=?";

    private static final String SQL_GET_ALL =
            "SELECT * from user;";


    private final EntityMapper<Client> userMapper = new EntityMapper<Client>() {
        //ЭТО ДЛЯ ГЕТ
        @Override
        public Client parse(ResultSet rs) throws SQLException {
            Client client = new Client();
            client.setId(rs.getLong("id_user"));
            client.setPassword(rs.getString("password"));
            client.setPhoneNumber(rs.getString("phone_number"));
            client.setLogin(rs.getString("login"));
            client.setFirstName(rs.getString("first_name"));
            client.setLastName(rs.getString("last_name"));
            return client;
        }

        //ЭТО ДЛЯ СЕТ
        @Override
        public void write(PreparedStatement st, Client user) throws SQLException {
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getFirstName());
            st.setString(4, user.getLastName());
            st.setString(5, user.getPhoneNumber());
            if (user.getId() != null) {
                st.setLong(6, user.getId());
            }
        }
    };

    public static void main(String[] args) throws DAOException {
        UserDAO dao = new UserDAO();


        System.out.println();
        String login = "test";
        String password = "test111";
        Client client = new Client();
        client.setLogin("update");
        client.setFirstName("update");
        client.setLastName("update");
        client.setPhoneNumber("update");
        client.setPassword("update");
        client.setId(1l);
        dao.update(client);

        List<Client> clientList = dao.getAllUsers();
        for (Client allUser : clientList) {
            System.out.println(allUser);
        }
        List<Client> мария = clientList.stream().filter(user -> {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        for (Client client1 : мария) {
        }
    }
    @Override
    public Client getById(Long id) throws DAOException {
        return super.getById(id, userMapper, SQL_GET_USER_BY_ID);
    }

    @Override
    public Client update(Client user) throws DAOException {
        super.update(user, userMapper, SQL_UPDATE_USER_BY_ID);
        return getById(user.getId());
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return super.remove(id, SQL_DELETE_USER_BY_ID);
    }

    @Override
    public boolean create(Client user) throws DAOException {
        return super.update(user, userMapper, SQL_CREATE_USER);
    }

    public List<Client> getAllUsers() throws DAOException {
        return super.findAll(userMapper, SQL_GET_ALL);
    }
}
