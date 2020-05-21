package com.management.risk.Analysis.AcceptanceRejectionSampling;

import com.management.risk.models.Identification.DistributionEnum;
import org.apache.commons.math3.distribution.*;

public class RejectionSampler {
    private DistributionEnum distribution;
    private double threshold;
    private double param1;
    private double param2;

    public RejectionSampler(DistributionEnum distribution, double threshold) {
        this.distribution = distribution;
        this.threshold = threshold;
    }
    AbstractRealDistribution distribution(){
        switch (this.distribution){
            case Gamma: return new GammaDistribution(this.param1, this.param2);
            case Gaussian: return new NormalDistribution(this.param1,this.param2);
            case Chi_square: return new ChiSquaredDistribution(this.param1);
            case Log_normal: return new LogNormalDistribution(this.param1,this.param2);
            case Student: return new TDistribution(this.param1);
            case Laplace:return new LaplaceDistribution(this.param1,this.param2);
            case Gumbel:return new GumbelDistribution(this.param1,this.param2);
        }
        return null;
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