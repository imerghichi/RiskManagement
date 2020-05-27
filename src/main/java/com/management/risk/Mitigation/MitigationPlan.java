package com.management.risk.Mitigation;


import java.util.List;

public class MitigationPlan extends Response {
    private boolean active;
    private boolean complete;
    private String response_name;
    private List<Task> tasks;

    public MitigationPlan() {
    }

}
