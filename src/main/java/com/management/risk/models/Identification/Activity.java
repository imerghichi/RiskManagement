package com.management.risk.models.Identification;


import java.util.Date;
import java.util.List;

public class Activity {
    private long id_task_project;
    private Date start_date;
    private Date end_date;
    private int mean_duration;
    private int min_duration;
    private int max_duration;
    private List<Risk> risks;
  //  private AbstractRealDistribution distribution;
    private List<Activity> predecesors;
    private List<Activity> succsesors;
}
