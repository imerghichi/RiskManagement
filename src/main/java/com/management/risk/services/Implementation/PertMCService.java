package com.management.risk.services.Implementation;

import com.management.risk.Analysis.MonteCarlo.MonteCarlo;
import com.management.risk.Identification.Activity;
import com.management.risk.services.Interfaces.PertMCServiceI;
import mcsimulations.simulation.SimulationResults;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Pert mc service.
 */
@Service
public class PertMCService implements PertMCServiceI {
    /**
     * Pert mc simulation results.
     *
     * @param activities the activities
     * @return the simulation results
     * @throws Exception the exception
     */
    @Override
    public SimulationResults pertMC(List<Activity> activities) throws Exception {
        MonteCarlo monteCarlo = new MonteCarlo(activities);
        return monteCarlo.simulate();
    }
}
