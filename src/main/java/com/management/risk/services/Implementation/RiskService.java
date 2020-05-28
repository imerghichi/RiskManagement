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

@Service
public class RiskService implements RiskServiceI {
    @Autowired
    private Riskrepo riskrepo;


    @Override
    public List<Risk> findAll() {
        return riskrepo.findAll();
    }

    @Override
    public List<Risk> findAll(Sort sort) {
        return riskrepo.findAll(sort);
    }

    @Override
    public Optional<Risk> findById(long id) {
        return riskrepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        riskrepo.deleteById(id);
    }

    @Override
    public Risk save(Risk risk) {
        return riskrepo.save(risk);
    }

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

    @Override
    public List<Risk> findByTeamMember(TeamMember teamMember) {
        List<Risk> risks = riskrepo.findAll();
        List<Risk> res = new ArrayList<>();
        for (Risk risk:
                risks) {
            if(risk.getIdetifier_risk() == teamMember)
                res.add(risk);
        }
        return res;
    }

    @Override
    public Risk update(Risk risk) {
        return riskrepo.save(risk);
    }
}
