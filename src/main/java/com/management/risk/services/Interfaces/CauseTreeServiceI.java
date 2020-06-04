package com.management.risk.services.Interfaces;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Cause tree service i.
 */
public interface CauseTreeServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Event> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Event> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Event> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save event.
     *
     * @param event the event
     * @return the event
     */
    Event save (Event event);

    /**
     * Update event.
     *
     * @param event the event
     * @return the event
     */
    Event update(Event event);

    /**
     * Find causes list.
     *
     * @param id the id
     * @return the list
     */
//
    List<Event> findCauses(long id);
}
