package com.management.risk.models.Mitigation;

import java.util.List;

public class ContingencyPlan extends Response{
    private String contingency_name;
    private List<Trigger> triggers;

    public ContingencyPlan(String contingency_name) {
        this.contingency_name = contingency_name;
    }

    @Override
    public Response response() {
        return new ContingencyPlan(this.contingency_name);
    }
}
