package org.example;

import org.example.controller.UserController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            UserController userController = new UserController();
            userController.loginUser();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}