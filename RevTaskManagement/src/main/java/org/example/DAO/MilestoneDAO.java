package org.example.DAO;

import org.example.Connection.DBConnection;
import org.example.Models.Milestone;
import java.sql.*;

public class MilestoneDAO {
    private Connection connection;

    public MilestoneDAO() throws SQLException {
        connection = DBConnection.getInstance().getConnection();
    }

    public boolean createMilestone(Milestone milestone) throws SQLException {
        String query = "INSERT INTO milestone (project_id, milestone_name, milestone_description, milestone_due_date) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, milestone.getProject_id());
        pstmt.setString(2, milestone.getMilestone_name());
        pstmt.setString(3, milestone.getMilestone_description());
        pstmt.setString(4, milestone.getMilestone_due_date());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }
}
