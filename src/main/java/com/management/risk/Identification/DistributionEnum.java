package com.management.risk.Identification;

/**
 * The enum Distribution enum.
 */
public enum DistributionEnum {
    /**
     * Uniform distribution enum.
     */
    Uniform,
    /**
     * Triangular distribution enum.
     */
    Triangular,
    /**
     * Gaussian distribution enum.
     */
    Gaussian,
    /**
     * Exponential distribution enum.
     */
    Exponential,
    /**
     * Beta distribution enum.
     */
    Beta,
    /**
     * The Gamma.
     */
//for rejection sampler
    Gamma,
    /**
     * Chi square distribution enum.
     */
    Chi_square,
    /**
     * Log normal distribution enum.
     */
//  Half_normal,
    Log_normal,
    /**
     * Student distribution enum.
     */
    Student,
    /**
     * Laplace distribution enum.
     */
    Laplace,
    /**
     * Gumbel distribution enum.
     */
    Gumbel;

    /**
     * Instantiates a new Distribution enum.
     */
    DistributionEnum() {
    }

    /**
     * Getdistr distribution enum.
     *
     * @param string the string
     * @return the distribution enum
     */
    public DistributionEnum getdistr(String string){
        if(string.equals("uniform"))
            return DistributionEnum.Uniform;
        if(string.equals("triangular"))
            return DistributionEnum.Triangular;
        if(string.equals("gaussian"))
            return DistributionEnum.Gaussian;
        if (string.equals("exponential"))
            return DistributionEnum.Exponential;
        if (string.equals("beta"))
            return DistributionEnum.Beta;
        if(string.equals("gamma"))
            return DistributionEnum.Gamma;
        if(string.equals("chi_square"))
            return DistributionEnum.Chi_square;
        if(string.equals("log_normal"))
            return DistributionEnum.Log_normal;
        if(string.equals("student"))
            return DistributionEnum.Student;
        if(string.equals("laplace"))
            return DistributionEnum.Laplace;
        if(string.equals("gumbel"))
            return DistributionEnum.Gumbel;
        return null;
    }
}
