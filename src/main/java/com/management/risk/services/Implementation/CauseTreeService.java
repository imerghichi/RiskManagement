package com.management.risk.services.Implementation;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import com.management.risk.repositories.CauseTreeRepo;
import com.management.risk.services.Interfaces.CauseTreeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CauseTreeService implements CauseTreeServiceI {
    @Autowired
    private CauseTreeRepo causeTreeRepo;

    @Override
    public List<Event> findAll() {
        return causeTreeRepo.findAll();
    }

    @Override
    public List<Event> findAll(Sort sort) {
        return causeTreeRepo.findAll(sort);
    }

    @Override
    public Optional<Event> findById(long id) {
        return causeTreeRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        causeTreeRepo.deleteById(id);

    }

    @Override
    public Event save(Event event) {
        return causeTreeRepo.save(event);
    }

    @Override
    public List<Event> findCauses(long id) {
       return findById(id).orElse(null).getCauses();
    }
}
