package com.management.risk.Identification;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_team_member;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    //private long CIN;
    @ManyToMany
    private List<Project> project;

    public long getId_team_member() {
        return id_team_member;
    }

    public void setId_team_member(long id_team_member) {
        this.id_team_member = id_team_member;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
