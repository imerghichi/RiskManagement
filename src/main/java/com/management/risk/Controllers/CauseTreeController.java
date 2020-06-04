package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import com.management.risk.services.Implementation.CauseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Cause tree controller.
 */
@RestController(value = "/causeTree")
public class CauseTreeController {
    /**
     * The Cause tree service.
     */
    @Autowired
    private CauseTreeService causeTreeService;


    /**
     * Get all event cause tree list.
     *
     * @return the list
     */
    @GetMapping(value = "/allCT/")
    @ResponseBody
    public List<Event> getAllEvent_causeTree(){
        return causeTreeService.findAll();
    }

    /**
     * Get event optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/causestree/{id}")
    @ResponseBody
    public Optional<Event> getEvent(@PathVariable long id){
        return causeTreeService.findById(id);
    }

    /**
     * Get causes list.
     *
     * @param id the id
     * @return the list
     */
    @GetMapping(value = "/causes/{id}")
    @ResponseBody
    public List<Event> getCauses(@PathVariable long id){
        return causeTreeService.findCauses(id);
    }

    /**
     * Delete event.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deletect/{id}")
    @ResponseBody
    public void deleteEvent(@PathVariable long id){
        causeTreeService.deleteById(id);
    }


    /**
     * Save event event.
     *
     * @param event the event
     * @return the event
     */
    @PostMapping(value = "/postCT/")
    @ResponseBody
    public Event saveEvent(@RequestBody Event event){
        return causeTreeService.save(event);
    }

    /**
     * Update event event.
     *
     * @param event the event
     * @return the event
     */
    @PutMapping(value = "/putCT/")
    @ResponseBody
    public Event updateEvent(@RequestBody Event event){
        return causeTreeService.save(event);
    }

}

