package com.management.risk.repositories;

import com.management.risk.Identification.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Project repo.
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {

}
