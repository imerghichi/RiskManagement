package com.management.risk.Analysis.AcceptanceRejectionSampling;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.DistributionEnum;
import org.apache.commons.math3.distribution.*;

public class RejectionSampler {
    private double threshold;
    private Activity activity;
    public RejectionSampler( double threshold, Activity activity) {
        this.threshold = threshold;
        this.activity = activity;
    }
    AbstractRealDistribution distribution(){
        switch (this.activity.getDistribution()){
            case Gamma: return new GammaDistribution(activity.getParametre1(), activity.getParametre1());
            case Gaussian: return new NormalDistribution(activity.getParametre1(), activity.getParametre1());
            case Chi_square: return new ChiSquaredDistribution(activity.getParametre1());
            case Log_normal: return new LogNormalDistribution(activity.getParametre1(), activity.getParametre1());
            case Student: return new TDistribution(activity.getParametre1());
            case Laplace:return new LaplaceDistribution(activity.getParametre1(), activity.getParametre1());
            case Gumbel:return new GumbelDistribution(activity.getParametre1(), activity.getParametre1());
        }
        return null;
    }


    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }


    public double getThreshold() {
        return threshold;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public double simulate(){
        UniformRealDistribution distribution_uniform = new UniformRealDistribution(0,1);
        double x;
        double u;
        do{
            x = this.distribution().sample();
            u = distribution_uniform.sample();
        } while (u >= (this.threshold)* (this.distribution().density(x) / distribution_uniform.density(x)));
        return x;
    }
}