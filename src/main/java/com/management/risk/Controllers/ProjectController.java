package com.management.risk.Controllers;

import com.management.risk.Identification.Project;
import com.management.risk.services.Implementation.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/allproject/")
    @ResponseBody
    public List<Project> getAll(){
        return projectService.findAll();
    }

    @GetMapping(value = "/aproject/{id}")
    @ResponseBody
    public Optional<Project> getById(@PathVariable long id){
        return projectService.findById(id);
    }

    @DeleteMapping(value = "/deleteproject/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        projectService.deleteById(id);
    }

    @PostMapping(value = "/postproject/")
    @ResponseBody
    public Project save(@RequestBody Project project){
        return projectService.save(project);
    }

    @PutMapping(value = "/putproject/")
    @ResponseBody
    public Project updateProject(@RequestBody Project project){
        return projectService.save(project);
    }
}
