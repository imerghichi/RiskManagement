package com.management.risk.services.Implementation;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Identification.Risk;
import com.management.risk.repositories.FaultTreeRepo;
import com.management.risk.services.Interfaces.FaultTreeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Fault tree service.
 */
@Service
public class FaultTreeService implements FaultTreeServiceI {
    /**
     * The Fault tree repo.
     */
    @Autowired
    private FaultTreeRepo faultTreeRepo;

    @Override
    public LeafEvent findByRisk(Risk risk) {
        List<LeafEvent> events = findAll();
        LeafEvent leafEvent =new LeafEvent();
        for (LeafEvent leafevent:
             events) {
            if (leafevent.getRisk().equals(risk)){
                leafEvent = leafevent;
                break;
            }
        }
        return leafEvent;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<LeafEvent> findAll() {
        return faultTreeRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<LeafEvent> findAll(Sort sort) {
        return faultTreeRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<LeafEvent> findById(long id) {
        return faultTreeRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        faultTreeRepo.deleteById(id);
    }

    /**
     * Save leaf event.
     *
     * @param leafEvent the leaf event
     * @return the leaf event
     */
    @Override
    public LeafEvent save(LeafEvent leafEvent) {
        return faultTreeRepo.save(leafEvent);

    }

    /**
     * Update leaf event.
     *
     * @param leafEvent the leaf event
     * @return the leaf event
     */
    @Override
    public LeafEvent update(LeafEvent leafEvent) {
        return faultTreeRepo.save(leafEvent);
    }
}
