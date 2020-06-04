package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Activity;
import mcsimulations.simulation.SimulationResults;

import java.util.List;

/**
 * The interface Pert mc service i.
 */
public interface PertMCServiceI {
    /**
     * Pert mc simulation results.
     *
     * @param activities the activities
     * @return the simulation results
     * @throws Exception the exception
     */
    SimulationResults pertMC(List<Activity> activities) throws Exception;
}
