package com.management.risk.services.Implementation;

import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Identification.RiskMatrix;
import com.management.risk.services.Interfaces.RiskMatrixServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskMatrixService implements RiskMatrixServiceI {
    @Override
    public List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks) {
        RiskMatrix riskMatrix = new RiskMatrix(probability_interval_division,risks);
        return riskMatrix.establish_matrix_risk();
    }

    @Override
    public List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks, int capacity) {
        RiskMatrix riskMatrix = new RiskMatrix(probability_interval_division,risks);
        riskMatrix.setCapacity(capacity);
        return riskMatrix.establish_matrix_risk();
    }

    @Override
    public List<ArrayList<ArrayList<Risk>>> getMatrix(ArrayList<Risk> risks) {
        RiskMatrix riskMatrix = new RiskMatrix(risks);
        return riskMatrix.establish_matrix_risk();
    }
}
