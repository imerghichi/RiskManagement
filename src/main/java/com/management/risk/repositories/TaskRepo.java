package com.management.risk.repositories;

import com.management.risk.Mitigation.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Task repo.
 */
@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
}
