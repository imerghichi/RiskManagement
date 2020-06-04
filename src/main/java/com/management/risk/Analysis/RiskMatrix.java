package com.management.risk.Analysis;


import com.management.risk.Identification.Impact;
import com.management.risk.Identification.Risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Risk matrix.
 */
public class RiskMatrix {
    /**
     * The Probability interval division.
     */
    private int probability_interval_division = 4;
    /**
     * The Impacts lenght.
     */
    private final int impacts_lenght = Impact.values().length;
    /**
     * The Risks.
     */
    private ArrayList<Risk> risks;
    /**
     * The Capacity.
     */
    private int capacity = 4;

    /**
     * Instantiates a new Risk matrix.
     *
     * @param risks the risks
     */
    public RiskMatrix(ArrayList<Risk> risks) {
        this.risks = risks;
    }

    /**
     * Instantiates a new Risk matrix.
     *
     * @param probability_interval_division the probability interval division
     * @param risks                         the risks
     */
    public RiskMatrix(int probability_interval_division, ArrayList<Risk> risks) {
        this.probability_interval_division = probability_interval_division;
        this.risks = risks;
    }

    /**
     * Establish matrix risk list.
     *
     * @return the list
     */
    public List<ArrayList<ArrayList<Risk>>> establish_matrix_risk(){
        ArrayList<Risk> risks1 = new ArrayList<>(Collections.nCopies(this.capacity, new Risk()));
        ArrayList<ArrayList<Risk>> list = new ArrayList<>(Collections.nCopies(this.impacts_lenght, risks1));
        ArrayList<ArrayList<ArrayList<Risk>>> matrix = new ArrayList<>(Collections.nCopies(this.probability_interval_division, list));
        for (Risk risk:
                this.risks) {
            int x = (int) Math.floor(risk.getProbability()* this.probability_interval_division);
            int y = risk.getImpact().getValue();
            matrix.get(y).get(x).add(risk);
        }
        return matrix;
    }

    /**
     * Gets probability interval division.
     *
     * @return the probability interval division
     */
    public int getProbability_interval_division() {
        return probability_interval_division;
    }

    /**
     * Sets probability interval division.
     *
     * @param probability_interval_division the probability interval division
     */
    public void setProbability_interval_division(int probability_interval_division) {
        this.probability_interval_division = probability_interval_division;
    }

    /**
     * Gets impacts lenght.
     *
     * @return the impacts lenght
     */
    public int getImpacts_lenght() {
        return impacts_lenght;
    }

    /**
     * Gets risks.
     *
     * @return the risks
     */
    public ArrayList<Risk> getRisks() {
        return risks;
    }

    /**
     * Sets risks.
     *
     * @param risks the risks
     */
    public void setRisks(ArrayList<Risk> risks) {
        this.risks = risks;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
