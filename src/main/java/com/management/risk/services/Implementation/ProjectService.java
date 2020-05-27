package com.management.risk.services.Implementation;

import com.management.risk.Identification.Project;
import com.management.risk.repositories.ProjectRepo;
import com.management.risk.services.Interfaces.ProjectServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceI {
    @Autowired
    private ProjectRepo projectRepo;


    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public List<Project> findAll(Sort sort) {
        return projectRepo.findAll();
    }

    @Override
    public Optional<Project> findById(long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
