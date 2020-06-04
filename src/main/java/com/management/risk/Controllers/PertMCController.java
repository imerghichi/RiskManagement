package com.management.risk.Controllers;

import com.management.risk.Identification.Activity;
import com.management.risk.services.Implementation.PertMCService;
import mcsimulations.simulation.ComputeException;
import mcsimulations.simulation.SimulationResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Pert mc controller.
 */
@RestController("/PertMC")
public class PertMCController {
    /**
     * The Pert mc service.
     */
    @Autowired
    private PertMCService pertMCService;

    /**
     * Gets pert mc.
     *
     * @param activities the activities
     * @return the pert mc
     * @throws Exception the exception
     */
    @GetMapping(value = "/MC/")
    @ResponseBody
    public SimulationResults getPertMC(@RequestBody List<Activity> activities) throws Exception {
            return pertMCService.pertMC(activities);
    }
}
