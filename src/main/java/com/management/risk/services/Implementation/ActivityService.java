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

/**
 * The type Activity service.
 */
@Service
public class ActivityService implements ActivityServiceI {
    /**
     * The Activity repo.
     */
    @Autowired
    private ActivityRepo activityRepo;

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Activity> findAll() {
        return activityRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Activity> findAll(Sort sort) {
        return activityRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Activity> findById(long id) {
        return activityRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        activityRepo.deleteById(id);

    }

    /**
     * Save activity.
     *
     * @param activity the activity
     * @return the activity
     */
    @Override
    public Activity save(Activity activity) {
        return activityRepo.save(activity);
    }

    /**
     * Find by project list.
     *
     * @param project the project
     * @return the list
     */
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

    /**
     * Update activity.
     *
     * @param activity the activity
     * @return the activity
     */
    @Override
    public Activity update(Activity activity) {
        return activityRepo.save(activity);
    }
}
