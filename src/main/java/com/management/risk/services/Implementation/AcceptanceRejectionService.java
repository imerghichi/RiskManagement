package com.management.risk.services.Implementation;

import com.management.risk.Analysis.AcceptanceRejectionSampling.RejectionSampler;
import com.management.risk.models.Identification.DistributionEnum;
import com.management.risk.services.Interfaces.AcceptanceRejectionServiceI;
import org.springframework.stereotype.Service;

@Service
public class AcceptanceRejectionService implements AcceptanceRejectionServiceI {
    @Override
    public double acceptanceRejection(DistributionEnum distributionEnum, double threshold, double param1) {
        RejectionSampler rejectionSampler = new RejectionSampler(distributionEnum, threshold);
        rejectionSampler.setParam1(param1);
        return rejectionSampler.simulate();
    }

    @Override
    public double acceptanceRejection(DistributionEnum distributionEnum, double threshold, double param1, double param2) {
        RejectionSampler rejectionSampler = new RejectionSampler(distributionEnum, threshold);
        rejectionSampler.setParam1(param1);
        rejectionSampler.setParam2(param2);
        return rejectionSampler.simulate();
    }
}
