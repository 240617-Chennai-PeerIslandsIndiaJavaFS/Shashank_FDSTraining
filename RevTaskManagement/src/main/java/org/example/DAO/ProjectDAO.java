package org.example.DAO;

import org.example.Connection.DBConnection;
import org.example.Models.Project;

import java.sql.*;

public class ProjectDAO {
    private Connection connection;

    public ProjectDAO() throws SQLException {
        connection = DBConnection.getInstance().getConnection();
    }

    public Project getProjectById(int projectId) throws SQLException {
        String query = "SELECT * FROM projects WHERE project_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, projectId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Project project = new Project();
            project.setProject_id(rs.getInt("project_id"));
            project.setProject_name(rs.getString("project_name"));
            project.setProject_description(rs.getString("description"));
            project.setClient_name(rs.getString("client_name"));
            project.setProject_start_date(rs.getDate("start_date"));
            project.setProject_due_date(rs.getDate("end_date"));
            return project;
        }
        return null;
    }

    public boolean updateProject(Project project) throws SQLException {
        String query = "UPDATE projects SET project_name=?, description=?, client_name=?, start_date=?, end_date=? WHERE project_id=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, project.getProject_name());
        pstmt.setString(2, project.getProject_description());
        pstmt.setString(3, project.getClient_name());
        pstmt.setDate(4, project.getProject_start_date());
        pstmt.setDate(5, project.getProject_due_date());
        pstmt.setInt(6, project.getProject_id());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }

    public boolean addUserToProject(int projectId, int userId) throws SQLException {
        String query = "INSERT INTO userprojectrole (project_id, user_id) VALUES (?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, projectId);
        pstmt.setInt(2, userId);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
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
