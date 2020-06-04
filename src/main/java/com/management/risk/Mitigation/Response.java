package com.management.risk.Mitigation;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * The type Response.
 */
@Data
@Entity
public  class Response {
    /**
     * The Id response.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id_response;
    /**
     * The Active.
     */
    protected boolean active;
    /**
     * The Complete.
     */
    protected boolean complete;
    /**
     * The Response name.
     */
    protected String response_name;
    /**
     * The Tasks.
     */
    @OneToMany
    protected List<Task> tasks;
    /**
     * The Non plan response enum.
     */
    @Enumerated(EnumType.STRING)
    protected NonPlanResponseEnum nonPlanResponseEnum;

    /**
     * Instantiates a new Response.
     */
    public Response() {
    }

    /**
     * Instantiates a new Response.
     *
     * @param active              the active
     * @param complete            the complete
     * @param response_name       the response name
     * @param tasks               the tasks
     * @param nonPlanResponseEnum the non plan response enum
     */
    public Response(boolean active, boolean complete, String response_name, List<Task> tasks, NonPlanResponseEnum nonPlanResponseEnum) {

    }

    /**
     * Gets id response.
     *
     * @return the id response
     */
    public long getId_response() {
        return id_response;
    }

    /**
     * Sets id response.
     *
     * @param id_response the id response
     */
    public void setId_response(long id_response) {
        this.id_response = id_response;
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Is complete boolean.
     *
     * @return the boolean
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     * Sets complete.
     *
     * @param complete the complete
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * Gets response name.
     *
     * @return the response name
     */
    public String getResponse_name() {
        return response_name;
    }

    /**
     * Sets response name.
     *
     * @param response_name the response name
     */
    public void setResponse_name(String response_name) {
        this.response_name = response_name;
    }

    /**
     * Gets tasks.
     *
     * @return the tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets tasks.
     *
     * @param tasks the tasks
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets non plan response enum.
     *
     * @return the non plan response enum
     */
    public NonPlanResponseEnum getNonPlanResponseEnum() {
        return nonPlanResponseEnum;
    }

    /**
     * Sets non plan response enum.
     *
     * @param nonPlanResponseEnum the non plan response enum
     */
    public void setNonPlanResponseEnum(NonPlanResponseEnum nonPlanResponseEnum) {
        this.nonPlanResponseEnum = nonPlanResponseEnum;
    }
}