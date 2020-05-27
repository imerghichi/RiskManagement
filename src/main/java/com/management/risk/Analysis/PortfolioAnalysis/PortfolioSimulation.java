package com.management.risk.Analysis.PortfolioAnalysis;

import com.management.risk.Identification.Portfolio;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//with monte carlo
public class PortfolioSimulation {
    private int number_of_simulations;
    private int number_of_years;
    private Portfolio portfolio;
    private NormalDistribution normalDistribution;
    private DescriptiveStatistics descriptiveStatistics;

    public PortfolioSimulation(int number_of_simulations, int number_of_years, Portfolio portfolio) {
        this.number_of_simulations = number_of_simulations;
        this.number_of_years = number_of_years;
        this.portfolio = portfolio;
        this.normalDistribution = new NormalDistribution(portfolio.getMean(),portfolio.getStandardDeviation());
        this.descriptiveStatistics = new DescriptiveStatistics();
    }

    public int getNumber_of_simulations() {
        return number_of_simulations;
    }

    public void setNumber_of_simulations(int number_of_simulations) {
        this.number_of_simulations = number_of_simulations;
    }

    public int getNumber_of_years() {
        return number_of_years;
    }

    public void setNumber_of_years(int number_of_years) {
        this.number_of_years = number_of_years;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public NormalDistribution getNormalDistribution() {
        return normalDistribution;
    }

    public void setNormalDistribution(NormalDistribution normalDistribution) {
        this.normalDistribution = normalDistribution;
    }

    public DescriptiveStatistics getDescriptiveStatistics() {
        return descriptiveStatistics;
    }

    public void setDescriptiveStatistics(DescriptiveStatistics descriptiveStatistics) {
        this.descriptiveStatistics = descriptiveStatistics;
    }

    public double getRandomFutureValue(){
        return this.getNormalDistribution().sample();
    }

    public List<Double> simulate(){
        List<Double> list = new ArrayList<>();
        int simulation = 0;

        while (simulation < number_of_simulations){
            int year = 0;
            BigDecimal totalInvest = this.portfolio.getInitialInvestment();
            while (year < number_of_years){
                double rand = getRandomFutureValue();
                totalInvest = new BigDecimal(1 + (rand - portfolio.getInflationRate())).multiply(totalInvest);
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

}
