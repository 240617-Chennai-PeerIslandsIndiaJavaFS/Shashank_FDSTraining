package org.example.DAO;

import org.example.Connection.DBConnection;
import org.example.Models.Users;
import org.example.Models.Users;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws SQLException {

        connection = DBConnection.getInstance().getConnection();
    }

    public boolean createUser(Users user) throws SQLException {
        String query = "INSERT INTO users (user_name, user_password, email, first_name, last_name, user_role, user_account_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, user.getUser_name());
        pstmt.setString(2, user.getUser_password());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getFirst_name());
        pstmt.setString(5, user.getLast_name());
        pstmt.setString(6, user.getUser_role());
        pstmt.setString(7, user.getUser_account_status());
        pstmt.executeUpdate();
        return true;
    }

    public boolean updateUser(Users user) throws SQLException {
        String query = "UPDATE users SET user_name=?, user_password=?, email=?, first_name=?, last_name=?, user_role=?, user_account_status=? WHERE user_id=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, user.getUser_name());
        pstmt.setString(2, user.getUser_password());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getFirst_name());
        pstmt.setString(5, user.getLast_name());
        pstmt.setString(6, user.getUser_role());
        pstmt.setString(7, user.getUser_account_status());
        pstmt.setInt(8, user.getUser_id());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }

    public boolean deleteUser(Users user) throws SQLException {
        String query = "DELETE FROM users WHERE user_id=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, user.getUser_id());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }

    public Users getUserByName(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE user_name = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Users user = new Users();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_password(rs.getString("user_password"));
            user.setEmail(rs.getString("email"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setUser_role(rs.getString("user_role"));
            user.setUser_account_status(rs.getString("user_account_status"));
            return user;
        }
        return null;
    }

    public Users getByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Users user = new Users();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_password((rs.getString("user_password")));
            user.setEmail(rs.getString("email"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setUser_role(rs.getString("user_role"));
            user.setUser_account_status(rs.getString("user_account_status"));
            return user;
        }
        return null;
    }

    public Users getUserById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Users user = new Users();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_password(rs.getString("user_password"));
            user.setEmail(rs.getString("email"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setUser_role(rs.getString("user_role"));
            user.setUser_account_status(rs.getString("user_account_status"));
            return user;
        }
        return null;
    }

    public boolean resetPassword(String email, String newPassword) throws SQLException {
        String query = "UPDATE users SET password_hash=? WHERE email=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, newPassword);
        pstmt.setString(2, email);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }
}