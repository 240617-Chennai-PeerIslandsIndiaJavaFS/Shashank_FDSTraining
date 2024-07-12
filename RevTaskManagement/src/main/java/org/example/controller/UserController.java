package org.example.controller;

import org.example.DAO.*;
import org.example.Models.Users;
import org.example.Services.UserService;
import org.example.Services.ProjectManagerService;
import org.example.Services.TeamMemberService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserController {
    private Scanner sc;
    private UserService user_service;
    private AdminController admin_controller;
    private ProjectManagerController project_manager_controller;
    private TeamMemberController team_member_controller;

    public UserController() throws SQLException, ClassNotFoundException {
        sc = new Scanner(System.in);
        user_service = new UserService();
        admin_controller = new AdminController(user_service);
        ProjectDAO projectDAO = new ProjectDAO();
        TaskDAO taskDAO = new TaskDAO();
        MilestoneDAO milestonedao=new MilestoneDAO();
        ActivityLogDAO activitylogdao=new ActivityLogDAO();
        TaskUpdateDAO taskupdatedao=new TaskUpdateDAO();
        project_manager_controller = new ProjectManagerController(new ProjectManagerService(projectDAO, taskDAO, milestonedao,activitylogdao));
        team_member_controller = new TeamMemberController(new TeamMemberService(projectDAO, taskDAO,taskupdatedao));
    }

    public void loginUser() throws SQLException {
        while (true) {
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Login Page: ");
            System.out.print("Enter Your Email: ");
            String email = sc.next();
            System.out.print("Enter Your Password: ");
            String password = sc.next();
            Users user = user_service.loginUser(email, password);
            if (user != null) {
                System.out.println("Login Successful");
                System.out.println("Hi " + user.getUser_name() + ", Role: " + user.getUser_role());
                admin_controller.setUser(user);
                int id = user.getUser_id();
                displayMenuBasedOnRole(id);
                break;
            } else {
                System.out.println("------------------------------------------");
                System.out.println("Invalid Email and Password !!!");
            }
        }
    }

    public void displayMenuBasedOnRole(int id) throws SQLException {
        String user_role = user_service.getUserRoleById(id);
        switch (user_role) {
            case "Admin":
                admin_controller.adminUser();
                break;
            case "ProjectManager":
                project_manager_controller.projectManager();
                break;
            case "TeamMember":
                team_member_controller.teamMember();
                break;
            default:
                System.out.println("Invalid Role");
        }
    }
}