package com.management.risk.services.Interfaces;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.UsedMethod;

/**
 * The interface Fault tree assess.
 */
public interface FaultTreeAssess {
    /**
     * Assess double.
     *
     * @param leafEvent  the leaf event
     * @param usedMethod the used method
     * @return the double
     */
    double assess (LeafEvent leafEvent, UsedMethod usedMethod);
}
