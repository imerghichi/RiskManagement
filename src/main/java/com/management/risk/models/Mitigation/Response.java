package com.management.risk.models.Mitigation;


import com.management.risk.models.Identification.Risk;

public abstract class Response {
    private long id_response;
    private Risk risk;
    public abstract Response response ();

    public long getId_response() {
        return id_response;
    }

    public void setId_response(long id_response) {
        this.id_response = id_response;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }
}
