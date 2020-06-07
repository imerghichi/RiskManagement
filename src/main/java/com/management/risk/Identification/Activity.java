package com.management.risk.Identification;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Activity.
 */
@Data
@Entity
public class Activity {
    /**
     * The constant count.
     */
    private static AtomicInteger count = new AtomicInteger(0);
    /**
     * The Id task project.
     */
    @Id
    private long id_task_project;
    /**
     * The Task name.
     */
    @Column(nullable = false, unique = true)
    private String task_name;
    /**
     * The Description.
     */
    private String description;
    /**
     * The Parametre 1.
     */
//parametres de distribution
    @Column(columnDefinition = "double default 0")
    private int parametre1;
    /**
     * The Parametre 2.
     */
    @Column(columnDefinition = "double default 0")
    private int parametre2;
    /**
     * The Parametre 3.
     */
    @Column(columnDefinition = "double default 0")
    private int parametre3;
    /**
     * The Distribution.
     */
    @Enumerated(EnumType.STRING)
    private DistributionEnum distribution;

    /**
     * The Project.
     */
    @ManyToOne
    private Project project;
    /**
     * The Risks.
     */
    @OneToMany(fetch = FetchType.EAGER)
    private List<Risk> risks;
    /**
     * The Predecesors.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Activity> predecesors;

    /**
     * Instantiates a new Activity.
     */
    public Activity() {
        id_task_project = count.incrementAndGet();
    }

    /**
     * Sets id task project.
     *
     * @param id_task_project the id task project
     */
    public void setId_task_project(long id_task_project) {
        this.id_task_project = id_task_project;
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
     * Gets parametre 1.
     *
     * @return the parametre 1
     */
    public int getParametre1() {
        return parametre1;
    }

    /**
     * Sets parametre 1.
     *
     * @param parametre1 the parametre 1
     */
    public void setParametre1(int parametre1) {
        this.parametre1 = parametre1;
    }

    /**
     * Gets parametre 2.
     *
     * @return the parametre 2
     */
    public int getParametre2() {
        return parametre2;
    }

    /**
     * Sets parametre 2.
     *
     * @param parametre2 the parametre 2
     */
    public void setParametre2(int parametre2) {
        this.parametre2 = parametre2;
    }

    /**
     * Gets parametre 3.
     *
     * @return the parametre 3
     */
    public int getParametre3() {
        return parametre3;
    }

    /**
     * Sets parametre 3.
     *
     * @param parametre3 the parametre 3
     */
    public void setParametre3(int parametre3) {
        this.parametre3 = parametre3;
    }

    /**
     * Gets distribution.
     *
     * @return the distribution
     */
    public DistributionEnum getDistribution() {
        return distribution;
    }

    /**
     * Sets distribution.
     *
     * @param distribution the distribution
     */
    public void setDistribution(DistributionEnum distribution) {
        this.distribution = distribution;
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

    /**
     * Gets risks.
     *
     * @return the risks
     */
    public List<Risk> getRisks() {
        return risks;
    }

    /**
     * Sets risks.
     *
     * @param risks the risks
     */
    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }

    /**
     * Gets predecesors.
     *
     * @return the predecesors
     */
    public List<Activity> getPredecesors() {
        return predecesors;
    }

    /**
     * Sets predecesors.
     *
     * @param predecesors the predecesors
     */
    public void setPredecesors(List<Activity> predecesors) {
        this.predecesors = predecesors;
    }

    /**
     * Gets id task project.
     *
     * @return the id task project
     */
    public long getId_task_project() {
        return id_task_project;
    }
}
