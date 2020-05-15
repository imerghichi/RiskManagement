package com.management.risk.models.Mitigation;

public class Trigger extends Task {
    private int level;
    private String condition;

    public Trigger(int level, String condition) {
        this.level =level;
        this.condition = condition;
    }


}
