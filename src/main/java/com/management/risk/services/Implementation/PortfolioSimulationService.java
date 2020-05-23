package com.management.risk.services.Implementation;

import com.management.risk.Analysis.PortfolioAnalysis.PortfolioSimulation;
import com.management.risk.models.Identification.Portfolio;
import com.management.risk.services.Interfaces.PortfolioSimulationServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioSimulationService implements PortfolioSimulationServiceI {
    @Override
    public double getTenPercentBestCase(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation =new PortfolioSimulation(num_years, num_sim, portfolio);
        return portfolioSimulation.simulate().get(0);
    }

    @Override
    public double getTenPercentWorstCase(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation =new PortfolioSimulation(num_years, num_sim, portfolio);
        return portfolioSimulation.simulate().get(1);    }

    @Override
    public double getMedian(int num_years, int num_sim, Portfolio portfolio) {
        PortfolioSimulation portfolioSimulation =new PortfolioSimulation(num_years, num_sim, portfolio);
        return portfolioSimulation.simulate().get(2);
    }

}
