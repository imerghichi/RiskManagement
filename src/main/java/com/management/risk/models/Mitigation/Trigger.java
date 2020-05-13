package com.management.risk.models.Mitigation;

public class Trigger extends Task {
    private int level;
    private String condition;
    public Trigger(String task) {
        super(task);
    }

    public Trigger(String task, String condition) {
        super(task);
        this.condition = condition;
    }

}
