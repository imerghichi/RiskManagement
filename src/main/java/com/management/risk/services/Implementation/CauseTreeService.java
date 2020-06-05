package com.management.risk.services.Implementation;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import com.management.risk.Identification.Risk;
import com.management.risk.repositories.CauseTreeRepo;
import com.management.risk.repositories.Riskrepo;
import com.management.risk.services.Interfaces.CauseTreeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Cause tree service.
 */
@Service
public class CauseTreeService implements CauseTreeServiceI {
    /**
     * The Cause tree repo.
     */
    @Autowired
    private CauseTreeRepo causeTreeRepo;
    private Riskrepo riskrepo;
    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Event> findAll() {
        return causeTreeRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Event> findAll(Sort sort) {
        return causeTreeRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Event> findById(long id) {
        return causeTreeRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        causeTreeRepo.deleteById(id);

    }

    /**
     * Update event.
     *
     * @param event the event
     * @return the event
     */
    @Override
    public Event update(Event event) {
        return causeTreeRepo.save(event);
    }

    /**
     * Save event.
     *
     * @param event the event
     * @return the event
     */
    @Override
    public Event save(Event event) {
        return causeTreeRepo.save(event);
    }

    /**
     * Find causes list.
     *
     * @param id the id
     * @return the list
     */
    @Override
    public List<Event> findCauses(long id) {
       if(findById(id).isPresent()) {
           return new ArrayList<>();
       }
       else return findById(id).orElse(null).getCauses();
    }

    @Override
    public List<Event> findByRisk(Risk risk) {
        List<Event> events = new ArrayList<>();
        List<Event> allevents = findAll();
        for(Event event : allevents){
            if (event.getRisk().equals(risk)){
                events.add(event);
            }
        }
        return events;
    }
}
