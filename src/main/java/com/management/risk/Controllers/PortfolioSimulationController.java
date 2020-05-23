package com.management.risk.Controllers;

import com.management.risk.models.Identification.Portfolio;
import com.management.risk.services.Implementation.PortfolioService;
import com.management.risk.services.Implementation.PortfolioSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/portfoliosim")
public class PortfolioSimulationController {
    @Autowired
    private PortfolioSimulationService portfolioSimulationService;

    private PortfolioService portfolioService;

    @GetMapping("/10W/{id}/{years}/{sim}")
    @ResponseBody
    public double get10W(@PathVariable long id, @PathVariable int years, @PathVariable int sim) throws Exception {
        Portfolio portfolio = portfolioService.findById(id).orElseThrow(Exception::new);
        return portfolioSimulationService.getTenPercentWorstCase(years,sim,portfolio);
    }

    @GetMapping("/10B/{id}/{years}/{sim}")
    @ResponseBody
    public double get10B(@PathVariable long id, @PathVariable int years, @PathVariable int sim) throws Exception {
        Portfolio portfolio = portfolioService.findById(id).orElseThrow(Exception::new);
        return portfolioSimulationService.getTenPercentBestCase(years,sim,portfolio);
    }

    @GetMapping("/median/{id}/{years}/{sim}")
    @ResponseBody
    public double getmedian(@PathVariable long id, @PathVariable int years, @PathVariable int sim) throws Exception {
        Portfolio portfolio = portfolioService.findById(id).orElseThrow(Exception::new);
        return portfolioSimulationService.getMedian(years,sim,portfolio);
    }


}
