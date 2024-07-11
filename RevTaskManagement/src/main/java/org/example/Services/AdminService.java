package org.example.Services;

import org.example.DAO.UserDAO;
import org.example.Models.Users;

import java.sql.SQLException;

public class AdminService {
    UserDAO user_dao;

    public AdminService(){

    }
    public AdminService(UserDAO user_dao) {

        this.user_dao = user_dao;
    }

    public Users getUserByName(String name) throws SQLException {
        return user_dao.getUserByName(name);
    }

    public boolean updateUser(Users user) throws SQLException {

        return user_dao.updateUser(user);
    }
    public boolean deleteUser(Users user) throws SQLException {
        return user_dao.deleteUser(user);
    }

}
