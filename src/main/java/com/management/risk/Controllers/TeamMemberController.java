package com.management.risk.Controllers;

import com.management.risk.Identification.TeamMember;
import com.management.risk.services.Implementation.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Team member controller.
 */
@RestController("/teammember")
public class TeamMemberController {
    /**
     * The Team member service.
     */
    @Autowired
    public TeamMemberService teamMemberService;

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping(value = "/allTM")
    @ResponseBody
    public List<TeamMember> getAll(){
        return teamMemberService.findAll();
    }

    /**
     * Get by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/tm/{id}")
    @ResponseBody
    public Optional<TeamMember> getById(@PathVariable long id){
        return teamMemberService.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteTM/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        teamMemberService.deleteById(id);
    }

    /**
     * Save team member.
     *
     * @param teamMember the team member
     * @return the team member
     */
    @PostMapping(value = "/postTM/")
    @ResponseBody
    public TeamMember save(@RequestBody TeamMember teamMember){
        return teamMemberService.save(teamMember);
    }

    /**
     * Update team member.
     *
     * @param teamMember the team member
     * @return the team member
     */
    @PutMapping(value = "/putTM")
    @ResponseBody
    public TeamMember update(@RequestBody TeamMember teamMember){
        return teamMemberService.save(teamMember);
    }

}
