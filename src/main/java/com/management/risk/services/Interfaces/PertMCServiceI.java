package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Activity;
import mcsimulations.simulation.SimulationResults;

import java.util.List;

public interface PertMCServiceI {
    SimulationResults pertMC(List<Activity> activities) throws Exception;
}
