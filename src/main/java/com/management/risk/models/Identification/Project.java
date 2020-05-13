package com.management.risk.models.Identification;

import java.util.LinkedList;
import java.util.List;

public class Project {
    private long id_project;
    private String project_name;
    private List<TeamMember> teamMembers;
    private LinkedList<Activity> taskProjects;

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }


    public long getId_project() {
        return id_project;
    }

    public void setId_project(long id_project) {
        this.id_project = id_project;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Project(long id_project) {
        this.id_project = id_project;
    }

}
