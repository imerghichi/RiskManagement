package com.management.risk.Controllers;

import com.management.risk.models.Identification.Portfolio;
import com.management.risk.models.Identification.Project;
import com.management.risk.services.Implementation.PortfolioService;
import com.management.risk.services.Implementation.ProjectService;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    private ProjectService projectService;

    @GetMapping
    @ResponseBody
    public List<Portfolio> getall(){
        return portfolioService.findAll();
    }
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Portfolio> getbyId(@PathVariable long id){
        return portfolioService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        portfolioService.deleteById(id);
    }

    @PostMapping
    @ResponseBody
    public Portfolio save (@RequestBody Portfolio portfolio){
        return portfolioService.save(portfolio);
    }

    @GetMapping("/project/{id}")
    @ResponseBody
    public List<Portfolio> getByProject(@PathVariable long id) throws Exception {
        Project project = projectService.findById(id).orElseThrow(Exception::new);
        return portfolioService.findPortfolioByProject(project);
    }
}