package com.management.risk.services.Interfaces;

import com.management.risk.Identification.DistributionEnum;

public interface AcceptanceRejectionServiceI {
    double acceptanceRejection(DistributionEnum distributionEnum, double threshold, double param1);
    double acceptanceRejection(DistributionEnum distributionEnum, double threshold, double param1, double param2);
}
