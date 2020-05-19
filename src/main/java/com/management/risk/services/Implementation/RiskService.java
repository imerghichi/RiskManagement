package com.management.risk.services.Implementation;

import com.management.risk.models.Identification.Activity;
import com.management.risk.models.Identification.Risk;
import com.management.risk.services.Interfaces.RiskServiceI;

import java.util.List;
import java.util.Optional;

public class RiskService implements RiskServiceI {
    //@todo
    @Override
    public List<Risk> getAllRisks() {
        return null;
    }

    @Override
    public List<Risk> getRisksbyActivity(Activity activity) {
        return null;
    }

    @Override
    public Optional<Risk> getRiskbyId(long id) {
        return Optional.empty();
    }

    @Override
    public void updateRisk(Risk risk) {

    }

    @Override
    public void deleteRiskbyid(long id) {

    }

    @Override
    public void deleteRisk(Risk risk) {

    }

    @Override
    public void saveRisk(Risk risk) {

    }
}
