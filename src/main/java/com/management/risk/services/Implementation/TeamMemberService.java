package com.management.risk.services.Implementation;

import com.management.risk.Identification.Project;
import com.management.risk.Identification.TeamMember;
import com.management.risk.repositories.TeamMemberRepo;
import com.management.risk.services.Interfaces.TeamMemberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Team member service.
 */
@Service
public class TeamMemberService implements TeamMemberServiceI {
    /**
     * The Team member repo.
     */
    @Autowired
    private TeamMemberRepo teamMemberRepo;

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<TeamMember> findAll() {
        return teamMemberRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<TeamMember> findAll(Sort sort) {
        return teamMemberRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<TeamMember> findById(long id) {
        return teamMemberRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        teamMemberRepo.deleteById(id);
    }

    /**
     * Save team member.
     *
     * @param teamMember the team member
     * @return the team member
     */
    @Override
    public TeamMember save(TeamMember teamMember) {
        return teamMemberRepo.save(teamMember);
    }

    /**
     * Find by project list.
     *
     * @param project the project
     * @return the list
     */
    @Override
    public List<TeamMember> findByProject(Project project) {
        List<TeamMember> teamMembers = teamMemberRepo.findAll();
        List<TeamMember> res = new ArrayList<>();
        for (TeamMember teamMember:
                teamMembers) {
            if(teamMember.getProject().contains(project))
                res.add(teamMember);
        }
        return res;
    }

    /**
     * Update team member.
     *
     * @param teamMember the team member
     * @return the team member
     */
    @Override
    public TeamMember update(TeamMember teamMember) {
        return teamMemberRepo.save(teamMember);
    }
}
