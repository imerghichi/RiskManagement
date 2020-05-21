package com.management.risk.models.Identification;


import lombok.Data;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Entity
public class Activity {
    private static AtomicInteger count = new AtomicInteger(0);
    @Id
    private long id_task_project;
    private String description;
    //parametres de distribution
    private int parametre1;
    private int parametre2;
    private int parametre3;
    @Enumerated(EnumType.STRING)
    private DistributionEnum distribution;

    @ManyToOne
    private Project project;
    @OneToMany
    private List<Risk> risks;
    @ManyToMany
    private List<Activity> predecesors;

    public Activity() {
        id_task_project = count.incrementAndGet();
    }

    public void setId_task_project(long id_task_project) {
        this.id_task_project = id_task_project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParametre1() {
        return parametre1;
    }

    public void setParametre1(int parametre1) {
        this.parametre1 = parametre1;
    }

    public int getParametre2() {
        return parametre2;
    }

    public void setParametre2(int parametre2) {
        this.parametre2 = parametre2;
    }

    public int getParametre3() {
        return parametre3;
    }

    public void setParametre3(int parametre3) {
        this.parametre3 = parametre3;
    }

    public DistributionEnum getDistribution() {
        return distribution;
    }

    public void setDistribution(DistributionEnum distribution) {
        this.distribution = distribution;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Risk> getRisks() {
        return risks;
    }

    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }

    public List<Activity> getPredecesors() {
        return predecesors;
    }

    public void setPredecesors(List<Activity> predecesors) {
        this.predecesors = predecesors;
    }

    public long getId_task_project() {
        return id_task_project;
    }
}
