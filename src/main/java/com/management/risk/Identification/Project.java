package com.management.risk.Identification;



import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_project;
    private String project_name;
    @OneToMany
    private List<TeamMember> teamMembers;
    @OneToMany
    private List<Activity> taskProjects;
    @OneToOne
    private Portfolio portfolio;
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

    public Project() {
    }
}
