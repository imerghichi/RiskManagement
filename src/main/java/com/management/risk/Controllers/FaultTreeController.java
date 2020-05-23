package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.services.Implementation.FaultTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/faultTree")
public class FaultTreeController {
    @Autowired
    private FaultTreeService faultTreeService;

    @GetMapping
    @ResponseBody
    public List<LeafEvent> getAll(){
        return faultTreeService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<LeafEvent> getById(@PathVariable long id){
        return faultTreeService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        faultTreeService.deleteById(id);
    }

    @PostMapping
    @ResponseBody
    public LeafEvent save(@RequestBody LeafEvent leafEvent){
        return faultTreeService.save(leafEvent);
    }

}
