package com.management.risk.Analysis.MonteCarlo;

import com.management.risk.models.Identification.Activity;

public class BetaCalculate {

    private static final int lambda = 4;
    private final Activity activity;


    private double meanres;
    private double variance;
    private double common_factor;
    private double beta;
    private double alpha;
    private double k1;

    public BetaCalculate(Activity activity) {
        this.activity = activity;
    }


    public double getBeta() {
        return 1 + lambda * ((activity.getMean_duration() - activity.getMin_duration()) / (activity.getMax_duration() - activity.getMin_duration()));
    }

    public double getAlpha() {
        return 1 + lambda * ((activity.getMax_duration() - activity.getMean_duration()) / (activity.getMax_duration() - activity.getMin_duration()));
    }

    public double scaleValue(double beta){
        return activity.getMin_duration() + (beta * (activity.getMax_duration() - activity.getMin_duration()));
    }


}
