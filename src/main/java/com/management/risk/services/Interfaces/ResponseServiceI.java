package com.management.risk.services.Interfaces;

import com.management.risk.Mitigation.*;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ResponseServiceI {
    List<Response> findAll();
    List<Response> findAll(Sort sort);
    Optional<Response> findById (long id);
    void deleteById (long id);
    Response save (Response response);
    //
    ContingencyPlan save (ContingencyPlan contingencyPlan);
    MitigationPlan save (MitigationPlan mitigationPlan);
    NonPlanResponse save(NonPlanResponse nonPlanResponse);
    StrategicPlan save(StrategicPlan strategicPlan);

    Response update (Response response);
    //
    ContingencyPlan update (ContingencyPlan contingencyPlan);
    MitigationPlan update (MitigationPlan mitigationPlan);
    NonPlanResponse update(NonPlanResponse nonPlanResponse);
    StrategicPlan update(StrategicPlan strategicPlan);
}
