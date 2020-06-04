package com.management.risk.services.Implementation;

import com.management.risk.Analysis.AcceptanceRejectionSampling.RejectionSampler;
import com.management.risk.Identification.Activity;
import com.management.risk.Identification.DistributionEnum;
import com.management.risk.services.Interfaces.AcceptanceRejectionServiceI;
import org.springframework.stereotype.Service;

/**
 * The type Acceptance rejection service.
 */
@Service
public class AcceptanceRejectionService implements AcceptanceRejectionServiceI {
    /**
     * Acceptance rejection double.
     *
     * @param threshold the threshold
     * @param activity  the activity
     * @return the double
     */
    @Override
    public double acceptanceRejection(double threshold, Activity activity) {
        RejectionSampler rejectionSampler = new RejectionSampler(threshold, activity);
        return rejectionSampler.simulate();

    }
}
