package org.example.Models;

import java.util.Date;

public class Task {
//(project_id, assigned_to, title_name, title_description, task_status, task_start_date, task_due_date)
    private int task_id;
    private int project_id;
    private int assigned_to;
    private String task_name;
    private String task_description;
    private String task_status;
    private Date task_start_date;
    private Date task_due_date;

    public Task(){

    }

    public Task(int task_id, int project_id, int assigned_to, String task_name, String task_description, String task_status, Date task_start_date, Date task_due_date) {
        this.task_id = task_id;
        this.project_id = project_id;
        this.assigned_to = assigned_to;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_status = task_status;
        this.task_start_date = task_start_date;
        this.task_due_date = task_due_date;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(int assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public java.sql.Date getTask_start_date() {
        return (java.sql.Date) task_start_date;
    }

    public void setTask_start_date(Date task_start_date) {
        this.task_start_date = task_start_date;
    }

    public java.sql.Date getTask_due_date() {
        return (java.sql.Date) task_due_date;
    }

    public void setTask_due_date(Date task_due_date) {
        this.task_due_date = task_due_date;
    }
}
