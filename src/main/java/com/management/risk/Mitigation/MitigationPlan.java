package com.management.risk.Mitigation;


import java.util.List;

/**
 * The type Mitigation plan.
 */
public class MitigationPlan extends Response {
    /**
     * The Active.
     */
    private boolean active;
    /**
     * The Complete.
     */
    private boolean complete;
    /**
     * The Response name.
     */
    private String response_name;
    /**
     * The Tasks.
     */
    private List<Task> tasks;

    /**
     * Instantiates a new Mitigation plan.
     */
    public MitigationPlan() {
    }

}
