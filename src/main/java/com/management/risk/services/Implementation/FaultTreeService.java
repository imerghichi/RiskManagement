package com.management.risk.services.Implementation;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.repositories.FaultTreeRepo;
import com.management.risk.services.Interfaces.FaultTreeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaultTreeService implements FaultTreeServiceI {
    @Autowired
    private FaultTreeRepo faultTreeRepo;

    @Override
    public List<LeafEvent> findAll() {
        return faultTreeRepo.findAll();
    }

    @Override
    public List<LeafEvent> findAll(Sort sort) {
        return faultTreeRepo.findAll(sort);
    }

    @Override
    public Optional<LeafEvent> findById(long id) {
        return faultTreeRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        faultTreeRepo.deleteById(id);
    }

    @Override
    public LeafEvent save(LeafEvent leafEvent) {
        return faultTreeRepo.save(leafEvent);
    }
}
