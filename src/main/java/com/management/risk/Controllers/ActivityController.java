package com.management.risk.Controllers;

import com.management.risk.Identification.Activity;
import com.management.risk.services.Implementation.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/add/")
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
    @PutMapping
    @ResponseBody
    public Activity putActivity(@RequestBody Activity activity){
        return activityService.update(activity);
    }
}
