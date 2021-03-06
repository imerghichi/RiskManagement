package com.management.risk.repositories;

import com.management.risk.Identification.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Team member repo.
 */
@Repository
public interface TeamMemberRepo extends JpaRepository<TeamMember, Long> {

}
