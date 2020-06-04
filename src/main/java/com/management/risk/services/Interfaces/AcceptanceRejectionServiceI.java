package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.DistributionEnum;

/**
 * The interface Acceptance rejection service i.
 */
public interface AcceptanceRejectionServiceI {
    /**
     * Acceptance rejection double.
     *
     * @param threshold the threshold
     * @param activity  the activity
     * @return the double
     */
    double acceptanceRejection(double threshold, Activity activity);
}
