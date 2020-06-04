package com.management.risk.Mitigation;

/**
 * The type Trigger.
 */
public class Trigger extends Task {
    /**
     * The Level.
     */
    private int level;
    /**
     * The Condition.
     */
    private String condition;

    /**
     * Instantiates a new Trigger.
     *
     * @param level     the level
     * @param condition the condition
     */
    public Trigger(int level, String condition) {
        this.level =level;
        this.condition = condition;
    }


}
