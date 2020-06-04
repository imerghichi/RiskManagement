package com.management.risk.Analysis.MonteCarlo;


import com.management.risk.Identification.Activity;
import mcsimulations.simulation.MCSimulation;
import mcsimulations.simulation.SimulationResults;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Monte carlo.
 */
public class MonteCarlo {
    /**
     * The Activities.
     */
    private List<Activity> activities;

    /**
     * Instantiates a new Monte carlo.
     *
     * @param activities the activities
     */
    public MonteCarlo(List<Activity> activities) {
        this.activities = activities;
    }

    /**
     * Actarray list.
     *
     * @return the list
     */
    List<List<Object>> actarray(){
        List<List<Object>> res = new ArrayList<>();
        for (Activity activity:
             activities) {
            //todo :lalogique poru remplirllaliste
        }
        return res;
    }

    /**
     * Simulate simulation results.
     *
     * @return the simulation results
     * @throws Exception the exception
     */
    public SimulationResults simulate() throws Exception {
        MCSimulation mcSimulation =new MCSimulation(false,3,actarray());
        return mcSimulation.results();
    }
}

