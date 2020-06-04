package com.management.risk.services.Interfaces;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Fault tree service i.
 */
public interface FaultTreeServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<LeafEvent> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<LeafEvent> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<LeafEvent> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save leaf event.
     *
     * @param leafEvent the leaf event
     * @return the leaf event
     */
    LeafEvent save (LeafEvent leafEvent);

    /**
     * Update leaf event.
     *
     * @param leafEvent the leaf event
     * @return the leaf event
     */
    LeafEvent update(LeafEvent leafEvent);
    //

}
