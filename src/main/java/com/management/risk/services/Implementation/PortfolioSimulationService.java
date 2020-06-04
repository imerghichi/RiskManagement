package com.management.risk.services.Implementation;

import com.management.risk.Analysis.PortfolioAnalysis.PortfolioSimulation;
import com.management.risk.Identification.Portfolio;
import com.management.risk.services.Interfaces.PortfolioSimulationServiceI;
import org.springframework.stereotype.Service;

/**
 * The type Portfolio simulation service.
 */
@Service
public class PortfolioSimulationService implements PortfolioSimulationServiceI {
    /**
     * Gets ten percent best case.
     *
     * @param num_years the num years
     * @param num_sim   the num sim
     * @param portfolio the portfolio
     * @return the ten percent best case
     */
    @Override
    public double getTenPercentBestCase(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation =new PortfolioSimulation(num_years, num_sim, portfolio);
        return portfolioSimulation.simulate().get(0);
    }

    /**
     * Gets ten percent worst case.
     *
     * @param num_years the num years
     * @param num_sim   the num sim
     * @param portfolio the portfolio
     * @return the ten percent worst case
     */
    @Override
    public double getTenPercentWorstCase(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation =new PortfolioSimulation(num_years, num_sim, portfolio);
        return portfolioSimulation.simulate().get(1);    }

    /**
     * Gets median.
     *
     * @param num_years the num years
     * @param num_sim   the num sim
     * @param portfolio the portfolio
     * @return the median
     */
    @Override
    public double getMedian(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation =new PortfolioSimulation(num_years, num_sim, portfolio);
        return portfolioSimulation.simulate().get(2);
    }

}
