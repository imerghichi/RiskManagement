package com.management.risk.Analysis.MonteCarlo;


import com.management.risk.models.Identification.Activity;
import mcsimulations.simulation.MCSimulation;
import mcsimulations.simulation.SimulationResults;
import org.hibernate.sql.MckoiCaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MonteCarlo {
    private List<Activity> activities;

    public MonteCarlo(List<Activity> activities) {
        this.activities = activities;
    }
    List<List<Object>> actarray(){
        List<List<Object>> res = new ArrayList<>();
        for (Activity activity:
             activities) {
            //todo :lalogique poru remplirllaliste
        }
        return res;
    }
    public SimulationResults simulate() throws Exception {
        MCSimulation mcSimulation =new MCSimulation(false,3,actarray());
        return mcSimulation.results();
    }
}

