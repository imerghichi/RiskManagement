package com.management.risk.services.Implementation;

import com.management.risk.models.Identification.Project;
import com.management.risk.models.Identification.TeamMember;
import com.management.risk.repositories.TeamMemberRepo;
import com.management.risk.services.Interfaces.TeamMemberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamMemberService implements TeamMemberServiceI {
    @Autowired
    private TeamMemberRepo teamMemberRepo;

    @Override
    public List<TeamMember> findAll() {
        return teamMemberRepo.findAll();
    }

    @Override
    public List<TeamMember> findAll(Sort sort) {
        return teamMemberRepo.findAll(sort);
    }

    @Override
    public Optional<TeamMember> findById(long id) {
        return teamMemberRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        teamMemberRepo.deleteById(id);
    }

    @Override
    public TeamMember save(TeamMember teamMember) {
        return teamMemberRepo.save(teamMember);
    }

    @Override
    public List<TeamMember> findByProject(Project project) {
        List<TeamMember> teamMembers = teamMemberRepo.findAll();
        List<TeamMember> res = new ArrayList<>();
        for (TeamMember teamMember:
                teamMembers) {
            if(teamMember.getProject() == project)
                res.add(teamMember);
        }
        return res;
    }
}
