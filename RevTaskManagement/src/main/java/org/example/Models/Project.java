package org.example.Models;

import java.util.Date;

public class Project {
    private int project_id;
    private String project_name;
    private String project_description;
    private String client_name;
    private Date project_start_date;
    private Date project_due_date;



    public Project(){

    }

    public Project(int project_id, String project_name, String project_description, String client_name, Date project_start_date, Date project_due_date) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.client_name = client_name;
        this.project_start_date = project_start_date;
        this.project_due_date = project_due_date;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public java.sql.Date getProject_start_date() {
        return (java.sql.Date) project_start_date;
    }

    public void setProject_start_date(Date project_start_date) {
        this.project_start_date = project_start_date;
    }

    public java.sql.Date getProject_due_date() {
        return (java.sql.Date) project_due_date;
    }

    public void setProject_due_date(Date project_due_date) {
        this.project_due_date = project_due_date;
    }
}
