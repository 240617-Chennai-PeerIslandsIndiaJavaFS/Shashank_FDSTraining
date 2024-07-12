package org.example.Models;

import java.sql.Timestamp;

public class TaskUpdate {

    private int update_id;
    private int task_id;
    private int user_id;
    private String task_update_status;
    private String progress_description;
    private Timestamp updated_at;

    public TaskUpdate(){

    }

    public TaskUpdate(int update_id, int task_id, int user_id, String task_update_status, String progress_description, Timestamp updated_at) {
        this.update_id = update_id;
        this.task_id = task_id;
        this.user_id = user_id;
        this.task_update_status = task_update_status;
        this.progress_description = progress_description;
        this.updated_at = updated_at;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTask_update_status() {
        return task_update_status;
    }

    public void setTask_update_status(String task_update_status) {
        this.task_update_status = task_update_status;
    }

    public String getProgress_description() {
        return progress_description;
    }

    public void setProgress_description(String progress_description) {
        this.progress_description = progress_description;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
