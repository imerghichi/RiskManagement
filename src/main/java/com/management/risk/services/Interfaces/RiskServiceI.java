package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.Activity;
import com.management.risk.models.Identification.Risk;

import java.util.List;
import java.util.Optional;

public interface RiskServiceI {
    List<Risk> getAllRisks();
    List<Risk> getRisksbyActivity(Activity activity);
    Optional<Risk> getRiskbyId(long id);
    void updateRisk(Risk risk);
    void deleteRiskbyid(long id);
    void deleteRisk(Risk risk);
    void saveRisk(Risk risk);

}
