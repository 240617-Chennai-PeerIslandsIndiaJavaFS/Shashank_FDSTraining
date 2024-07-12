package org.example.controller;

import org.example.DAO.UserDAO;
import org.example.Models.Users;

import org.example.Services.UserService;
import org.example.Services.AdminService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminController {
    private Scanner sc;
    private Users user;
    private AdminService admin_service;
    private UserDAO userdao;

    public AdminController(UserService user_service) {
        this.admin_service = user_service.getAdminService();
        this.userdao = user_service.getUserDAO();
        this.sc = new Scanner(System.in);  // Ensure Scanner is initialized
    }

    public void adminUser() throws SQLException {
        int choice;
        System.out.println();
        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Create User  ||  2) Update User  ||  3) Deactivate User  ||  4) Change Role  ||  5) Manage Access Levels  ||  6) View Reports  ||  7) Logout ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Enter Your Option : ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            if (choice > 0 && choice < 8) {
                switch (choice) {
                    case 1:
                        registration();
                        break;
                    case 2:
                        updateUserDetails();
                        break;
                    case 3:
                        deactivateUser();
                        break;
                    case 4:
                        changeRole();
                        break;
                    case 5:
                        manageAccessLevels();
                        break;
                    case 6:
                        viewReports();
                        break;
                    case 7:
                        user = null;
                        System.out.println("Logout Successful");
                        return;
                }
            } else {
                System.out.println("Invalid Option !!!");
            }
        }
    }

    private void manageAccessLevels() {
        System.out.println("Managing Access Levels...");
    }

    private void viewReports() {
        System.out.println("Viewing Reports...");
    }

    private void registration() throws SQLException {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Registration Page: ");
        System.out.println();
        Users user = new Users();
        System.out.print("Enter User Name : ");
        user.setUser_name(sc.nextLine());
        System.out.print("Enter User Email : ");
        user.setEmail(sc.nextLine());
        System.out.print("Enter User Password : ");
        user.setUser_password(sc.nextLine());
        System.out.print("Enter User first_name : ");
        user.setFirst_name(sc.nextLine());
        System.out.print("Enter User last_name : ");
        user.setLast_name(sc.nextLine());
        System.out.print("Enter User Role (\"Admin\",\"ProjectManager\",\"User\"): ");
        user.setUser_role(sc.nextLine());
        System.out.println("Enter your status : ");
        user.setUser_account_status(sc.nextLine());
        if (userdao.createUser(user))
            System.out.println("Registration Successful");
        else {
            System.out.println("Please Enter Valid Details !");
            registration();
        }
    }

    private void updateUserDetails() throws SQLException {
        int choice;
        String option = "yes";
        Users user_update = getUserNameForModifications();

        while (option.toLowerCase().equals("yes")) {
            System.out.println();
            System.out.print("Select the Details wants to Update :\n 1) Name  2) email 3) Password  4) phone  :");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            if (choice < 1 || choice > 4) {
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter Name : ");
                    user_update.setUser_name(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter Email : ");
                    user_update.setEmail(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Password : ");
                    user_update.setUser_password(sc.nextLine());
                    break;
            }

            System.out.print("Do you want to Continue Update Other Details of User (type Yes or No): ");
            option = sc.nextLine();
        }

        if (admin_service.updateUser(user_update))
            System.out.println("Updated Successfully");
        else
            System.out.println("Updated Failed");
    }

    private void deactivateUser() throws SQLException {
        Users user_deactivate = getUserNameForModifications();
        user_deactivate.setUser_account_status("InActive");
        if (admin_service.updateUser(user_deactivate))
            System.out.println("Deactivated Successfully");
        else
            System.out.println("Deactivation Failed");
    }

    private void changeRole() throws SQLException {
        Users user_role_change = getUserNameForModifications();
        System.out.print("Enter  Role (\"Admin\",\"ProjectManager\",\"User\"): ");
        user_role_change.setUser_role(sc.nextLine());
        if (admin_service.updateUser(user_role_change))
            System.out.println("Role Changed Successfully");
        else
            System.out.println("Role not changed");
    }

    private Users getUserNameForModifications() throws SQLException {
        Users user_operation;
        while (true) {
            System.out.print("Enter the User Name for modification: ");
            user_operation = admin_service.getUserByName(sc.nextLine());
            if (user_operation != null)
                break;
            System.out.println("Please Enter Valid User Name");
        }
        return user_operation;
    }

    public void deleteUser() throws SQLException {
        Users user = new Users();
        System.out.print("enter user id to delete : ");
        user.setUser_id(sc.nextInt());
        sc.nextLine();  // Consume newline
        if (admin_service.deleteUser(user))
            System.out.println("Deleted successfully");
        else
            System.out.println("not deleted");
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
