package com.management.risk.Controllers;

import com.management.risk.Exception.BusinessException;
import com.management.risk.Exception.Exceptions;
import com.management.risk.Identification.Portfolio;
import com.management.risk.services.Implementation.PortfolioService;
import com.management.risk.services.Implementation.PortfolioSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Portfolio simulation controller.
 */
@RestController("/portfoliosim")
public class PortfolioSimulationController {
    /**
     * The Portfolio simulation service.
     */
    @Autowired
    private PortfolioSimulationService portfolioSimulationService;

    /**
     * The Portfolio service.
     */
    private PortfolioService portfolioService;

    /**
     * Gets 10 w.
     *
     * @param id    the id
     * @param years the years
     * @param sim   the sim
     * @return the 10 w
     * @throws Exception         the exception
     * @throws BusinessException the business exception
     */
    @GetMapping("/10W/{id}/{years}/{sim}")
    @ResponseBody
    public double get10W(@PathVariable long id, @PathVariable int years, @PathVariable int sim) throws Exception, BusinessException {
        if(years <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_YEAR.toString());
        if(sim  <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_SIM.toString());
        Portfolio portfolio = portfolioService.findById(id).orElseThrow(Exception::new);
        return portfolioSimulationService.getTenPercentWorstCase(years,sim,portfolio);
    }

    /**
     * Gets 10 b.
     *
     * @param id    the id
     * @param years the years
     * @param sim   the sim
     * @return the 10 b
     * @throws Exception         the exception
     * @throws BusinessException the business exception
     */
    @GetMapping("/10B/{id}/{years}/{sim}")
    @ResponseBody
    public double get10B(@PathVariable long id, @PathVariable int years, @PathVariable int sim) throws Exception, BusinessException {
        if(years <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_YEAR.toString());
        if(sim  <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_SIM.toString());
        Portfolio portfolio = portfolioService.findById(id).orElseThrow(Exception::new);
        return portfolioSimulationService.getTenPercentBestCase(years,sim,portfolio);
    }

    /**
     * Gets .
     *
     * @param id    the id
     * @param years the years
     * @param sim   the sim
     * @return the
     * @throws Exception         the exception
     * @throws BusinessException the business exception
     */
    @GetMapping("/median/{id}/{years}/{sim}")
    @ResponseBody
    public double getmedian(@PathVariable long id, @PathVariable int years, @PathVariable int sim) throws Exception, BusinessException {
        if(years <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_YEAR.toString());
        if(sim  <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_SIM.toString());
        Portfolio portfolio = portfolioService.findById(id).orElseThrow(Exception::new);
        return portfolioSimulationService.getMedian(years,sim,portfolio);
    }


}
