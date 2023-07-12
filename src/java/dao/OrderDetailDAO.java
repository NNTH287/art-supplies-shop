package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OrderDetail;

public class OrderDetailDAO extends jdbc.DBConnect {
    public Vector<OrderDetail> getByOrderId(int orderId) {
        Vector<OrderDetail> orderDetails = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[orderId]\n"
                + "      ,[productId]\n"
                + "      ,[productName]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[OrderDetail]\n"
                + "  where orderId = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int productId = rs.getInt(3);
                String productName = rs.getString(4);
                double price = rs.getDouble(5);
                int quantity = rs.getInt(6);
                orderDetails.add(new OrderDetail(id, orderId, productId, productName, price, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetails;
    }

    public int addOrderDetail(OrderDetail orderDetail) {
        int rowsAffected = 0;
        String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                + "           ([orderId]\n"
                + "           ,[productId]\n"
                + "           ,[productName]\n"
                + "           ,[price]\n"
                + "           ,[quantity])"
                + "     VALUES\n"
                + "           (" + orderDetail.getOrderId()+ ", "
                + orderDetail.getProductId()+ ", '"
                + orderDetail.getProductName()+ "', "
                + orderDetail.getPrice()+ ", "
                + orderDetail.getQuantity()+ ")";
        try {
            Statement state = conn.createStatement();
            rowsAffected = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsAffected;
    }
}
