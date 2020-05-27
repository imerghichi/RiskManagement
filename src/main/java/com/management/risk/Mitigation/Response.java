package com.management.risk.Mitigation;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public  class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id_response;
    protected boolean active;
    protected boolean complete;
    protected String response_name;
    @OneToMany
    protected List<Task> tasks;
    @Enumerated(EnumType.STRING)
    protected NonPlanResponseEnum nonPlanResponseEnum;
    public Response() {
    }

    public Response(boolean active, boolean complete, String response_name, List<Task> tasks, NonPlanResponseEnum nonPlanResponseEnum) {

    }
}