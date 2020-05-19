package com.management.risk.services.Implementation;

import com.management.risk.models.Identification.Project;
import com.management.risk.services.Interfaces.ProjectServiceI;

import java.util.List;
import java.util.Optional;

public class ProjectService implements ProjectServiceI {
    //@todo imple
    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Optional<Project> getProjectbyId(long id) {
        return Optional.empty();
    }

    @Override
    public void updateproject(Project project) {

    }

    @Override
    public void deleteprojectbyid(long id) {

    }

    @Override
    public void deleteproject(Project project) {

    }

    @Override
    public void saveproject(Project project) {

    }
}
