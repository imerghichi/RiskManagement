package com.management.risk.models.Analysis.TreesAnalysis.FaultTree;

public class LeafEvent{
    private String event_name;
    private EventType type;
    private float probability;
    private OperandeEnum operande;


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

    public OperandeEnum getOperande() {
        return operande;
    }

    public void setOperande(OperandeEnum operande) {
        this.operande = operande;
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

    public boolean isOperande(){
        return this.operande != null;
    }
}
