package com.management.risk.Mitigation;

import java.util.List;

public class ContingencyPlan extends Response{
    private String contingency_name;
    private List<Trigger> triggers;

    public ContingencyPlan(String contingency_name) {
        this.contingency_name = contingency_name;
    }

    public ContingencyPlan() {
    }

    public ContingencyPlan(String contingency_name, List<Trigger> triggers) {
        this.contingency_name = contingency_name;
        this.triggers = triggers;
    }
}
