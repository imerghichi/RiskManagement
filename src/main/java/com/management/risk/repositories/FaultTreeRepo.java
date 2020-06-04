package com.management.risk.repositories;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Fault tree repo.
 */
public interface FaultTreeRepo extends JpaRepository<LeafEvent, Long> {
}
