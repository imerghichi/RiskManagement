package com.management.risk.Controllers;

import com.management.risk.Mitigation.*;
import com.management.risk.services.Implementation.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Response controller.
 */
@RestController("/response")
public class ResponseController {
    /**
     * The Response service.
     */
    @Autowired
    private ResponseService responseService;

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping(value = "/allresponse/")
    @ResponseBody
    public List<Response> getAll(){
        return responseService.findAll();
    }

    /**
     * Get by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/response/{id}")
    @ResponseBody
    public Optional<Response> getById(@PathVariable long id){
        return responseService.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteresponse/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        responseService.deleteById(id);
    }

    /**
     * Save contingency plan.
     *
     * @param contingencyPlan the contingency plan
     * @return the contingency plan
     */
    @PostMapping(value = "/postCP/")
    @ResponseBody
    public ContingencyPlan save(@RequestBody ContingencyPlan contingencyPlan){
        return responseService.save(contingencyPlan);
    }

    /**
     * Save mitigation plan.
     *
     * @param mitigationPlan the mitigation plan
     * @return the mitigation plan
     */
    @PostMapping(value = "/postMP/")
    @ResponseBody
    public MitigationPlan save(@RequestBody MitigationPlan mitigationPlan){
        return responseService.save(mitigationPlan);
    }

    /**
     * Save strategic plan.
     *
     * @param strategicPlan the strategic plan
     * @return the strategic plan
     */
    @PostMapping(value = "/postSP/")
    @ResponseBody
    public StrategicPlan save(@RequestBody StrategicPlan strategicPlan){
        return responseService.save(strategicPlan);
    }

    /**
     * Save npr non plan response.
     *
     * @param nonPlanResponse the non plan response
     * @return the non plan response
     */
    @PostMapping(value = "/postNPR/")
    @ResponseBody
    public NonPlanResponse saveNPR(@RequestBody NonPlanResponse nonPlanResponse){
        return responseService.update(nonPlanResponse);
    }

    /**
     * Update npr non plan response.
     *
     * @param nonPlanResponse the non plan response
     * @return the non plan response
     */
    @PutMapping(value = "/putNPR/")
    @ResponseBody
    public NonPlanResponse updateNPR(@RequestBody NonPlanResponse nonPlanResponse){
        return responseService.update(nonPlanResponse);
    }

    /**
     * Update sp strategic plan.
     *
     * @param strategicPlan the strategic plan
     * @return the strategic plan
     */
    @PutMapping(value = "/putSP")
    @ResponseBody
    public StrategicPlan updateSP(@RequestBody StrategicPlan strategicPlan){
        return responseService.save(strategicPlan);
    }

    /**
     * Update contingency plan.
     *
     * @param contingencyPlan the contingency plan
     * @return the contingency plan
     */
    @PutMapping(value = "/putCP/")
    @ResponseBody
    public ContingencyPlan update(@RequestBody ContingencyPlan contingencyPlan){
        return responseService.save(contingencyPlan);
    }

    /**
     * Update mp mitigation plan.
     *
     * @param mitigationPlan the mitigation plan
     * @return the mitigation plan
     */
    @PutMapping(value = "/putMP/")
    @ResponseBody
    public MitigationPlan updateMP(@RequestBody MitigationPlan mitigationPlan){
        return responseService.save(mitigationPlan);
    }

}
