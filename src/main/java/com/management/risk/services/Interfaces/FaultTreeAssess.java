package com.management.risk.services.Interfaces;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.UsedMethod;

public interface FaultTreeAssess {
    double assess (LeafEvent leafEvent, UsedMethod usedMethod);
}
