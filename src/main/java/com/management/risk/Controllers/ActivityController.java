package com.management.risk.Controllers;

import com.management.risk.Identification.Activity;
import com.management.risk.services.Implementation.ActivityService;
import com.management.risk.services.Implementation.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * The type Activity controller.
 */
@RestController(value = "/activitycontrol")
public class ActivityController {
    /**
     * The Activity service.
     */
    @Autowired
    private ActivityService activityService;
    private ProjectService projectService;

    /**
     * Getallact list.
     *
     * @return the list
     */
    @GetMapping(value = "/allac/")
    @ResponseBody
    public List<Activity> getallact(){
        return activityService.findAll();
    }


    @GetMapping(value= "/actsbyproject/{id}")
    @ResponseBody
    public List<Activity> getbyproject(@PathVariable long id) {
        return activityService.findByProject(projectService.findById(id).orElse(null));
    }

    @PostMapping (value = "/actforproject/{id}", consumes="application/json")
    @ResponseBody
    public Activity postactforproject(@RequestBody Activity activity, @PathVariable long id) throws Exception {
        Activity activity1 = activity;
        activity1.setProject(projectService.findById(id).orElseThrow(Exception::new));
        return activityService.save(activity1);
    }


    /**
     * Get activity by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping(value = "/act/{id}")
    @ResponseBody
    public Optional<Activity> getActivityById(@PathVariable long id){
        return activityService.findById(id);
    }

    /**
     * Delete by idact.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/deleteact/{id}")
    @ResponseBody
    public void deleteByIdact(@PathVariable long id){
        activityService.deleteById(id);
    }

    /**
     * Post activity activity.
     *
     * @param activity the activity
     * @return the activity
     */
    @PostMapping(value = "/add/", consumes="application/json")
    @ResponseBody
    public Activity postActivity(@RequestBody Activity activity){
        return activityService.save(activity);
    }

    /**
     * Put activity activity.
     *
     * @param activity the activity
     * @return the activity
     */
  /*  @PutMapping
    @ResponseBody
    public Activity putActivity(@RequestBody Activity activity){
        return activityService.update(activity);
    }*/



}
