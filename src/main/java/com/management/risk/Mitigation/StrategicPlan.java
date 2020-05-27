package com.management.risk.Mitigation;

import java.util.List;

public class StrategicPlan extends Response {
    private boolean active;
    private boolean complete;
    private String mitigation_name;
    private List<Milstone> milstones;

    public StrategicPlan() {
    }
}
