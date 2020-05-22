package com.management.risk.services.Interfaces;


import com.management.risk.models.Identification.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProjectServiceI {
    List<Project> findAll();
    List<Project> findAll(Sort sort);
    Optional<Project> findById (long id);
    void deleteById (long id);
    Project save (Project project);

}
