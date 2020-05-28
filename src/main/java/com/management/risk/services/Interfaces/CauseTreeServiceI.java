package com.management.risk.services.Interfaces;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CauseTreeServiceI {    List<Event> findAll();
    List<Event> findAll(Sort sort);
    Optional<Event> findById (long id);
    void deleteById (long id);
    Event save (Event event);
    Event update(Event event);
    //
    List<Event> findCauses(long id);
}
