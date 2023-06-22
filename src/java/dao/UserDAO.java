package dao;

import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends jdbc.DBConnect {
    public ResultSet getAll() {
        String sql = "SELECT [id]\n"
                + "      ,[role]\n"
                + "      ,[firstName]\n"
                + "      ,[lastName]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[User]";
        ResultSet rs = getData(sql);
        return rs;
    }
    
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        ResultSet rs = dao.getAll();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String role = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String email = rs.getString(5);
                String password = rs.getString(6);            
                String phone = rs.getString(7);
                User u = new User(id, role, firstName, lastName, email, password, phone);
                System.out.println(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
