package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Brand;

public class BrandDAO extends jdbc.DBConnect{
    public Brand getById(int brandId) {
        Brand brand = null;
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Brand]"
                + "  where id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, brandId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                brand = new Brand(brandId, name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brand;
    }
    
    public Vector<Brand> getAll() {
        Vector<Brand> brands = new Vector<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Brand]";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                brands.add(new Brand(id, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brands;
    }

    public int getNumberOfProductsIn(int brandId) {
        int cnt = 0;
        String sql = "SELECT COUNT([id]) as numberOfProducts\n"
                + "  FROM [dbo].[Product]\n"
                + "  where brandId = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, brandId);
            ResultSet rs = preState.executeQuery();
            rs.next();
            cnt = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }
}
