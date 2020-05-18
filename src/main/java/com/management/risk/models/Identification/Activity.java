package com.management.risk.models.Identification;


import lombok.Data;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Activity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id_task_project;
    private int mean_duration;
    private int min_duration;
    private int max_duration;
    @ManyToOne
    private Project project;
    @OneToMany
    private List<Risk> risks;
  //  private AbstractRealDistribution distribution;
    @ManyToMany
    private List<Activity> predecesors;
    @ManyToMany
    private List<Activity> succsesors;

    public long getId_task_project() {
        return id_task_project;
    }

    public int getMean_duration() {
        return mean_duration;
    }

    public int getMin_duration() {
        return min_duration;
    }

    public int getMax_duration() {
        return max_duration;
    }

    public Project getProject() {
        return project;
    }

    public List<Risk> getRisks() {
        return risks;
    }

    public List<Activity> getPredecesors() {
        return predecesors;
    }

    public List<Activity> getSuccsesors() {
        return succsesors;
    }
}
