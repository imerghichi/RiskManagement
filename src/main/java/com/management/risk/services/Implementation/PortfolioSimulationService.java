package com.management.risk.services.Implementation;

import antlr.collections.List;
import com.management.risk.Analysis.PortfolioAnalysis.PortfolioSimulation;
import com.management.risk.Identification.Portfolio;
import com.management.risk.services.Interfaces.PortfolioSimulationServiceI;
import org.springframework.stereotype.Service;

/**
 * The type Portfolio simulation service.
 */
@Service
public class PortfolioSimulationService implements PortfolioSimulationServiceI {


    @Override
    public double[] getallPercetilles(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation = new PortfolioSimulation(num_sim, num_years, portfolio);
        double[] resultat = new double[0];
        resultat[0] = portfolioSimulation.simulate(10);
        resultat[1] = portfolioSimulation.simulate(20);
        resultat[2] = portfolioSimulation.simulate(30);
        resultat[3] = portfolioSimulation.simulate(40);
        resultat[4] = portfolioSimulation.simulate(50);
        resultat[5] = portfolioSimulation.simulate(60);
        resultat[6] = portfolioSimulation.simulate(70);
        resultat[7] = portfolioSimulation.simulate(80);
        resultat[8] = portfolioSimulation.simulate(90);
        resultat[9] = portfolioSimulation.simulate(100);
        return resultat;
    }

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
