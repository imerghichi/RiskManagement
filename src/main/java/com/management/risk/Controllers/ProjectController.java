package com.management.risk.Controllers;

import com.management.risk.Identification.Project;
import com.management.risk.services.Implementation.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Project controller.
 */
@RestController("/project")
public class ProjectController {
    /**
     * The Project service.
     */
    @Autowired
    ProjectService projectService;

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping(value = "/allproject/")
    @ResponseBody
    public List<Project> getAll(){
        return projectService.findAll();
    }

    /**
     * Get by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/aproject/{id}")
    @ResponseBody
    public Optional<Project> getById(@PathVariable long id){
        return projectService.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteproject/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        projectService.deleteById(id);
    }

    /**
     * Save project.
     *
     * @param project the project
     * @return the project
     */
    @PostMapping(value = "/postproject/")
    @ResponseBody
    public Project save(@RequestBody Project project){
        return projectService.save(project);
    }

    /**
     * Update project project.
     *
     * @param project the project
     * @return the project
     */
    @PutMapping(value = "/putproject/")
    @ResponseBody
    public Project updateProject(@RequestBody Project project){
        return projectService.save(project);
    }
}
