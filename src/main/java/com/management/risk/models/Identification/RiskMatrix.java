package com.management.risk.models.Identification;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RiskMatrix {
    private int probability_interval_division = 4;
    private int impacts_lenght = Impact.values().length;
    private ArrayList<Risk> risks;
    private int capacity =1;
    public RiskMatrix(ArrayList<Risk> risks) {
        this.risks = risks;
    }

    public RiskMatrix(int probability_interval_division, int impacts_lenght, ArrayList<Risk> risks) {
        this.probability_interval_division = probability_interval_division;
        this.impacts_lenght = impacts_lenght;
        this.risks = risks;
    }

    public List<ArrayList<ArrayList<Long>>> establish_matrix_risk(){
        ArrayList<Long> longs = new ArrayList<>(Collections.nCopies(capacity, (long) 0));
        ArrayList<ArrayList<Long>> list = new ArrayList<>(Collections.nCopies(impacts_lenght, longs));
        ArrayList<ArrayList<ArrayList<Long>>> matrix = new ArrayList<>(Collections.nCopies(probability_interval_division, list));
        for (Risk risk:
                risks) {
            int x = (int) Math.floor(risk.getProbabilty()* this.probability_interval_division);
            int y = risk.getImpact().getValue();
            matrix.get(y).get(x).add(risk.getId_risk());
        }
        return matrix;
    }



}
