package com.management.risk.Analysis;


import com.management.risk.Identification.Impact;
import com.management.risk.Identification.Risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RiskMatrix {
    private int probability_interval_division = 4;
    private final int impacts_lenght = Impact.values().length;
    private ArrayList<Risk> risks;
    private int capacity = 4;
    public RiskMatrix(ArrayList<Risk> risks) {
        this.risks = risks;
    }

    public RiskMatrix(int probability_interval_division, ArrayList<Risk> risks) {
        this.probability_interval_division = probability_interval_division;
        this.risks = risks;
    }

    public List<ArrayList<ArrayList<Risk>>> establish_matrix_risk(){
        ArrayList<Risk> risks1 = new ArrayList<Risk>(Collections.nCopies(this.capacity, new Risk()));
        ArrayList<ArrayList<Risk>> list = new ArrayList<>(Collections.nCopies(this.impacts_lenght, risks1));
        ArrayList<ArrayList<ArrayList<Risk>>> matrix = new ArrayList<>(Collections.nCopies(this.probability_interval_division, list));
        for (Risk risk:
                this.risks) {
            int x = (int) Math.floor(risk.getProbabilty()* this.probability_interval_division);
            int y = risk.getImpact().getValue();
            matrix.get(y).get(x).add(risk);
        }
        return matrix;
    }

    public int getProbability_interval_division() {
        return probability_interval_division;
    }

    public void setProbability_interval_division(int probability_interval_division) {
        this.probability_interval_division = probability_interval_division;
    }

    public int getImpacts_lenght() {
        return impacts_lenght;
    }

    public ArrayList<Risk> getRisks() {
        return risks;
    }

    public void setRisks(ArrayList<Risk> risks) {
        this.risks = risks;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
