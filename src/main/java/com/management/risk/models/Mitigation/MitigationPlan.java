package com.management.risk.models.Mitigation;


import java.util.List;

public class MitigationPlan extends Response {
    private boolean active;
    private boolean complete;
    private String mitigation_name;
    private List<Task> tasks;

    public MitigationPlan() {
    }


    @Override
    public Response response() {
        return new MitigationPlan();
    }
}
