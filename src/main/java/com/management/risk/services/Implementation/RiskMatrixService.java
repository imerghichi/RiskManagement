package com.management.risk.services.Implementation;

import com.management.risk.Identification.Risk;
import com.management.risk.Analysis.RiskMatrix;
import com.management.risk.services.Interfaces.RiskMatrixServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Risk matrix service.
 */
@Service
public class RiskMatrixService implements RiskMatrixServiceI {
    /**
     * Gets matrix.
     *
     * @param probability_interval_division the probability interval division
     * @param risks                         the risks
     * @return the matrix
     */
    @Override
    public List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks) {
        RiskMatrix riskMatrix = new RiskMatrix(probability_interval_division,risks);
        return riskMatrix.establish_matrix_risk();
    }

    /**
     * Gets matrix.
     *
     * @param probability_interval_division the probability interval division
     * @param risks                         the risks
     * @param capacity                      the capacity
     * @return the matrix
     */
    @Override
    public List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks, int capacity) {
        RiskMatrix riskMatrix = new RiskMatrix(probability_interval_division,risks);
        riskMatrix.setCapacity(capacity);
        return riskMatrix.establish_matrix_risk();
    }

    /**
     * Gets matrix.
     *
     * @param risks the risks
     * @return the matrix
     */
    @Override
    public List<ArrayList<ArrayList<Risk>>> getMatrix(ArrayList<Risk> risks) {
        RiskMatrix riskMatrix = new RiskMatrix(risks);
        return riskMatrix.establish_matrix_risk();
    }

    /**
     * Gets matrix.
     *
     * @param risks the risks
     * @return the matrix
     */
    public List<ArrayList<ArrayList<Risk>>> getMatrix(List<Risk> risks) {
        RiskMatrix riskMatrix = new RiskMatrix((ArrayList<Risk>) risks);
        return riskMatrix.establish_matrix_risk();
    }


}
