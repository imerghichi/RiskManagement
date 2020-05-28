package com.management.risk.services.Interfaces;

import com.management.risk.Mitigation.Milstone;
import com.management.risk.Mitigation.Task;
import com.management.risk.Mitigation.Trigger;
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

    Task update (Task task);

    Milstone update (Milstone milstone);
    Trigger update (Trigger trigger);
}
