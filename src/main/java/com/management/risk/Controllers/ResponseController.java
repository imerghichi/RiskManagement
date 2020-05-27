package com.management.risk.Controllers;

import com.management.risk.Mitigation.*;
import com.management.risk.services.Implementation.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/response")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/allresponse/")
    @ResponseBody
    public List<Response> getAll(){
        return responseService.findAll();
    }

    @GetMapping(value = "/response/{id}")
    @ResponseBody
    public Optional<Response> getById(@PathVariable long id){
        return responseService.findById(id);
    }

    @DeleteMapping(value = "/deleteresponse/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        responseService.deleteById(id);
    }

    @PostMapping(value = "/postCP/")
    @ResponseBody
    public ContingencyPlan save(@RequestBody ContingencyPlan contingencyPlan){
        return responseService.save(contingencyPlan);
    }
    @PostMapping(value = "/postMP/")
    @ResponseBody
    public MitigationPlan save(@RequestBody MitigationPlan mitigationPlan){
        return responseService.save(mitigationPlan);
    }

    @PostMapping(value = "/postNPR/")
    @ResponseBody
    public NonPlanResponse save(@RequestBody NonPlanResponse nonPlanResponse){
        return responseService.save(nonPlanResponse);
    }
    @PostMapping(value = "/postSP")
    @ResponseBody
    public StrategicPlan save(@RequestBody StrategicPlan strategicPlan){
        return responseService.save(strategicPlan);
    }

}
