package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.Portfolio;

public interface PortfolioSimulationServiceI {
    double getTenPercentBestCase (int num_years, int num_sim, Portfolio portfolio);
    double getTenPercentWorstCase (int num_years, int num_sim, Portfolio portfolio);
    double getMedian (int num_years, int num_sim, Portfolio portfolio);
}
