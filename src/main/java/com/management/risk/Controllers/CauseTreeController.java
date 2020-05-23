package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import com.management.risk.services.Implementation.CauseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/causeTree")
public class CauseTreeController {
    @Autowired
    private CauseTreeService causeTreeService;

    @GetMapping
    @ResponseBody
    public List<Event> getAll(){
        return causeTreeService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Event> getEvent(@PathVariable long id){
        return causeTreeService.findById(id);
    }

    @GetMapping(value = "/{id}/causes")
    @ResponseBody
    public List<Event> getCauses(@PathVariable long id){
        return causeTreeService.findCauses(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteEvent(@PathVariable long id){
        causeTreeService.deleteById(id);
    }


    @PostMapping
    @ResponseBody
    public Event saveEvent(@RequestBody Event event){
        return causeTreeService.save(event);
    }
}
