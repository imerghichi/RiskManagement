package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Portfolio;

/**
 * The interface Portfolio simulation service i.
 */
public interface PortfolioSimulationServiceI {
    /**
     * Gets ten percent best case.
     *
     * @param num_years the num years
     * @param num_sim   the num sim
     * @param portfolio the portfolio
     * @return the ten percent best case
     */
    double getTenPercentBestCase (int num_years, int num_sim, Portfolio portfolio);

    /**
     * Gets ten percent worst case.
     *
     * @param num_years the num years
     * @param num_sim   the num sim
     * @param portfolio the portfolio
     * @return the ten percent worst case
     */
    double getTenPercentWorstCase (int num_years, int num_sim, Portfolio portfolio);

    /**
     * Gets median.
     *
     * @param num_years the num years
     * @param num_sim   the num sim
     * @param portfolio the portfolio
     * @return the median
     */
    double getMedian (int num_years, int num_sim, Portfolio portfolio);
}
