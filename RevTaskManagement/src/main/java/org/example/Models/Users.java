package org.example.Models;



public class Users {

    private int user_id;
    private String user_name;
    private String user_password;
    private String email;
    private String first_name;
    private String last_name;
    private String user_role;
    private String user_account_status;

    public Users(){
    }

    public Users(int user_id, String user_name, String user_password, String email, String first_name, String last_name, String user_role, String user_account_status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_role = user_role;
        this.user_account_status = user_account_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_account_status() {
        return user_account_status;
    }

    public void setUser_account_status(String user_account_status) {
        this.user_account_status = user_account_status;
    }
}





