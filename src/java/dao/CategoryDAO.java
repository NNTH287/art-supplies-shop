package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

public class CategoryDAO extends jdbc.DBConnect {
    public Vector<Category> getAll() {
        Vector<Category> categories = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Category]";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                categories.add(new Category(id, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public int getNumberOfProductsIn(int cateId) {
        int cnt = 0;
        String sql = "SELECT COUNT([id]) as numberOfProducts\n"
                + "  FROM [dbo].[Product]\n"
                + "  where categoryId = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, cateId);
            ResultSet rs = preState.executeQuery();
            rs.next();
            cnt = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }
}
