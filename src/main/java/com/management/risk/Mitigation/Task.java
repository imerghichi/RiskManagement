package com.management.risk.Mitigation;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Task.
 */
@Data
@Entity
public class Task {
    /**
     * The Id task.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id_task;
    /**
     * The Task.
     */
    protected String task;
    /**
     * The Done.
     */
    protected boolean done;
    /**
     * The Planned start date.
     */
    protected Date planned_start_date;
    /**
     * The Actual start date.
     */
    protected Date actual_start_date;
    /**
     * The Planned completion date.
     */
    protected Date planned_completion_date;
    /**
     * The Actual completion date.
     */
    protected Date actual_completion_date;
    /**
     * The Response.
     */
    @ManyToOne
    protected Response response;
    /**
     * The Level.
     */
    protected int level;
    /**
     * The Condition.
     */
    protected String condition;
    /**
     * The Due date.
     */
    protected Date due_date;

    /**
     * Instantiates a new Task.
     */
    public Task() {
    }

    /**
     * Instantiates a new Task.
     *
     * @param task the task
     */
    public Task(String task) {
        this.task = task;
    }

    /**
     * Gets id task.
     *
     * @return the id task
     */
    public long getId_task() {
        return id_task;
    }

    /**
     * Sets id task.
     *
     * @param id_task the id task
     */
    public void setId_task(long id_task) {
        this.id_task = id_task;
    }

    /**
     * Gets task.
     *
     * @return the task
     */
    public String getTask() {
        return task;
    }

    /**
     * Sets task.
     *
     * @param task the task
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Is done boolean.
     *
     * @return the boolean
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets done.
     *
     * @param done the done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Gets planned start date.
     *
     * @return the planned start date
     */
    public Date getPlanned_start_date() {
        return planned_start_date;
    }

    /**
     * Sets planned start date.
     *
     * @param planned_start_date the planned start date
     */
    public void setPlanned_start_date(Date planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    /**
     * Gets actual start date.
     *
     * @return the actual start date
     */
    public Date getActual_start_date() {
        return actual_start_date;
    }

    /**
     * Sets actual start date.
     *
     * @param actual_start_date the actual start date
     */
    public void setActual_start_date(Date actual_start_date) {
        this.actual_start_date = actual_start_date;
    }

    /**
     * Gets planned completion date.
     *
     * @return the planned completion date
     */
    public Date getPlanned_completion_date() {
        return planned_completion_date;
    }

    /**
     * Sets planned completion date.
     *
     * @param planned_completion_date the planned completion date
     */
    public void setPlanned_completion_date(Date planned_completion_date) {
        this.planned_completion_date = planned_completion_date;
    }

    /**
     * Gets actual completion date.
     *
     * @return the actual completion date
     */
    public Date getActual_completion_date() {
        return actual_completion_date;
    }

    /**
     * Sets actual completion date.
     *
     * @param actual_completion_date the actual completion date
     */
    public void setActual_completion_date(Date actual_completion_date) {
        this.actual_completion_date = actual_completion_date;
    }
}
