package com.management.risk.Mitigation;

import java.util.List;

/**
 * The type Contingency plan.
 */
public class ContingencyPlan extends Response{
    /**
     * The Contingency name.
     */
    private String contingency_name;
    /**
     * The Triggers.
     */
    private List<Trigger> triggers;

    /**
     * Instantiates a new Contingency plan.
     *
     * @param contingency_name the contingency name
     */
    public ContingencyPlan(String contingency_name) {
        this.contingency_name = contingency_name;
    }

    /**
     * Instantiates a new Contingency plan.
     */
    public ContingencyPlan() {
    }

    /**
     * Instantiates a new Contingency plan.
     *
     * @param contingency_name the contingency name
     * @param triggers         the triggers
     */
    public ContingencyPlan(String contingency_name, List<Trigger> triggers) {
        this.contingency_name = contingency_name;
        this.triggers = triggers;
    }
}
