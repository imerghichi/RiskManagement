package com.management.risk.services.Implementation;

import com.management.risk.Mitigation.*;
import com.management.risk.repositories.ResponseRepo;
import com.management.risk.services.Interfaces.ResponseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService implements ResponseServiceI {
    @Autowired
    private ResponseRepo responseRepo;

    @Override
    public List<Response> findAll() {
        return responseRepo.findAll();
    }

    @Override
    public List<Response> findAll(Sort sort) {
        return responseRepo.findAll(sort);
    }

    @Override
    public Optional<Response> findById(long id) {
        return responseRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        responseRepo.deleteById(id);
    }

    @Override
    public Response save(Response response) {
        return responseRepo.save(response);
    }

    @Override
    public ContingencyPlan save(ContingencyPlan contingencyPlan) {
        return responseRepo.save(contingencyPlan);
    }

    @Override
    public MitigationPlan save(MitigationPlan mitigationPlan) {
        return responseRepo.save(mitigationPlan);
    }

    @Override
    public NonPlanResponse save(NonPlanResponse nonPlanResponse) {
        return responseRepo.save(nonPlanResponse);
    }

    @Override
    public StrategicPlan save(StrategicPlan strategicPlan) {
        return responseRepo.save(strategicPlan);
    }

    @Override
    public Response update(Response response) {
        return responseRepo.save(response);
    }

    @Override
    public ContingencyPlan update(ContingencyPlan contingencyPlan) {
        return responseRepo.save(contingencyPlan);
    }

    @Override
    public MitigationPlan update(MitigationPlan mitigationPlan) {
        return responseRepo.save(mitigationPlan);
    }

    @Override
    public NonPlanResponse update(NonPlanResponse nonPlanResponse) {
        return responseRepo.save(nonPlanResponse);
    }

    @Override
    public StrategicPlan update(StrategicPlan strategicPlan) {
        return responseRepo.save(strategicPlan);
    }
}
