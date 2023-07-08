package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class CartItemDAO extends jdbc.DBConnect{
    public Product getProductInfo(int cartId, int cartItemId) {
        ProductDAO pdao = new ProductDAO();
        String sql = "select productId"
                + " from CartItem"
                + " where cartId = ? and id = ?";
        int proId = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cartId);
            statement.setInt(2, cartItemId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                proId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (proId != -1) {
            return pdao.getById(proId);
        }
        return null;
    }
}
