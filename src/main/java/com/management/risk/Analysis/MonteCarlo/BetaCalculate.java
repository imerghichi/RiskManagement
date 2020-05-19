package com.management.risk.Analysis.MonteCarlo;

import com.management.risk.models.Identification.Activity;

public class BetaCalculate {

    private static final int lambda = 4;
    private final int optimistic ;
    private final int pessimistic;
    private final int most_likely;

    private double meanres;
    private double variance;
    private double common_factor;
    private double beta;
    private double alpha;
    private double k1;

    public BetaCalculate(int optimistic, int pessimistic, int most_likely) {
        this.optimistic = optimistic;
        this.pessimistic = pessimistic;
        this.most_likely = most_likely;
    }

    public double getBeta() {
        return  (double) 1 + lambda * ((most_likely - optimistic) / (pessimistic - optimistic));
    }

    public double getAlpha() {
        return (double) 1 + lambda * ((pessimistic - most_likely) / (pessimistic - optimistic));
    }

    public double scaleValue(double beta){
        return optimistic + (beta * (pessimistic - optimistic));
    }


}
