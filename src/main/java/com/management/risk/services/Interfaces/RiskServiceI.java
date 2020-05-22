package com.management.risk.services.Interfaces;


import com.management.risk.models.Identification.Activity;
import com.management.risk.models.Identification.Project;
import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Identification.TeamMember;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface RiskServiceI {
    List<Risk> findAll();
    List<Risk> findAll(Sort sort);
    Optional<Risk> findById (long id);
    void deleteById (long id);
    Risk save (Risk risk);

    //
    List<Risk> findByActivity(Activity activity);
    List<Risk> findByProject(Project project);
    List<Risk> findByTeamMember(TeamMember teamMember);

}
