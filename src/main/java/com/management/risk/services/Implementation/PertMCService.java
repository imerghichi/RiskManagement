package com.management.risk.services.Implementation;

import com.management.risk.Analysis.MonteCarlo.MonteCarlo;
import com.management.risk.models.Identification.Activity;
import com.management.risk.services.Interfaces.PertMCServiceI;
import mcsimulations.simulation.SimulationResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PertMCService implements PertMCServiceI {
    @Override
    public SimulationResults pertMC(List<Activity> activities) throws Exception {
        MonteCarlo monteCarlo = new MonteCarlo(activities);
        return monteCarlo.simulate();
    }
}
