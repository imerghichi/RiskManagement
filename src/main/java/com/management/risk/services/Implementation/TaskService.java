package com.management.risk.services.Implementation;

import com.management.risk.Mitigation.Milstone;
import com.management.risk.Mitigation.Response;
import com.management.risk.Mitigation.Task;
import com.management.risk.Mitigation.Trigger;
import com.management.risk.repositories.TaskRepo;
import com.management.risk.services.Interfaces.TaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Task service.
 */
@Service
public class TaskService implements TaskServiceI {
    /**
     * The Task repo.
     */
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public List<Task> findByResponse(Response response) {
        List<Task> all = findAll();
        List<Task> tasks = new ArrayList<>();
        for (Task task:
             all) {
            if(task.getResponse().equals(response)){
                tasks.add(task);
            }
        }
        return tasks;
    }


    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Task> findAll(Sort sort) {
        return taskRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Task> findById(long id) {
        return taskRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        taskRepo.deleteById(id);
    }

    /**
     * Save task.
     *
     * @param task the task
     * @return the task
     */
    @Override
    public Task save(Task task) {
        return taskRepo.save(task);
    }

    /**
     * Save milstone.
     *
     * @param milstone the milstone
     * @return the milstone
     */
    @Override
    public Milstone save(Milstone milstone) {
        return taskRepo.save(milstone);
    }

    /**
     * Save trigger.
     *
     * @param trigger the trigger
     * @return the trigger
     */
    @Override
    public Trigger save(Trigger trigger) {
        return taskRepo.save(trigger);
    }

    /**
     * Update task.
     *
     * @param task the task
     * @return the task
     */
    @Override
    public Task update(Task task) {
        return taskRepo.save(task);
    }

    /**
     * Update milstone.
     *
     * @param milstone the milstone
     * @return the milstone
     */
    @Override
    public Milstone update(Milstone milstone) {
        return taskRepo.save(milstone);
    }

    /**
     * Update trigger.
     *
     * @param trigger the trigger
     * @return the trigger
     */
    @Override
    public Trigger update(Trigger trigger) {
        return taskRepo.save(trigger);
    }
}
