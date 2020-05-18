package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.Project;
import com.management.risk.models.Identification.Risk;

import java.util.List;
import java.util.Optional;

public interface ProjectServiceI {
    List<Project> getAllProjects();
    Optional<Project> getProjectbyId(long id);
    void updateproject(Project project);
    void deleteprojectbyid(long id);
    void deleteproject(Project project);
    void saveproject(Project project);

}
