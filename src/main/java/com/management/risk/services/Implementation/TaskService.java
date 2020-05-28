package com.management.risk.services.Implementation;

import com.management.risk.Mitigation.Milstone;
import com.management.risk.Mitigation.Task;
import com.management.risk.Mitigation.Trigger;
import com.management.risk.repositories.TaskRepo;
import com.management.risk.services.Interfaces.TaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceI {
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public List<Task> findAll(Sort sort) {
        return taskRepo.findAll(sort);
    }

    @Override
    public Optional<Task> findById(long id) {
        return taskRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Milstone save(Milstone milstone) {
        return taskRepo.save(milstone);
    }

    @Override
    public Trigger save(Trigger trigger) {
        return taskRepo.save(trigger);
    }

    @Override
    public Task update(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Milstone update(Milstone milstone) {
        return taskRepo.save(milstone);
    }

    @Override
    public Trigger update(Trigger trigger) {
        return taskRepo.save(trigger);
    }
}
