package com.management.risk.services.Interfaces;


import com.management.risk.Identification.Activity;
import com.management.risk.Identification.Project;
import com.management.risk.Identification.Risk;
import com.management.risk.Identification.TeamMember;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Risk service i.
 */
public interface RiskServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Risk> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Risk> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Risk> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save risk.
     *
     * @param risk the risk
     * @return the risk
     */
    Risk save (Risk risk);

    /**
     * Update risk.
     *
     * @param risk the risk
     * @return the risk
     */
    Risk update (Risk risk);

    /**
     * Find by activity list.
     *
     * @param activity the activity
     * @return the list
     */
//
    List<Risk> findByActivity(Activity activity);

    /**
     * Find by project list.
     *
     * @param project the project
     * @return the list
     */
    List<Risk> findByProject(Project project);

    /**
     * Find by team member list.
     *
     * @param teamMember the team member
     * @return the list
     */
    List<Risk> findByTeamMember(TeamMember teamMember);

}
