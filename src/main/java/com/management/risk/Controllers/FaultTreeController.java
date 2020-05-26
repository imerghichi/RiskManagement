package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.services.Implementation.FaultTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/faultTree")
public class FaultTreeController {
    @Autowired
    private FaultTreeService faultTreeService;

    @GetMapping(value = "/allft/")
    @ResponseBody
    public List<LeafEvent> getAllft(){
        return faultTreeService.findAll();
    }

    @GetMapping(value = "/ft/{id}")
    @ResponseBody
    public Optional<LeafEvent> getByftId(@PathVariable long id){
        return faultTreeService.findById(id);
    }

    @DeleteMapping(value = "/deleteft/{id}")
    @ResponseBody
    public void deleteByftId(@PathVariable long id){
        faultTreeService.deleteById(id);
    }

    @PostMapping(value = "/postft/")
    @ResponseBody
    public LeafEvent saveft(@RequestBody LeafEvent leafEvent){
        return faultTreeService.save(leafEvent);
    }

}
