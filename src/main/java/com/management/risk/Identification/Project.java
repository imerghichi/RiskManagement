package com.management.risk.Identification;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * The type Project.
 */
@Data
@Entity
public class Project {
    /**
     * The Id project.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_project;
    /**
     * The Project name.
     */
    @Column(unique = true,nullable = false)
    private String project_name;
    /**
     * The Project description.
     */
    private String project_description;
    /**
     * The Team members.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TeamMember> teamMembers;
    /**
     * The Task projects.
     */
    @OneToMany(fetch = FetchType.EAGER)
    private List<Activity> taskProjects;
    /**
     * The Portfolio.
     */
    @OneToOne
    private Portfolio portfolio;

    /**
     * Gets team members.
     *
     * @return the team members
     */
    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    /**
     * Sets team members.
     *
     * @param teamMembers the team members
     */
    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }


    /**
     * Gets id project.
     *
     * @return the id project
     */
    public long getId_project() {
        return id_project;
    }

    /**
     * Sets id project.
     *
     * @param id_project the id project
     */
    public void setId_project(long id_project) {
        this.id_project = id_project;
    }

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getProject_name() {
        return project_name;
    }

    /**
     * Sets project name.
     *
     * @param project_name the project name
     */
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    /**
     * Instantiates a new Project.
     *
     * @param id_project the id project
     */
    public Project(long id_project) {
        this.id_project = id_project;
    }

    /**
     * Instantiates a new Project.
     */
    public Project() {
    }
}
