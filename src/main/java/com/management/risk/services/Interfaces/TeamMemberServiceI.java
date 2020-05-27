package com.management.risk.services.Interfaces;


import com.management.risk.Identification.Project;
import com.management.risk.Identification.TeamMember;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TeamMemberServiceI {
    List<TeamMember> findAll();
    List<TeamMember> findAll(Sort sort);
    Optional<TeamMember> findById (long id);
    void deleteById (long id);
    TeamMember save (TeamMember teamMember);
    //
    List<TeamMember> findByProject(Project project);
}
