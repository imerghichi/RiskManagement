package com.management.risk.models.Identification;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_team_member;

}
