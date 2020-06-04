package com.management.risk.services.Implementation;

import com.management.risk.Mitigation.*;
import com.management.risk.repositories.ResponseRepo;
import com.management.risk.services.Interfaces.ResponseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Response service.
 */
@Service
public class ResponseService implements ResponseServiceI {
    /**
     * The Response repo.
     */
    @Autowired
    private ResponseRepo responseRepo;

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Response> findAll() {
        return responseRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Response> findAll(Sort sort) {
        return responseRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Response> findById(long id) {
        return responseRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        responseRepo.deleteById(id);
    }

    /**
     * Save response.
     *
     * @param response the response
     * @return the response
     */
    @Override
    public Response save(Response response) {
        return responseRepo.save(response);
    }

    /**
     * Save contingency plan.
     *
     * @param contingencyPlan the contingency plan
     * @return the contingency plan
     */
    @Override
    public ContingencyPlan save(ContingencyPlan contingencyPlan) {
        return responseRepo.save(contingencyPlan);
    }

    /**
     * Save mitigation plan.
     *
     * @param mitigationPlan the mitigation plan
     * @return the mitigation plan
     */
    @Override
    public MitigationPlan save(MitigationPlan mitigationPlan) {
        return responseRepo.save(mitigationPlan);
    }

    /**
     * Save non plan response.
     *
     * @param nonPlanResponse the non plan response
     * @return the non plan response
     */
    @Override
    public NonPlanResponse save(NonPlanResponse nonPlanResponse) {
        return responseRepo.save(nonPlanResponse);
    }

    /**
     * Save strategic plan.
     *
     * @param strategicPlan the strategic plan
     * @return the strategic plan
     */
    @Override
    public StrategicPlan save(StrategicPlan strategicPlan) {
        return responseRepo.save(strategicPlan);
    }

    /**
     * Update response.
     *
     * @param response the response
     * @return the response
     */
    @Override
    public Response update(Response response) {
        return responseRepo.save(response);
    }

    /**
     * Update contingency plan.
     *
     * @param contingencyPlan the contingency plan
     * @return the contingency plan
     */
    @Override
    public ContingencyPlan update(ContingencyPlan contingencyPlan) {
        return responseRepo.save(contingencyPlan);
    }

    /**
     * Update mitigation plan.
     *
     * @param mitigationPlan the mitigation plan
     * @return the mitigation plan
     */
    @Override
    public MitigationPlan update(MitigationPlan mitigationPlan) {
        return responseRepo.save(mitigationPlan);
    }

    /**
     * Update non plan response.
     *
     * @param nonPlanResponse the non plan response
     * @return the non plan response
     */
    @Override
    public NonPlanResponse update(NonPlanResponse nonPlanResponse) {
        return responseRepo.save(nonPlanResponse);
    }

    /**
     * Update strategic plan.
     *
     * @param strategicPlan the strategic plan
     * @return the strategic plan
     */
    @Override
    public StrategicPlan update(StrategicPlan strategicPlan) {
        return responseRepo.save(strategicPlan);
    }
}
