package com.management.risk.repositories;

import com.management.risk.models.Identification.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepo extends JpaRepository<TeamMember, Long> {


}
