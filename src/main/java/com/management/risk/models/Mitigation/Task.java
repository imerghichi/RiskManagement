package com.management.risk.models.Mitigation;

import java.util.Date;

public class Task {
    private long id_task;
    private String task;
    private boolean done;
    private Date planned_start_date;
    private Date actual_start_date;
    private Date planned_completion_date;
    private Date actual_completion_date;

    public Task(String task) {
        this.task = task;
    }

    public long getId_task() {
        return id_task;
    }

    public void setId_task(long id_task) {
        this.id_task = id_task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(Date planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public Date getActual_start_date() {
        return actual_start_date;
    }

    public void setActual_start_date(Date actual_start_date) {
        this.actual_start_date = actual_start_date;
    }

    public Date getPlanned_completion_date() {
        return planned_completion_date;
    }

    public void setPlanned_completion_date(Date planned_completion_date) {
        this.planned_completion_date = planned_completion_date;
    }

    public Date getActual_completion_date() {
        return actual_completion_date;
    }

    public void setActual_completion_date(Date actual_completion_date) {
        this.actual_completion_date = actual_completion_date;
    }
}
