package com.management.risk.Identification;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id_portfolio;
    private String description;
    private double mean;
    private double standardDeviation;
    private BigDecimal initialInvestment;
    private double inflationRate;
    @OneToOne
    private Project project;
    @Transient
    private double median;
    @Transient
    private double tenPercentBestCase;
    @Transient
    private double tenPercentWorstCase;


    public Portfolio() {
    }

    public long getId_portfolio() {
        return id_portfolio;
    }

    public void setId_portfolio(long id_portfolio) {
        this.id_portfolio = id_portfolio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public BigDecimal getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(BigDecimal initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getTenPercentBestCase() {
        return tenPercentBestCase;
    }

    public void setTenPercentBestCase(double tenPercentBestCase) {
        this.tenPercentBestCase = tenPercentBestCase;
    }

    public double getTenPercentWorstCase() {
        return tenPercentWorstCase;
    }

    public void setTenPercentWorstCase(double tenPercentWorstCase) {
        this.tenPercentWorstCase = tenPercentWorstCase;
    }

    public double getInflationRate() {
        return inflationRate;
    }

    public void setInflationRate(double inflationRate) {
        this.inflationRate = inflationRate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
