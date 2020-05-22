package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.Activity;
import com.management.risk.models.Identification.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ActivityServiceI {
    List<Activity> findAll();
    List<Activity> findAll(Sort sort);
    Optional<Activity> findById (long id);
    void deleteById (long id);
    Activity save (Activity activity);

    //
    List<Activity> findByProject(Project project);
}
