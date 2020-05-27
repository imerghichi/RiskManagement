package com.management.risk.Identification;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_team_member;
    @ManyToOne
    private Project project;

    public long getId_team_member() {
        return id_team_member;
    }

    public void setId_team_member(long id_team_member) {
        this.id_team_member = id_team_member;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
