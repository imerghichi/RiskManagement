package com.management.risk.models.Mitigation;

public class NonPlanResponse extends Response {
    private NonPlanResponseEnum nonPlanResponseEnum;

    public NonPlanResponse(NonPlanResponseEnum nonPlanResponseEnum) {
        this.nonPlanResponseEnum = nonPlanResponseEnum;
    }

    @Override
    public Response response() {
        return new NonPlanResponse(this.nonPlanResponseEnum);
    }
}
