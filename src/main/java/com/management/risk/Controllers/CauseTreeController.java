package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import com.management.risk.services.Implementation.CauseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/causeTree")
public class CauseTreeController {
    @Autowired
    private CauseTreeService causeTreeService;


    @GetMapping(value = "/allCT/")
    @ResponseBody
    public List<Event> getAllEvent_causeTree(){
        return causeTreeService.findAll();
    }

    @GetMapping(value = "/causestree/{id}")
    @ResponseBody
    public Optional<Event> getEvent(@PathVariable long id){
        return causeTreeService.findById(id);
    }

    @GetMapping(value = "/causes/{id}")
    @ResponseBody
    public List<Event> getCauses(@PathVariable long id){
        return causeTreeService.findCauses(id);
    }

    @DeleteMapping(value = "/deletect/{id}")
    @ResponseBody
    public void deleteEvent(@PathVariable long id){
        causeTreeService.deleteById(id);
    }


    @PostMapping(value = "/postCT/")
    @ResponseBody
    public Event saveEvent(@RequestBody Event event){
        return causeTreeService.save(event);
    }

    @PutMapping(value = "/putCT/")
    @ResponseBody
    public Event updateEvent(@RequestBody Event event){
        return causeTreeService.save(event);
    }

}

