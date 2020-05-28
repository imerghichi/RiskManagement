package com.management.risk.services.Implementation;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.Project;
import com.management.risk.repositories.ActivityRepo;
import com.management.risk.services.Interfaces.ActivityServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService implements ActivityServiceI {
    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public List<Activity> findAll() {
        return activityRepo.findAll();
    }

    @Override
    public List<Activity> findAll(Sort sort) {
        return activityRepo.findAll(sort);
    }

    @Override
    public Optional<Activity> findById(long id) {
        return activityRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        activityRepo.deleteById(id);

    }

    @Override
    public Activity save(Activity activity) {
        Activity activity1 = new Activity();
        activity1 = activityRepo.save(activity);
        return activity1;
    }

    @Override
    public List<Activity> findByProject(Project project) {
        List<Activity> activities = activityRepo.findAll();
        List<Activity> res = new ArrayList<>();
        for (Activity activity:
             activities) {
            if(activity.getProject() == project)
                res.add(activity);
        }
        return res;
    }

    @Override
    public Activity update(Activity activity) {
        return activityRepo.save(activity);
    }
}
