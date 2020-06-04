package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Activity service i.
 */
public interface ActivityServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Activity> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Activity> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Activity> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save activity.
     *
     * @param activity the activity
     * @return the activity
     */
    Activity save (Activity activity);

    /**
     * Update activity.
     *
     * @param activity the activity
     * @return the activity
     */
    Activity update(Activity activity);

    /**
     * Find by project list.
     *
     * @param project the project
     * @return the list
     */
//
    List<Activity> findByProject(Project project);
}
