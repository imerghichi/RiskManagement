package com.management.risk.Controllers;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.Project;
import com.management.risk.Identification.Risk;
import com.management.risk.Identification.TeamMember;
import com.management.risk.services.Implementation.ActivityService;
import com.management.risk.services.Implementation.ProjectService;
import com.management.risk.services.Implementation.RiskService;
import com.management.risk.services.Implementation.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Risk controller.
 */
@RestController("/risks")
public class RiskController {
    /**
     * The Risk service.
     */
    @Autowired
    private RiskService riskService;
    /**
     * The Activity service.
     */
    private ActivityService activityService;
    /**
     * The Project service.
     */
    private ProjectService projectService;
    /**
     * The Team member service.
     */
    private TeamMemberService teamMemberService;

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping(value = "/allrisks/")
    @ResponseBody
    public List<Risk> getAll(){
        return riskService.findAll();
    }

    /**
     * Get by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/risk/{id}")
    @ResponseBody
    public Optional<Risk> getById(@PathVariable long id){
        return riskService.findById(id);
    }

    /**
     * Gets by activity.
     *
     * @param id the id
     * @return the by activity
     * @throws Exception the exception
     */
    @GetMapping("/activity_risk/{id}")
    @ResponseBody
    public List<Risk> getByActivity(@PathVariable long id) throws Exception {
        Activity activity = activityService.findById(id).orElseThrow(Exception::new);
        return riskService.findByActivity(activity);
    }

    @PostMapping ("/activitypostrisk/{id}")
    public Risk postRiskforact(@RequestBody Risk risk, @PathVariable long id) throws Exception {
        Risk risk1 = risk;
        risk1.setTaskProject(activityService.findById(id).orElseThrow(Exception::new));
        return riskService.save(risk1);
    }

    /**
     * Gets by project.
     *
     * @param id the id
     * @return the by project
     * @throws Exception the exception
     */
    @GetMapping(value = "/project_risk/{id}")
    @ResponseBody
    public List<Risk> getByProject (@PathVariable long id) throws Exception {
        Project project = projectService.findById(id).orElseThrow(Exception::new);
        return riskService.findByProject(project);
    }

    /**
     * Gets by team mem.
     *
     * @param id the id
     * @return the by team mem
     * @throws Exception the exception
     */
    @GetMapping(value = "/team_member_risk/{id}")
    @ResponseBody
    public List<Risk> getByTeam_mem (@PathVariable long id) throws Exception {
        TeamMember teamMember = teamMemberService.findById(id).orElseThrow(Exception::new);
        return riskService.findByTeamMember(teamMember);
    }


    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleterisk/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        riskService.deleteById(id);
    }

    /**
     * Save risk.
     *
     * @param risk the risk
     * @return the risk
     */
    @PostMapping(value = "/postrisk")
    @ResponseBody
    public Risk save(@RequestBody Risk risk){
        return riskService.save(risk);
    }

    /**
     * Update risk risk.
     *
     * @param risk the risk
     * @return the risk
     */
    @PutMapping(value = "/putrisk")
    @ResponseBody
    public Risk updateRisk(@RequestBody Risk risk){
        return riskService.save(risk);
    }

}
