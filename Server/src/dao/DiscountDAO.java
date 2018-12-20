package dao;

import model.Client;
import model.Discount;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DiscountDAO extends BaseEntityDao<Discount, Long> {

    private static final String SQL_UPDATE_DISCOUNT_BY_ID =
            "UPDATE Discount SET date = ?, id_proc = ? WHERE id_discount = ?";
    private static final String SQL_GET_DISCOUNT_BY_ID =
            "SELECT * FROM Discount WHERE id_discount=?";

    private static final String SQL_CREATE_DISCOUNT =
            "INSERT INTO Discount (date, id_proc, id_discount) VALUES (?,?,?)";

    private static final String SQL_DELETE_DISCOUNT_BY_ID =
            "DELETE FROM Discount WHERE id_discount=?";

    private static final String SQL_GET_ALL =
            "SELECT Discount.id_discount, Discount.date, Discount.id_proc, Procedure.id_proc, Procedure.proc_type, Procedure.price\n" +
                    "FROM Discount\n" +
                    "INNER JOIN Procedure\n" +
                    "ON Discount.id_proc=Procedure.id_proc;";


    private final EntityMapper<Discount> discountMapper = new EntityMapper<Discount>() {
        //ЭТО ДЛЯ ГЕТ
        @Override
        public Discount parse(ResultSet rs) throws SQLException {
            Discount discount = new Discount();
            discount.setId(rs.getLong("id_discount"));
            discount.setEffectiveTo(rs.getDate("date"));
            discount.setDiscountPercent(rs.getInt("percent"));
            discount.setId(rs.getLong("id_proc"));

            return discount;
        }

        @Override
        public void write(PreparedStatement st, Discount discount) throws SQLException {
            st.setDate(1, (Date) discount.getEffectiveTo());
            st.setInt(2, discount.getDiscountPercent());
            st.setLong(3, discount.getId());

            if (discount.getId() != null) {
                st.setLong(4, discount.getId());
            }
        }
    };

    @Override
    public Discount getById(Long id) throws DAOException {
        return super.getById(id, discountMapper, SQL_GET_DISCOUNT_BY_ID);
    }

    @Override
    public Discount update(Discount discount) throws DAOException {
        super.update(discount, discountMapper, SQL_UPDATE_DISCOUNT_BY_ID);
        return getById(discount.getId());
    }

    @Override
    public boolean delete(Long id) throws DAOException {
        return super.remove(id, SQL_DELETE_DISCOUNT_BY_ID);

    }

    @Override
    public boolean create(Discount discount) throws DAOException {
        return super.update(discount, discountMapper, SQL_CREATE_DISCOUNT);
    }

    public List<Discount> getAllUsers() throws DAOException {
        return super.findAll(discountMapper, SQL_GET_ALL);
    }
}
