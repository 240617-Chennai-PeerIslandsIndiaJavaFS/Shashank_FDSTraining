package org.example.Models;

public class Milestone {
    private int milestone_id;
    private int project_id;
    private String milestone_name;
    private String milestone_description;
    private String milestone_due_date;

    public Milestone(){


    }

    public Milestone(int milestone_id, int project_id, String milestone_name, String milestone_description, String milestone_due_date) {
        this.milestone_id = milestone_id;
        this.project_id = project_id;
        this.milestone_name = milestone_name;
        this.milestone_description = milestone_description;
        this.milestone_due_date = milestone_due_date;
    }

    public int getMilestone_id() {
        return milestone_id;
    }

    public void setMilestone_id(int milestone_id) {
        this.milestone_id = milestone_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getMilestone_name() {
        return milestone_name;
    }

    public void setMilestone_name(String milestone_name) {
        this.milestone_name = milestone_name;
    }

    public String getMilestone_description() {
        return milestone_description;
    }

    public void setMilestone_description(String milestone_description) {
        this.milestone_description = milestone_description;
    }

    public String getMilestone_due_date() {
        return milestone_due_date;
    }

    public void setMilestone_due_date(String milestone_due_date) {
        this.milestone_due_date = milestone_due_date;
    }

}
