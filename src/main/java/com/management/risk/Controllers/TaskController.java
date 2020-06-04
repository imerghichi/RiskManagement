package com.management.risk.Controllers;


import com.management.risk.Mitigation.Milstone;
import com.management.risk.Mitigation.Task;
import com.management.risk.Mitigation.Trigger;
import com.management.risk.services.Implementation.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Task controller.
 */
@RestController("/tasks")
public class TaskController {
    /**
     * The Task service.
     */
    @Autowired
    private TaskService taskService;

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping(value = "/alltask/")
    @ResponseBody
    public List<Task> getAll(){
        return taskService.findAll();
    }

    /**
     * Get by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/task/{id}")
    @ResponseBody
    public Optional<Task> getById(@PathVariable long id){
        return taskService.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteTask/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        taskService.deleteById(id);
    }

    /**
     * Save task.
     *
     * @param task the task
     * @return the task
     */
    @PostMapping(value = "/posttask/")
    @ResponseBody
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    /**
     * Save milstone.
     *
     * @param task the task
     * @return the milstone
     */
    @PostMapping(value = "/postMilstone/")
    @ResponseBody
    public Milstone save(@RequestBody Milstone task){
        return taskService.save(task);
    }

    /**
     * Save trigger.
     *
     * @param task the task
     * @return the trigger
     */
    @PostMapping(value = "/postTrigger/")
    @ResponseBody
    public Trigger save(@RequestBody Trigger task){
        return taskService.save(task);
    }


    /**
     * Updatetsk task.
     *
     * @param task the task
     * @return the task
     */
    @PutMapping(value = "/puttask/")
    @ResponseBody
    public Task updatetsk(@RequestBody Task task){
        return taskService.save(task);
    }

    /**
     * Updatemlstn milstone.
     *
     * @param task the task
     * @return the milstone
     */
    @PutMapping(value = "/putMilstone/")
    @ResponseBody
    public Milstone updatemlstn(@RequestBody Milstone task){
        return taskService.save(task);
    }

    /**
     * Update trigger trigger.
     *
     * @param task the task
     * @return the trigger
     */
    @PutMapping(value = "/putTrigger/")
    @ResponseBody
    public Trigger updateTrigger(@RequestBody Trigger task){
        return taskService.save(task);
    }
}
