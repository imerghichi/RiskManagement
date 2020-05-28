package com.management.risk.services.Interfaces;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface FaultTreeServiceI {
    List<LeafEvent> findAll();
    List<LeafEvent> findAll(Sort sort);
    Optional<LeafEvent> findById (long id);
    void deleteById (long id);
    LeafEvent save (LeafEvent leafEvent);
    LeafEvent update(LeafEvent leafEvent);
    //

}
