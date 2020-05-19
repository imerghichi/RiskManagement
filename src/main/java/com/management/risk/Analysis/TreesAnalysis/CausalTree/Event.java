package com.management.risk.Analysis.TreesAnalysis.CausalTree;


import javax.persistence.*;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_event;
    private String name_event;
    private String description_event;
    @OneToMany
    private List<Event> causes;

    public Event() {
    }

    public long getId_event() {
        return id_event;
    }

    public void setId_event(long id_event) {
        this.id_event = id_event;
    }

    public String getName_event() {
        return name_event;
    }

    public void setName_event(String name_event) {
        this.name_event = name_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public List<Event> getCauses() {
        return causes;
    }

    public void setCauses(List<Event> causes) {
        this.causes = causes;
    }
}
