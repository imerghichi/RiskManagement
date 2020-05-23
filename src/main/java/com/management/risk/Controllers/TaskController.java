package com.management.risk.Controllers;


import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Mitigation.Milstone;
import com.management.risk.models.Mitigation.Task;
import com.management.risk.models.Mitigation.Trigger;
import com.management.risk.services.Implementation.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    @ResponseBody
    public List<Task> getAll(){
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Task> getById(@PathVariable long id){
        return taskService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        taskService.deleteById(id);
    }

    @PostMapping
    @ResponseBody
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @PostMapping
    @ResponseBody
    public Milstone save(@RequestBody Milstone task){
        return taskService.save(task);
    }

    @PostMapping
    @ResponseBody
    public Trigger save(@RequestBody Trigger task){
        return taskService.save(task);
    }
}
