package com.management.risk.services.Interfaces;


import com.management.risk.Identification.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Project service i.
 */
public interface ProjectServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Project> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Project> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Project> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save project.
     *
     * @param project the project
     * @return the project
     */
    Project save (Project project);

    /**
     * Update project.
     *
     * @param project the project
     * @return the project
     */
    Project update (Project project);

}
