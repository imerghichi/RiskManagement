package com.management.risk.services.Interfaces;


import com.management.risk.Identification.Project;
import com.management.risk.Identification.TeamMember;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Team member service i.
 */
public interface TeamMemberServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<TeamMember> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<TeamMember> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<TeamMember> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save team member.
     *
     * @param teamMember the team member
     * @return the team member
     */
    TeamMember save (TeamMember teamMember);

    /**
     * Update team member.
     *
     * @param teamMember the team member
     * @return the team member
     */
    TeamMember update (TeamMember teamMember);

    /**
     * Find by project list.
     *
     * @param project the project
     * @return the list
     */
//
    List<TeamMember> findByProject(Project project);
}
