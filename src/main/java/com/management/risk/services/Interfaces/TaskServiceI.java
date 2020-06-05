package com.management.risk.services.Interfaces;

import com.management.risk.Mitigation.Milstone;
import com.management.risk.Mitigation.Response;
import com.management.risk.Mitigation.Task;
import com.management.risk.Mitigation.Trigger;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Task service i.
 */
public interface TaskServiceI {
    List<Task> findByResponse(Response response);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Task> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Task> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Task> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save task.
     *
     * @param task the task
     * @return the task
     */
    Task save (Task task);

    /**
     * Save milstone.
     *
     * @param milstone the milstone
     * @return the milstone
     */
//
    Milstone save (Milstone milstone);

    /**
     * Save trigger.
     *
     * @param trigger the trigger
     * @return the trigger
     */
    Trigger save (Trigger trigger);

    /**
     * Update task.
     *
     * @param task the task
     * @return the task
     */
    Task update (Task task);

    /**
     * Update milstone.
     *
     * @param milstone the milstone
     * @return the milstone
     */
    Milstone update (Milstone milstone);

    /**
     * Update trigger.
     *
     * @param trigger the trigger
     * @return the trigger
     */
    Trigger update (Trigger trigger);
}
