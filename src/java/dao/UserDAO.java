package dao;

import java.sql.PreparedStatement;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public User getByEmail(String email) {
        String sql = "SELECT [id]\n"
                + "      ,[role]\n"
                + "      ,[firstName]\n"
                + "      ,[lastName]\n"
                + "      ,[password]\n"
                + "      ,[phone]\n"
                + "  FROM [dbo].[User]"
                + " where email = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String role = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                String password = rs.getString(5);
                String phone = rs.getString(6);
                return new User(id, role, firstName, lastName, email, password, phone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addUser(User user) {
        int rowsAffected = 0;
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([role]\n"
                + "           ,[firstName]\n"
                + "           ,[lastName]\n"
                + "           ,[email]\n"
                + "           ,[password]\n"
                + "           ,[phone])\n"
                + "     VALUES\n"
                + "           ('" + user.getRole() + "', '"
                + user.getFirstName() + "', '"
                + user.getLastName() + "', '"
                + user.getEmail() + "', '"
                + user.getPassword()+ "', '"
                + user.getPhone() + "')";        
        try {
            Statement state = conn.createStatement();
            rowsAffected = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsAffected;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        System.out.println(dao.getByEmail("huyhol287@gmail.com"));
    }
}
