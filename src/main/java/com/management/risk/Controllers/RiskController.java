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

@RestController("/risks")
public class RiskController {
    @Autowired
    private RiskService riskService;
    private ActivityService activityService;
    private ProjectService projectService;
    private TeamMemberService teamMemberService;

    @GetMapping(value = "/allrisks/")
    @ResponseBody
    public List<Risk> getAll(){
        return riskService.findAll();
    }

    @GetMapping(value = "/risk/{id}")
    @ResponseBody
    public Optional<Risk> getById(@PathVariable long id){
        return riskService.findById(id);
    }

    @GetMapping("/activity_risk/{id}")
    @ResponseBody
    public List<Risk> getByActivity(@PathVariable long id) throws Exception {
        Activity activity = activityService.findById(id).orElseThrow(Exception::new);
        return riskService.findByActivity(activity);
    }

    @GetMapping(value = "/project_risk/{id}")
    @ResponseBody
    public List<Risk> getByProject (@PathVariable long id) throws Exception {
        Project project = projectService.findById(id).orElseThrow(Exception::new);
        return riskService.findByProject(project);
    }
    @GetMapping(value = "/team_member_risk/{id}")
    @ResponseBody
    public List<Risk> getByTeam_mem (@PathVariable long id) throws Exception {
        TeamMember teamMember = teamMemberService.findById(id).orElseThrow(Exception::new);
        return riskService.findByTeamMember(teamMember);
    }


    @DeleteMapping(value = "/deleterisk/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        riskService.deleteById(id);
    }

    @PostMapping(value = "/postrisk")
    @ResponseBody
    public Risk save(@RequestBody Risk risk){
        return riskService.save(risk);
    }

}
