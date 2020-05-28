package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.DistributionEnum;

public interface AcceptanceRejectionServiceI {
    double acceptanceRejection(double threshold, Activity activity);
}
