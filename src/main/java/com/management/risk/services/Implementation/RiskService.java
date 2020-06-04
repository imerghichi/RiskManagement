package com.management.risk.services.Implementation;


import com.management.risk.Identification.*;
import com.management.risk.repositories.Riskrepo;
import com.management.risk.services.Interfaces.RiskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Risk service.
 */
@Service
public class RiskService implements RiskServiceI {
    /**
     * The Riskrepo.
     */
    @Autowired
    private Riskrepo riskrepo;


    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Risk> findAll() {
        return riskrepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Risk> findAll(Sort sort) {
        return riskrepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Risk> findById(long id) {
        return riskrepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        riskrepo.deleteById(id);
    }

    /**
     * Save risk.
     *
     * @param risk the risk
     * @return the risk
     */
    @Override
    public Risk save(Risk risk) {
        return riskrepo.save(risk);
    }

    /**
     * Find by activity list.
     *
     * @param activity the activity
     * @return the list
     */
    @Override
    public List<Risk> findByActivity(Activity activity) {
        List<Risk> risks = riskrepo.findAll();
        List<Risk> res = new ArrayList<>();
        for (Risk risk:
                risks) {
            if(risk.getTaskProject() == activity)
                res.add(risk);
        }
        return res;
    }

    /**
     * Find by project list.
     *
     * @param project the project
     * @return the list
     */
    @Override
    public List<Risk> findByProject(Project project) {
        List<Risk> risks = riskrepo.findAll();
        List<Risk> res = new ArrayList<>();
        for (Risk risk:
                risks) {
            if(risk.getTaskProject().getProject() == project)
                res.add(risk);
        }
        return res;
    }

    /**
     * Find by team member list.
     *
     * @param teamMember the team member
     * @return the list
     */
    @Override
    public List<Risk> findByTeamMember(TeamMember teamMember) {
        List<Risk> risks = riskrepo.findAll();
        List<Risk> res = new ArrayList<>();
        for (Risk risk:
                risks) {
            if(risk.getIdentifier_risk() == teamMember)
                res.add(risk);
        }
        return res;
    }

    /**
     * Update risk.
     *
     * @param risk the risk
     * @return the risk
     */
    @Override
    public Risk update(Risk risk) {
        return riskrepo.save(risk);
    }
}
