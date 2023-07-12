package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

public class OrderDAO extends jdbc.DBConnect {
    public Vector<Order> getByUserId(int userId) {
        Vector<Order> orders = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[userId]\n"
                + "      ,[receiver]\n"
                + "      ,[shipStreet]\n"
                + "      ,[shipCity]\n"
                + "      ,[shipProvince]\n"
                + "      ,[shipCountry]\n"
                + "      ,[shipEmail]\n"
                + "      ,[shipPhone]\n"
                + "      ,[status]\n"
                + "      ,[createdTime]\n"
                + "  FROM [dbo].[Order]\n"
                + "  where userId = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt(1);
                String receiver = rs.getString(3);
                String shipStreet = rs.getString(4);
                String shipCity = rs.getString(5);
                String shipProvince = rs.getString(6);
                String shipCountry = rs.getString(7);
                String shipEmail = rs.getString(8);
                String shipPhone = rs.getString(9);
                String status = rs.getString(10);
                String createdTime = rs.getString(11).substring(0, 10);
                orders.add(new Order(orderId, userId, receiver, shipStreet, shipCity, shipProvince, shipCountry, shipEmail, shipPhone, status, createdTime));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public int addOrder(Order order) {
        int rowsAffected = 0;
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([userId]\n"
                + "           ,[receiver]\n"
                + "           ,[shipStreet]\n"
                + "           ,[shipCity]\n"
                + "           ,[shipProvince]\n"
                + "           ,[shipCountry]\n"
                + "           ,[shipEmail]\n"
                + "           ,[shipPhone]\n"
                + "           ,[status]\n"
                + "           ,[createdTime])"
                + "     VALUES\n"
                + "           (" + order.getUserId() + ", '"
                + order.getReceiver() + "', '"
                + order.getShipStreet() + "', '"
                + order.getShipCity() + "', '"
                + order.getShipProvince() + "', '"
                + order.getShipCountry() + "', '"
                + order.getShipEmail() + "', '"
                + order.getShipPhone() + "', '"
                + order.getStatus() + "', '"
                + order.getCreatedTime() + "')";
        try {
            Statement state = conn.createStatement();
            rowsAffected = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsAffected;
    }

    public static void main(String[] args) {
        OrderDAO odao = new OrderDAO();
        Vector<Order> orders = odao.getByUserId(2);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
