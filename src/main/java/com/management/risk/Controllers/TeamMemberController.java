package com.management.risk.Controllers;

import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Identification.TeamMember;
import com.management.risk.services.Implementation.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/teammember")
public class TeamMemberController {
    @Autowired
    public TeamMemberService teamMemberService;

    @GetMapping
    @ResponseBody
    public List<TeamMember> getAll(){
        return teamMemberService.findAll();
    }
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<TeamMember> getById(@PathVariable long id){
        return teamMemberService.findById(id);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        teamMemberService.deleteById(id);
    }
    @PostMapping
    @ResponseBody
    public TeamMember save(@RequestBody TeamMember teamMember){
        return teamMemberService.save(teamMember);
    }
}
