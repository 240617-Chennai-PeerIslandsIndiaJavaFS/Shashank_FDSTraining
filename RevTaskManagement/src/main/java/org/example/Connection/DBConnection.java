package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection con;
    private String url="jdbc:mysql://localhost:3306/management";
    private String username="root";
    private String pwd="Shashank@2000";
    public static DBConnection dbConn;

    private DBConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(url, username, pwd);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }

    }

    public static void setConnection(Connection connection) {
    }

    public Connection getConnection(){

        return con;
    }
    public static DBConnection getInstance() throws SQLException {
        dbConn=new DBConnection();
        return dbConn;
    }
}