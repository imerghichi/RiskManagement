package com.management.risk.Analysis.PortfolioAnalysis;

import com.management.risk.Identification.Portfolio;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Portfolio simulation.
 */
//with monte carlo
public class PortfolioSimulation {
    /**
     * The Number of simulations.
     */
    private int number_of_simulations;
    /**
     * The Number of years.
     */
    private int number_of_years;
    /**
     * The Portfolio.
     */
    private Portfolio portfolio;
    /**
     * The Normal distribution.
     */
    private NormalDistribution normalDistribution;
    /**
     * The Descriptive statistics.
     */
    private DescriptiveStatistics descriptiveStatistics;

    /**
     * Instantiates a new Portfolio simulation.
     *
     * @param number_of_simulations the number of simulations
     * @param number_of_years       the number of years
     * @param portfolio             the portfolio
     */
    public PortfolioSimulation(int number_of_simulations, int number_of_years, Portfolio portfolio) {
        this.number_of_simulations = number_of_simulations;
        this.number_of_years = number_of_years;
        this.portfolio = portfolio;
        this.normalDistribution = new NormalDistribution(portfolio.getMean(),portfolio.getStandardDeviation());
        this.descriptiveStatistics = new DescriptiveStatistics();
    }

    /**
     * Gets number of simulations.
     *
     * @return the number of simulations
     */
    public int getNumber_of_simulations() {
        return number_of_simulations;
    }

    /**
     * Sets number of simulations.
     *
     * @param number_of_simulations the number of simulations
     */
    public void setNumber_of_simulations(int number_of_simulations) {
        this.number_of_simulations = number_of_simulations;
    }

    /**
     * Gets number of years.
     *
     * @return the number of years
     */
    public int getNumber_of_years() {
        return number_of_years;
    }

    /**
     * Sets number of years.
     *
     * @param number_of_years the number of years
     */
    public void setNumber_of_years(int number_of_years) {
        this.number_of_years = number_of_years;
    }

    /**
     * Gets portfolio.
     *
     * @return the portfolio
     */
    public Portfolio getPortfolio() {
        return portfolio;
    }

    /**
     * Sets portfolio.
     *
     * @param portfolio the portfolio
     */
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    /**
     * Gets normal distribution.
     *
     * @return the normal distribution
     */
    public NormalDistribution getNormalDistribution() {
        return normalDistribution;
    }

    /**
     * Sets normal distribution.
     *
     * @param normalDistribution the normal distribution
     */
    public void setNormalDistribution(NormalDistribution normalDistribution) {
        this.normalDistribution = normalDistribution;
    }

    /**
     * Gets descriptive statistics.
     *
     * @return the descriptive statistics
     */
    public DescriptiveStatistics getDescriptiveStatistics() {
        return descriptiveStatistics;
    }

    /**
     * Sets descriptive statistics.
     *
     * @param descriptiveStatistics the descriptive statistics
     */
    public void setDescriptiveStatistics(DescriptiveStatistics descriptiveStatistics) {
        this.descriptiveStatistics = descriptiveStatistics;
    }

    /**
     * Get random future value double.
     *
     * @return the double
     */
    public double getRandomFutureValue(){
        return this.getNormalDistribution().sample();
    }

    /**
     * Simulate list.
     *
     * @return the list
     */
    public List<Double> simulate(){
        List<Double> list = new ArrayList<>();
        int simulation = 0;

        while (simulation < number_of_simulations){
            int year = 0;
            BigDecimal totalInvest = this.portfolio.getInitialInvestment();
            while (year < number_of_years){
                double rand = getRandomFutureValue();
                totalInvest = new  BigDecimal(1 + (rand - portfolio.getInflationRate())).multiply(totalInvest);
                year++;
            }
            this.getDescriptiveStatistics().addValue(totalInvest.doubleValue());
            simulation++;
        }
        list.add(this.descriptiveStatistics.getPercentile(90));
        list.add(this.descriptiveStatistics.getPercentile(10));
        list.add(this.descriptiveStatistics.getPercentile(50));
        this.portfolio.setTenPercentBestCase(this.descriptiveStatistics.getPercentile(90));
        this.portfolio.setTenPercentWorstCase(this.descriptiveStatistics.getPercentile(10));
        this.portfolio.setMedian(this.getDescriptiveStatistics().getPercentile(50));
        return list;
    }
    public double simulate (double percentile){
        int simulation = 0;

        while (simulation < number_of_simulations){
            int year = 0;
            BigDecimal totalInvest = this.portfolio.getInitialInvestment();
            while (year < number_of_years){
                double rand = getRandomFutureValue();
                totalInvest = new  BigDecimal(1 + (rand - portfolio.getInflationRate())).multiply(totalInvest);
                year++;
            }
            this.getDescriptiveStatistics().addValue(totalInvest.doubleValue());
            simulation++;
        }
        return this.descriptiveStatistics.getPercentile(percentile);
    }

}
