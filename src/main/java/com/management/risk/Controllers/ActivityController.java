package com.management.risk.Controllers;

import com.management.risk.models.Identification.Activity;
import com.management.risk.services.Implementation.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    @ResponseBody
    public List<Activity> getall(){
        return activityService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Activity> getActivityById(@PathVariable long id){
        return activityService.findById(id);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable long id){
        activityService.deleteById(id);
    }

    @PostMapping
    public Activity postActivity(@RequestBody Activity activity){
        return activityService.save(activity);
    }
}
