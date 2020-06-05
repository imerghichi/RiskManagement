package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Risk;
import com.management.risk.Mitigation.*;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Response service i.
 */
public interface ResponseServiceI {
    Response findByRisk(Risk risk);
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Response> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Response> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Response> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save response.
     *
     * @param response the response
     * @return the response
     */
    Response save (Response response);

    /**
     * Save contingency plan.
     *
     * @param contingencyPlan the contingency plan
     * @return the contingency plan
     */
//
    ContingencyPlan save (ContingencyPlan contingencyPlan);

    /**
     * Save mitigation plan.
     *
     * @param mitigationPlan the mitigation plan
     * @return the mitigation plan
     */
    MitigationPlan save (MitigationPlan mitigationPlan);

    /**
     * Save non plan response.
     *
     * @param nonPlanResponse the non plan response
     * @return the non plan response
     */
    NonPlanResponse save(NonPlanResponse nonPlanResponse);

    /**
     * Save strategic plan.
     *
     * @param strategicPlan the strategic plan
     * @return the strategic plan
     */
    StrategicPlan save(StrategicPlan strategicPlan);

    /**
     * Update response.
     *
     * @param response the response
     * @return the response
     */
    Response update (Response response);

    /**
     * Update contingency plan.
     *
     * @param contingencyPlan the contingency plan
     * @return the contingency plan
     */
//
    ContingencyPlan update (ContingencyPlan contingencyPlan);

    /**
     * Update mitigation plan.
     *
     * @param mitigationPlan the mitigation plan
     * @return the mitigation plan
     */
    MitigationPlan update (MitigationPlan mitigationPlan);

    /**
     * Update non plan response.
     *
     * @param nonPlanResponse the non plan response
     * @return the non plan response
     */
    NonPlanResponse update(NonPlanResponse nonPlanResponse);

    /**
     * Update strategic plan.
     *
     * @param strategicPlan the strategic plan
     * @return the strategic plan
     */
    StrategicPlan update(StrategicPlan strategicPlan);
}
