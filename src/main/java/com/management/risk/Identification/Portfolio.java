package com.management.risk.Identification;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Portfolio.
 */
@Entity
public class Portfolio {
    /**
     * The Id portfolio.
     */
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id_portfolio;
    /**
     * The Description.
     */
    @Column(unique = true,nullable = false)
    private String description;
    /**
     * The Mean.
     */
    @Column(columnDefinition = "double default 0")
    private double mean;
    /**
     * The Standard deviation.
     */
    @Column(columnDefinition = "double default 0")
    private double standardDeviation;
    /**
     * The Initial investment.
     */
    @Column(columnDefinition = "double default 0")
    private BigDecimal initialInvestment;
    /**
     * The Inflation rate.
     */
    @Column(columnDefinition = "double default 0")
    private double inflationRate;
    /**
     * The Project.
     */
    @OneToOne
    private Project project;
    /**
     * The Median.
     */
    @Transient
    private double median;
    /**
     * The Ten percent best case.
     */
    @Transient
    private double tenPercentBestCase;
    /**
     * The Ten percent worst case.
     */
    @Transient
    private double tenPercentWorstCase;


    /**
     * Instantiates a new Portfolio.
     */
    public Portfolio() {
    }

    /**
     * Gets id portfolio.
     *
     * @return the id portfolio
     */
    public long getId_portfolio() {
        return id_portfolio;
    }

    /**
     * Sets id portfolio.
     *
     * @param id_portfolio the id portfolio
     */
    public void setId_portfolio(long id_portfolio) {
        this.id_portfolio = id_portfolio;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets mean.
     *
     * @return the mean
     */
    public double getMean() {
        return mean;
    }

    /**
     * Sets mean.
     *
     * @param mean the mean
     */
    public void setMean(double mean) {
        this.mean = mean;
    }

    /**
     * Gets standard deviation.
     *
     * @return the standard deviation
     */
    public double getStandardDeviation() {
        return standardDeviation;
    }

    /**
     * Sets standard deviation.
     *
     * @param standardDeviation the standard deviation
     */
    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    /**
     * Gets initial investment.
     *
     * @return the initial investment
     */
    public BigDecimal getInitialInvestment() {
        return initialInvestment;
    }

    /**
     * Sets initial investment.
     *
     * @param initialInvestment the initial investment
     */
    public void setInitialInvestment(BigDecimal initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    /**
     * Gets median.
     *
     * @return the median
     */
    public double getMedian() {
        return median;
    }

    /**
     * Sets median.
     *
     * @param median the median
     */
    public void setMedian(double median) {
        this.median = median;
    }

    /**
     * Gets ten percent best case.
     *
     * @return the ten percent best case
     */
    public double getTenPercentBestCase() {
        return tenPercentBestCase;
    }

    /**
     * Sets ten percent best case.
     *
     * @param tenPercentBestCase the ten percent best case
     */
    public void setTenPercentBestCase(double tenPercentBestCase) {
        this.tenPercentBestCase = tenPercentBestCase;
    }

    /**
     * Gets ten percent worst case.
     *
     * @return the ten percent worst case
     */
    public double getTenPercentWorstCase() {
        return tenPercentWorstCase;
    }

    /**
     * Sets ten percent worst case.
     *
     * @param tenPercentWorstCase the ten percent worst case
     */
    public void setTenPercentWorstCase(double tenPercentWorstCase) {
        this.tenPercentWorstCase = tenPercentWorstCase;
    }

    /**
     * Gets inflation rate.
     *
     * @return the inflation rate
     */
    public double getInflationRate() {
        return inflationRate;
    }

    /**
     * Sets inflation rate.
     *
     * @param inflationRate the inflation rate
     */
    public void setInflationRate(double inflationRate) {
        this.inflationRate = inflationRate;
    }

    /**
     * Gets project.
     *
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets project.
     *
     * @param project the project
     */
    public void setProject(Project project) {
        this.project = project;
    }
}
