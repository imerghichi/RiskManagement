package com.management.risk.Controllers;

import com.management.risk.Identification.Activity;
import com.management.risk.services.Implementation.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/activitycontrol")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping(value = "/allac/")
    @ResponseBody
    public List<Activity> getallact(){
        return activityService.findAll();
    }

    @GetMapping(value = "/act/{id}")
    @ResponseBody
    public Optional<Activity> getActivityById(@PathVariable long id){
        return activityService.findById(id);
    }

    @DeleteMapping(value = "/deleteact/{id}")
    @ResponseBody
    public void deleteByIdact(@PathVariable long id){
        activityService.deleteById(id);
    }

    @PostMapping
    public Activity postActivity(@RequestBody Activity activity){
        return activityService.save(activity);
    }
}
