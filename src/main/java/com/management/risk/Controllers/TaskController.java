package com.management.risk.Controllers;


import com.management.risk.Mitigation.Milstone;
import com.management.risk.Mitigation.Task;
import com.management.risk.Mitigation.Trigger;
import com.management.risk.services.Implementation.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/alltask/")
    @ResponseBody
    public List<Task> getAll(){
        return taskService.findAll();
    }

    @GetMapping(value = "/task/{id}")
    @ResponseBody
    public Optional<Task> getById(@PathVariable long id){
        return taskService.findById(id);
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        taskService.deleteById(id);
    }

    @PostMapping(value = "/posttask/")
    @ResponseBody
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @PostMapping(value = "/postMilstone/")
    @ResponseBody
    public Milstone save(@RequestBody Milstone task){
        return taskService.save(task);
    }

    @PostMapping(value = "/postTrigger/")
    @ResponseBody
    public Trigger save(@RequestBody Trigger task){
        return taskService.save(task);
    }
}
