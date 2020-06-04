package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.services.Implementation.FaultTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Fault tree controller.
 */
@RestController(value = "/faultTree")
public class FaultTreeController {
    /**
     * The Fault tree service.
     */
    @Autowired
    private FaultTreeService faultTreeService;

    /**
     * Get allft list.
     *
     * @return the list
     */
    @GetMapping(value = "/allft/")
    @ResponseBody
    public List<LeafEvent> getAllft(){
        return faultTreeService.findAll();
    }

    /**
     * Get byft id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/ft/{id}")
    @ResponseBody
    public Optional<LeafEvent> getByftId(@PathVariable long id){
        return faultTreeService.findById(id);
    }

    /**
     * Delete byft id.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteft/{id}")
    @ResponseBody
    public void deleteByftId(@PathVariable long id){
        faultTreeService.deleteById(id);
    }

    /**
     * Saveft leaf event.
     *
     * @param leafEvent the leaf event
     * @return the leaf event
     */
    @PostMapping(value = "/postft/")
    @ResponseBody
    public LeafEvent saveft(@RequestBody LeafEvent leafEvent){
        return faultTreeService.save(leafEvent);
    }

    /**
     * Updateft leaf event.
     *
     * @param leafEvent the leaf event
     * @return the leaf event
     */
    @PutMapping(value = "/putft/")
    @ResponseBody
    public LeafEvent updateft(@RequestBody LeafEvent leafEvent){
        return faultTreeService.save(leafEvent);
    }
}
