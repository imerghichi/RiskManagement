package com.management.risk.Analysis.TreesAnalysis.FaultTree;

import com.management.risk.Identification.Risk;

import javax.persistence.*;

/**
 * The type Leaf event.
 */
@Entity
public class LeafEvent{
    /**
     * The Id leaf event.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_leafEvent;
    /**
     * The Event name.
     */
    private String event_name;
    /**
     * The Type.
     */
    @Enumerated(EnumType.STRING)
    private EventType type;
    /**
     * The Probability.
     */
    @Column(columnDefinition = "float default 0.0")
    private float probability;
    /**
     * The Operator.
     */
    @Enumerated(EnumType.STRING)
    private OperatorEnum operator;
    /**
     * The Right event.
     */
    @OneToOne
    private LeafEvent right_event;
    /**
     * The Left event.
     */
    @OneToOne
    private LeafEvent left_event;
    @OneToOne
    private Risk risk;

    public OperatorEnum getOperator() {
        return operator;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    /**
     * Gets id leaf event.
     *
     * @return the id leaf event
     */
    public long getId_leafEvent() {
        return id_leafEvent;
    }

    /**
     * Sets id leaf event.
     *
     * @param id_leafEvent the id leaf event
     */
    public void setId_leafEvent(long id_leafEvent) {
        this.id_leafEvent = id_leafEvent;
    }

    /**
     * Gets right event.
     *
     * @return the right event
     */
    public LeafEvent getRight_event() {
        return right_event;
    }

    /**
     * Sets right event.
     *
     * @param right_event the right event
     */
    public void setRight_event(LeafEvent right_event) {
        this.right_event = right_event;
    }

    /**
     * Gets left event.
     *
     * @return the left event
     */
    public LeafEvent getLeft_event() {
        return left_event;
    }

    /**
     * Sets left event.
     *
     * @param left_event the left event
     */
    public void setLeft_event(LeafEvent left_event) {
        this.left_event = left_event;
    }

    /**
     * Instantiates a new Leaf event.
     */
    public LeafEvent() {
    }

    /**
     * Instantiates a new Leaf event.
     *
     * @param event_name  the event name
     * @param type        the type
     * @param probability the probability
     */
    public LeafEvent(String event_name, EventType type, float probability) {
        this.event_name = event_name;
        this.type = type;
        this.probability = probability;
    }

    /**
     * Instantiates a new Leaf event.
     *
     * @param event_name  the event name
     * @param probability the probability
     */
    public LeafEvent(String event_name,float probability) {
        this.event_name = event_name;
        this.type = EventType.non_developped_event; //default type
        this.probability = probability;
    }

    /**
     * Gets operande.
     *
     * @return the operande
     */
    public OperatorEnum getOperande() {
        return operator;
    }

    /**
     * Sets operator.
     *
     * @param operande the operande
     */
    public void setOperator(OperatorEnum operande) {
        this.operator = operande;
    }

    /**
     * Gets probability.
     *
     * @return the probability
     */
    public float getProbability() {
        return probability;
    }

    /**
     * Sets probability.
     *
     * @param probability the probability
     */
    public void setProbability(float probability) {
        this.probability = probability;
    }

    /**
     * Gets event name.
     *
     * @return the event name
     */
    public String getEvent_name() {
        return event_name;
    }

    /**
     * Sets event name.
     *
     * @param event_name the event name
     */
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public EventType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(EventType type) {
        this.type = type;
    }

    /**
     * Is operator boolean.
     *
     * @return the boolean
     */
    public boolean isOperator(){
        return this.operator != null;
    }
}
