package org.example.controller;

import org.example.Models.Project;
import org.example.Models.Task;
import org.example.Models.Milestone;
import org.example.Models.ActivityLog;
import org.example.Services.ProjectManagerService;

import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

public class ProjectManagerController {
    private Scanner sc;
    private ProjectManagerService project_manager_service;

    public ProjectManagerController(ProjectManagerService project_manager_service) {
        this.project_manager_service = project_manager_service;
        sc = new Scanner(System.in);
    }



    public void projectManager() throws SQLException {
        int choice;
        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Reset Password  ||  2) Manage Client Info  ||  3) Add Team Members to Project  ||  4) Assign Tasks  ||  5) Create Milestone  ||  6) Create Activity Log  ||  7) removeTeamMembersFromProject  ||  8) updateTaskStatusAndTimeline  ||  9) Logout ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Enter Your Option : ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            if (choice > 0 && choice < 10) {
                switch (choice) {
                    case 1:
                        resetPassword();
                        break;
                    case 2:
                        manageClientInfo();
                        break;
                    case 3:
                        addTeamMembersToProject();
                        break;
                    case 4:
                        assignTasks();
                        break;
                    case 5:
                        createMilestone();
                        break;
                    case 6:
                        createActivityLog();
                        break;
                    case 7:
                        removeTeamMembersFromProject();
                        break;
                    case 8:
                        updateTaskStatusAndTimeline();
                        break;
                    case 9:
                        System.out.println("Logout Successful");
                        return;
                }
            } else {
                System.out.println("Invalid Option !!!");
            }
        }
    }

    private void resetPassword() throws SQLException {
        System.out.print("Enter User Email: ");
        String email = sc.next();
        System.out.print("Enter New Password: ");
        String newPassword = sc.next();
        if (project_manager_service.resetPassword(email, newPassword)) {
            System.out.println("Password Reset Successfully");
        } else {
            System.out.println("Failed to Reset Password");
        }
    }

    private void manageClientInfo() throws SQLException {
        System.out.print("Enter Project ID: ");
        int projectId = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Project Name: ");
        String projectName = sc.nextLine();
        System.out.print("Enter Project Description: ");
        String description = sc.nextLine();
        System.out.print("Enter Client Name: ");
        String clientName = sc.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = sc.nextLine();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = sc.nextLine();

        Project project = new Project();
        project.setProject_id(projectId);
        project.setProject_name(projectName);
        project.setProject_description(description);
        project.setClient_name(clientName);
        project.setProject_start_date(Date.valueOf(startDate));
        project.setProject_due_date(Date.valueOf(endDate));

        if (project_manager_service.manageClientInfo(project)) {
            System.out.println("Client Info Managed Successfully");
        } else {
            System.out.println("Failed to Manage Client Info");
        }
    }

    private void addTeamMembersToProject() throws SQLException {
        System.out.print("Enter Project ID: ");
        int projectId = sc.nextInt();
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        if (project_manager_service.addTeamMemberToProject(projectId, userId)) {
            System.out.println("Team Member Added Successfully");
        } else {
            System.out.println("Failed to Add Team Member");
        }
    }

    private void assignTasks() throws SQLException {
        System.out.print("Enter Project ID: ");
        int projectId = sc.nextInt();
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Task Description: ");
        String description = sc.nextLine();
        System.out.print("Enter Task Status (Pending, InProgress, Completed): ");
        String status = sc.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = sc.nextLine();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = sc.nextLine();

        Task task = new Task();
        task.setProject_id(projectId);
        task.setAssigned_to(userId);
        task.setTask_name(title);
        task.setTask_description(description);
        task.setTask_status(status);
        task.setTask_start_date(Date.valueOf(startDate));
        task.setTask_due_date(Date.valueOf(endDate));

        if (project_manager_service.assignTask(task)) {
            System.out.println("Task Assigned Successfully");
        } else {
            System.out.println("Failed to Assign Task");
        }
    }

    private void createMilestone() throws SQLException {
        System.out.print("Enter Project ID: ");
        int projectId = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Milestone Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Milestone Description: ");
        String description = sc.nextLine();
        System.out.print("Enter Due Date (YYYY-MM-DD): ");
        String dueDate = sc.nextLine();

        Milestone milestone = new Milestone();
        milestone.setProject_id(projectId);
        milestone.setMilestone_name(name);
        milestone.setMilestone_description(description);
        milestone.setMilestone_due_date(String.valueOf(Date.valueOf(dueDate)));

        if (project_manager_service.createMilestone(milestone)) {
            System.out.println("Milestone Created Successfully");
        } else {
            System.out.println("Failed to Create Milestone");
        }
    }

    private void createActivityLog() throws SQLException {
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter Activity Type: ");
        String activityType = sc.nextLine();
        System.out.print("Enter Activity Description: ");
        String activityDescription = sc.nextLine();

        ActivityLog log = new ActivityLog();
        log.setUser_id(userId);
        log.setActivity_type(activityType);
        log.setActivity_description(activityDescription);
        log.setTimestamp(new Timestamp(System.currentTimeMillis()));

        if (project_manager_service.createActivityLog(log)) {
            System.out.println("Activity Log Created Successfully");
        } else {
            System.out.println("Failed to Create Activity Log");
        }
    }

    private void updateTaskStatusAndTimeline() throws SQLException {
        System.out.print("Enter Task ID: ");
        int taskId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Task Status (Pending, InProgress, Completed): ");
        String status = sc.nextLine();
        System.out.print("Enter Progress Description: ");
        String progressDescription = sc.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDateStr = sc.nextLine();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDateStr = sc.nextLine();

        Date startDate = Date.valueOf(startDateStr);
        Date endDate = Date.valueOf(endDateStr);

        if (project_manager_service.updateTaskStatusAndTimeline(taskId, status, progressDescription, startDate, endDate)) {
            System.out.println("Task Status and Timeline Updated Successfully");
        } else {
            System.out.println("Failed to Update Task Status and Timeline");
        }
    }

    private void removeTeamMembersFromProject() throws SQLException {
        System.out.print("Enter Project ID: ");
        int projectId = sc.nextInt();
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        if (project_manager_service.removeUserFromProject(projectId, userId)) {
            System.out.println("Team Member Removed Successfully");
        } else {
            System.out.println("Failed to Remove Team Member");
        }
    }
}
