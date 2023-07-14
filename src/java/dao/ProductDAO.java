package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDAO extends jdbc.DBConnect {
    public Product getById(int proId) {
        Product product = null;
        String sql = "SELECT [id]\n"
                + "      ,[categoryId]\n"
                + "      ,[brandId]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "      ,[price]\n"
                + "      ,[discount]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[Product]"
                + " where id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, proId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt(2);
                int brandId = rs.getInt(3);
                String productName = rs.getString(4);
                String description = rs.getString(5);
                double price = rs.getDouble(6);
                double discount = rs.getDouble(7);
                int quantity = rs.getInt(8);
                product = new Product(proId, categoryId, brandId, productName, description, price, discount, quantity);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

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
                + "      ,[brandId]\n"
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

    public Vector<Product> filterProducts(int cateId, int braId, double minPrice, double maxPrice, String sale) {
        Vector<Product> products = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[categoryId]\n"
                + "      ,[brandId]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "      ,[price]\n"
                + "      ,[discount]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where categoryId in (" + (cateId == -1 ? "select id from Category" : "?") + ")\n"
                + "	and brandId in (" + (braId == -1 ? "select id from Brand" : "?") + ")\n"
                + "	and price between ? and ?"
                + (sale.endsWith("ON_SALE") ? "     and discount > 0" : "");
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            if (cateId == -1 && braId == -1) { //No filter by both category and brand
                statement.setDouble(1, minPrice);
                statement.setDouble(2, maxPrice);
            } else if (cateId == -1 || braId == -1) {//Filter either category or brand
                if (cateId != -1) {
                    statement.setInt(1, cateId);
                } else {
                    statement.setInt(1, braId);
                }
                statement.setDouble(2, minPrice);
                statement.setDouble(3, maxPrice);
            } else {//Filter by both category and brand
                statement.setInt(1, cateId);
                statement.setInt(2, braId);
                statement.setDouble(3, minPrice);
                statement.setDouble(4, maxPrice);
            }
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

    public Vector<Product> getRelatedProducts(Product product) {
        Vector<Product> relatedProducts = new Vector<>();
        int cateId = product.getCategoryId();
        int braId = product.getBrandId();
        String sql = "SELECT [id]\n"
                + "      ,[categoryId]\n"
                + "      ,[brandId]\n"
                + "      ,[name]\n"
                + "      ,[description]\n"
                + "      ,[price]\n"
                + "      ,[discount]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[Product]"
                + " where (categoryId = ? or brandId = ?) and id != ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cateId);
            statement.setInt(2, braId);
            statement.setInt(3, product.getId());
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
                relatedProducts.add(new Product(id, categoryId, brandId, productName, description, price, discount, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatedProducts;
    }

    public int updateProduct(Product product) {
        int rowsAffected = 0;
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [categoryId] = ?\n"
                + "      ,[brandId] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[discount] = ?\n"
                + "      ,[quantity] = ?"
                + " WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product.getCategoryId());
            pre.setInt(2, product.getBrandId());
            pre.setString(3, product.getName());
            pre.setString(4, product.getDescription());
            pre.setDouble(5, product.getPrice());
            pre.setDouble(6, product.getDiscount());
            pre.setInt(7, product.getQuantity());
            pre.setInt(8, product.getId());
            int affectedRows = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsAffected;
    }

    public int deleteProduct(Product product) {
        int rowsAffected = 0;
        String sql = "DELETE FROM [dbo].[Product]\n"
                + " WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product.getId());
            int affectedRows = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsAffected;
    }

    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//
//        Vector<Product> products = dao.getRelatedProducts(new Product(7, 2, 4, "t", "t", 0, 0, 1));
//        for (Product product : products) {
//            System.out.println(product);
//        }
    }
}
