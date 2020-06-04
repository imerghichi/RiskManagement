package com.management.risk.Mitigation;

import java.util.List;

/**
 * The type Strategic plan.
 */
public class StrategicPlan extends Response {
    /**
     * The Active.
     */
    private boolean active;
    /**
     * The Complete.
     */
    private boolean complete;
    /**
     * The Mitigation name.
     */
    private String mitigation_name;
    /**
     * The Milstones.
     */
    private List<Milstone> milstones;

    /**
     * Instantiates a new Strategic plan.
     */
    public StrategicPlan() {
    }
}
