package com.management.risk.Analysis.TreesAnalysis.FaultTree;

import javax.persistence.*;

@Entity
public class LeafEvent{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_leafEvent;
    private String event_name;
    @Enumerated(EnumType.STRING)
    private EventType type;
    @Column(columnDefinition = "float default 0.0")
    private float probability;
    @Enumerated(EnumType.STRING)
    private OperatorEnum operator;
    @OneToOne
    private LeafEvent right_event;
    @OneToOne
    private LeafEvent left_event;


    public long getId_leafEvent() {
        return id_leafEvent;
    }

    public void setId_leafEvent(long id_leafEvent) {
        this.id_leafEvent = id_leafEvent;
    }

    public LeafEvent getRight_event() {
        return right_event;
    }

    public void setRight_event(LeafEvent right_event) {
        this.right_event = right_event;
    }

    public LeafEvent getLeft_event() {
        return left_event;
    }

    public void setLeft_event(LeafEvent left_event) {
        this.left_event = left_event;
    }

    public LeafEvent() {
    }

    public LeafEvent(String event_name, EventType type, float probability) {
        this.event_name = event_name;
        this.type = type;
        this.probability = probability;
    }

    public LeafEvent(String event_name,float probability) {
        this.event_name = event_name;
        this.type = EventType.non_developped_event; //default type
        this.probability = probability;
    }

    public OperatorEnum getOperande() {
        return operator;
    }

    public void setOperator(OperatorEnum operande) {
        this.operator = operande;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean isOperator(){
        return this.operator != null;
    }
}
