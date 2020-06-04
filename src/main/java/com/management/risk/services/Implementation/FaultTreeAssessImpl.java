package com.management.risk.services.Implementation;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.FaultTree;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.UsedMethod;
import com.management.risk.services.Interfaces.FaultTreeAssess;
import org.springframework.stereotype.Service;

/**
 * The type Fault tree assess.
 */
@Service
public class FaultTreeAssessImpl implements FaultTreeAssess {
    /**
     * Assess double.
     *
     * @param leafEvent  the leaf event
     * @param usedMethod the used method
     * @return the double
     */
    @Override
    public double assess(LeafEvent leafEvent, UsedMethod usedMethod) {
        FaultTree faultTree =new FaultTree(usedMethod, leafEvent);
        return faultTree.assess();
    }
}
