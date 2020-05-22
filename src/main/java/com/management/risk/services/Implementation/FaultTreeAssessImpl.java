package com.management.risk.services.Implementation;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.FaultTree;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.UsedMethod;
import com.management.risk.services.Interfaces.FaultTreeAssess;
import org.springframework.stereotype.Service;

@Service
public class FaultTreeAssessImpl implements FaultTreeAssess {
    @Override
    public double assess(LeafEvent leafEvent, UsedMethod usedMethod) {
        FaultTree faultTree =new FaultTree(usedMethod, leafEvent);
        return faultTree.assess();
    }
}
