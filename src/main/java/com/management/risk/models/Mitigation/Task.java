package com.management.risk.models.Mitigation;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id_task;
    protected String task;
    protected boolean done;
    protected Date planned_start_date;
    protected Date actual_start_date;
    protected Date planned_completion_date;
    protected Date actual_completion_date;
    @ManyToOne
    protected Response response;
    protected int level;
    protected String condition;
    protected Date due_date;

    public Task() {
    }

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
