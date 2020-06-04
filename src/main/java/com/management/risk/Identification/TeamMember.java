package com.management.risk.Identification;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * The type Team member.
 */
@Data
@Entity
public class TeamMember {
    /**
     * The Id team member.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_team_member;
    /**
     * The First name.
     */
    @Column(nullable = false)
    private String first_name;
    /**
     * The Last name.
     */
    @Column(nullable = false)
    private String last_name;
    /**
     * The Project.
     */
//private long CIN;
    @ManyToMany
    private List<Project> project;

    /**
     * Gets id team member.
     *
     * @return the id team member
     */
    public long getId_team_member() {
        return id_team_member;
    }

    /**
     * Sets id team member.
     *
     * @param id_team_member the id team member
     */
    public void setId_team_member(long id_team_member) {
        this.id_team_member = id_team_member;
    }

    /**
     * Gets project.
     *
     * @return the project
     */
    public List<Project> getProject() {
        return project;
    }

    /**
     * Sets project.
     *
     * @param project the project
     */
    public void setProject(List<Project> project) {
        this.project = project;
    }
}
