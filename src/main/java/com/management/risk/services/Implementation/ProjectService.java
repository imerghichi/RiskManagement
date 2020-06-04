package com.management.risk.services.Implementation;

import com.management.risk.Identification.Project;
import com.management.risk.repositories.ProjectRepo;
import com.management.risk.services.Interfaces.ProjectServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Project service.
 */
@Service
public class ProjectService implements ProjectServiceI {
    /**
     * The Project repo.
     */
    @Autowired
    private ProjectRepo projectRepo;


    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Project> findAll(Sort sort) {
        return projectRepo.findAll();
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Project> findById(long id) {
        return projectRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        projectRepo.deleteById(id);
    }

    /**
     * Save project.
     *
     * @param project the project
     * @return the project
     */
    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    /**
     * Update project.
     *
     * @param project the project
     * @return the project
     */
    @Override
    public Project update(Project project) {
        return projectRepo.save(project);
    }
}
