package org.example.Services;

import org.example.DAO.ProjectDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.TaskUpdateDAO;
import org.example.Models.Project;
import org.example.Models.Task;
import org.example.Models.TaskUpdate;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TeamMemberService {
    private ProjectDAO project_dao;
    private TaskDAO task_dao;
    private TaskUpdateDAO task_update_dao;

    public TeamMemberService(ProjectDAO project_dao, TaskDAO task_dao,TaskUpdateDAO task_update_dao) {
        this.project_dao = project_dao;
        this.task_dao = task_dao;
        this.task_update_dao=task_update_dao;
    }

    public Project viewProjectDetails(int projectId) throws SQLException {
        return project_dao.getProjectById(projectId);
    }

    public List<Task> getTasksByUserId(int userId) throws SQLException {
        return task_dao.getTasksByUserId(userId);
    }

    public boolean updateTaskStatus(int taskId, String status, String progressDescription) throws SQLException {
        TaskUpdate taskUpdate = new TaskUpdate();
        taskUpdate.setTask_id(taskId);
        taskUpdate.setTask_update_status(status);
        taskUpdate.setProgress_description(progressDescription);
        taskUpdate.setUpdated_at(new Timestamp(System.currentTimeMillis()));

        return task_update_dao.createTaskUpdate(taskUpdate) && task_dao.updateTaskStatus(taskId, status, progressDescription);
    }
}
