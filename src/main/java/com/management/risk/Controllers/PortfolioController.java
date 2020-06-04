package com.management.risk.Controllers;

import com.management.risk.Identification.Portfolio;
import com.management.risk.Identification.Project;
import com.management.risk.services.Implementation.PortfolioService;
import com.management.risk.services.Implementation.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Portfolio controller.
 */
@RestController("/portfolio")
public class PortfolioController {
    /**
     * The Portfolio service.
     */
    @Autowired
    private PortfolioService portfolioService;
    /**
     * The Project service.
     */
    private ProjectService projectService;

    /**
     * Getall list.
     *
     * @return the list
     */
    @GetMapping(value = "/allportfolio")
    @ResponseBody
    public List<Portfolio> getall(){
        return portfolioService.findAll();
    }

    /**
     * Getby id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/portfolio/{id}")
    @ResponseBody
    public Optional<Portfolio> getbyId(@PathVariable long id){
        return portfolioService.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteportfolio/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        portfolioService.deleteById(id);
    }

    /**
     * Save portfolio.
     *
     * @param portfolio the portfolio
     * @return the portfolio
     */
    @PostMapping(value = "/postportfolio/")
    @ResponseBody
    public Portfolio save (@RequestBody Portfolio portfolio){
        return portfolioService.save(portfolio);
    }

    /**
     * Gets by project.
     *
     * @param id the id
     * @return the by project
     * @throws Exception the exception
     */
    @GetMapping("/project_portfolio/{id}")
    @ResponseBody
    public List<Portfolio> getByProject(@PathVariable long id) throws Exception {
        Project project = projectService.findById(id).orElseThrow(Exception::new);
        return portfolioService.findPortfolioByProject(project);
    }

    /**
     * Updateportfolio portfolio.
     *
     * @param portfolio the portfolio
     * @return the portfolio
     */
    @PutMapping("/putportfolio/")
    @ResponseBody
    public Portfolio updateportfolio(@RequestBody Portfolio portfolio){
        return portfolioService.save(portfolio);
    }
}
