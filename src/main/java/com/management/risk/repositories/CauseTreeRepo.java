package com.management.risk.repositories;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Cause tree repo.
 */
public interface CauseTreeRepo extends JpaRepository<Event, Long> {
}
