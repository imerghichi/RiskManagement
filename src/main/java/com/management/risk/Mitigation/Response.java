package com.management.risk.Mitigation;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public  class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id_response;
    protected boolean active;
    protected boolean complete;
    protected String response_name;
    @OneToMany
    protected List<Task> tasks;
    @Enumerated(EnumType.STRING)
    protected NonPlanResponseEnum nonPlanResponseEnum;
    public Response() {
    }

    public Response(boolean active, boolean complete, String response_name, List<Task> tasks, NonPlanResponseEnum nonPlanResponseEnum) {

    }

    public long getId_response() {
        return id_response;
    }

    public void setId_response(long id_response) {
        this.id_response = id_response;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getResponse_name() {
        return response_name;
    }

    public void setResponse_name(String response_name) {
        this.response_name = response_name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public NonPlanResponseEnum getNonPlanResponseEnum() {
        return nonPlanResponseEnum;
    }

    public void setNonPlanResponseEnum(NonPlanResponseEnum nonPlanResponseEnum) {
        this.nonPlanResponseEnum = nonPlanResponseEnum;
    }
}