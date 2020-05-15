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
    private Date start_date;
    private Date end_date;
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

}
