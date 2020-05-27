package com.management.risk.Identification;

public enum DistributionEnum {
    Uniform,
    Triangular,
    Gaussian,
    Exponential,
    Beta,
    //for rejection sampler
    Gamma,
    Chi_square,
  //  Half_normal,
    Log_normal,
    Student,
    Laplace,
    Gumbel;

     DistributionEnum() {
    }

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
