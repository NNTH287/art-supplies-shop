package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDAO extends jdbc.DBConnect {
    public Vector<Product> getAll() {
        Vector<Product> products = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[categoryId]\n"
                + "      ,[brandId]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "      ,[price]\n"
                + "      ,[discount]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[Product]";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                int categoryId = rs.getInt(2);
                int brandId = rs.getInt(3);
                String name = rs.getString(4);
                String description = rs.getString(5);
                double price = rs.getDouble(6);
                double discount = rs.getDouble(7);
                int quantity = rs.getInt(8);
                products.add(new Product(id, categoryId, brandId, name, description, price, discount, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public Vector<Product> getByName(String name) {
        Vector<Product> products = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[categoryId]\n"
                + "      ,[suplierId]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "      ,[price]\n"
                + "      ,[discount]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[Product]"
                + " where name like ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int categoryId = rs.getInt(2);
                int brandId = rs.getInt(3);
                String productName = rs.getString(4);
                String description = rs.getString(5);
                double price = rs.getDouble(6);
                double discount = rs.getDouble(7);
                int quantity = rs.getInt(8);
                products.add(new Product(id, categoryId, brandId, productName, description, price, discount, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        
        Vector<Product> products = dao.getByName("White");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
