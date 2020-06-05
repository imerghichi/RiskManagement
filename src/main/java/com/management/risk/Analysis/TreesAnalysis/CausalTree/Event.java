package com.management.risk.Analysis.TreesAnalysis.CausalTree;


import com.management.risk.Identification.Risk;

import javax.persistence.*;
import java.util.List;

/**
 * The type Event.
 */
@Entity
public class Event {
    /**
     * The Id event.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_event;
    /**
     * The Name event.
     */
    @Column(nullable = false)
    private String name_event;
    /**
     * The Description event.
     */
    private String description_event;
    @OneToOne
    private Risk risk;

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    /**
     * The Causes.
     */
    @OneToMany
    private List<Event> causes;
  //  @ManyToOne
//    private Event consequence;

    /**
     * Instantiates a new Event.
     */
    public Event() {
    }

    /**
     * Gets id event.
     *
     * @return the id event
     */
    public long getId_event() {
        return id_event;
    }

    /**
     * Sets id event.
     *
     * @param id_event the id event
     */
    public void setId_event(long id_event) {
        this.id_event = id_event;
    }

    /**
     * Gets name event.
     *
     * @return the name event
     */
    public String getName_event() {
        return name_event;
    }

    /**
     * Sets name event.
     *
     * @param name_event the name event
     */
    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    /**
     * Gets description event.
     *
     * @return the description event
     */
    public String getDescription_event() {
        return description_event;
    }

    /**
     * Sets description event.
     *
     * @param description_event the description event
     */
    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    /**
     * Gets causes.
     *
     * @return the causes
     */
    public List<Event> getCauses() {
        return causes;
    }

    /**
     * Sets causes.
     *
     * @param causes the causes
     */
    public void setCauses(List<Event> causes) {
        this.causes = causes;
    }


}
