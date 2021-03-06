package com.management.risk.repositories;

import com.management.risk.Identification.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Activity repo.
 */
@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
