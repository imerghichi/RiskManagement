package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Risk;

import java.util.ArrayList;
import java.util.List;

/**
 * The interface Risk matrix service i.
 */
public interface RiskMatrixServiceI {
    /**
     * Gets matrix.
     *
     * @param probability_interval_division the probability interval division
     * @param risks                         the risks
     * @return the matrix
     */
    List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks);

    /**
     * Gets matrix.
     *
     * @param probability_interval_division the probability interval division
     * @param risks                         the risks
     * @param capacity                      the capacity
     * @return the matrix
     */
    List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks, int capacity);

    /**
     * Gets matrix.
     *
     * @param risks the risks
     * @return the matrix
     */
    List<ArrayList<ArrayList<Risk>>> getMatrix(ArrayList<Risk> risks);
}
