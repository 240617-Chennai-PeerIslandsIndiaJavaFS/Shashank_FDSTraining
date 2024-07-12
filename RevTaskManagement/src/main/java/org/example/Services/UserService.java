package org.example.Services;

import org.example.DAO.UserDAO;
import org.example.Models.Users;

import java.sql.SQLException;

public class UserService{
    UserDAO user_dao;
    private AdminService admin_service;



    public UserService() throws SQLException, ClassNotFoundException {
        user_dao = new UserDAO();
        admin_service=new AdminService(user_dao);
    }



    public Users loginUser(String email, String password) throws SQLException {
        Users
                user = user_dao.getByEmail(email);
        if(user != null)
            if(user.getUser_password().equals(password))
                return user;
        return null;
    }

    public String getUserRoleById(int id) throws SQLException {
        Users user = user_dao.getUserById(id);
        if (user != null) {
            return user.getUser_role();
        }
        return null;
    }


    public AdminService getAdminService() {
        return admin_service;
    }

    public UserDAO getUserDAO() {
        return user_dao;
    }
}


