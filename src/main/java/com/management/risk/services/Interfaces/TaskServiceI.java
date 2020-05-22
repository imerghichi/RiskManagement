package com.management.risk.services.Interfaces;

import com.management.risk.models.Mitigation.Milstone;
import com.management.risk.models.Mitigation.Task;
import com.management.risk.models.Mitigation.Trigger;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TaskServiceI {
    List<Task> findAll();
    List<Task> findAll(Sort sort);
    Optional<Task> findById (long id);
    void deleteById (long id);
    Task save (Task task);
    //
    Milstone save (Milstone milstone);
    Trigger save (Trigger trigger);
}
