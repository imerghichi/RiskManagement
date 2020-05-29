package com.management.risk.Identification;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Mitigation.Response;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_risk;
    @Column(nullable = false, updatable = false)
    private String risk_name;
    private String description;
    @ManyToOne
    private TeamMember idetifier_risk;
    @ManyToOne
    private Activity taskProject;
    @Column(columnDefinition = "float default 0.0")
    private float probabilty;
    @Column(columnDefinition = "float default 0.0")
    private float detection_difficulty;
    @Column(columnDefinition = "float default 0.0")
    private float vulnerability; //when detected
    @Enumerated(EnumType.STRING)
    private Impact impact;
    private boolean active; // vs latent
    private String consquence_description;
    @CreationTimestamp
    private Date date_risk;
    @Enumerated(EnumType.STRING)
    private Nature nature_risk;
    @Enumerated(EnumType.STRING)
    private Origin origin_risk;
    @Enumerated(EnumType.STRING)
    private Type type_risk;
    @Enumerated(EnumType.STRING)
    private CategoriesEnum category;
    @Enumerated(EnumType.STRING)
    private OwnerLevel ownerLevel;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    private boolean detected;
    @Enumerated
    private SEITaxonomy taxonomy;
    @OneToOne
    private Response response;
    @OneToOne
    private LeafEvent leafEvent;
    @ManyToOne
    private Project project;

    public Risk(Activity taskProject) {
        this.taskProject = taskProject;
    }

    public Risk() {
    }

    public int impact(){
        return this.impact.getValue();
    }

    public float exposure(){
        if(isDetected()) return 1;
        return this.probabilty * impact();

    }

    public float getVulnerability() {
        return vulnerability;
    }


    public void setVulnerability(float vulnerability) {
        this.vulnerability = vulnerability;
    }
    //fmea

    public float risk_priority_number(){
        if(! isDetected()){
        return exposure() * detection_difficulty;
        }
        return this.vulnerability * this.impact.getValue();
    }



    public float getDetection_difficulty() {
        return detection_difficulty;
    }

    public void setDetection_difficulty(float detection_difficulty) {
        this.detection_difficulty = detection_difficulty;
    }

    public boolean isDetected() {
        return detected;
    }

    public void setDetected(boolean detected) {
        this.detected = detected;
    }

    public long getId_risk() {
        return id_risk;
    }

    public void setId_risk(long id_risk) {
        this.id_risk = id_risk;
    }

    public String getRisk_name() {
        return risk_name;
    }

    public void setRisk_name(String risk_name) {
        this.risk_name = risk_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TeamMember getIdetifier_risk() {
        return idetifier_risk;
    }

    public void setIdetifier_risk(TeamMember idetifier_risk) {
        this.idetifier_risk = idetifier_risk;
    }

    public float getProbabilty() {
        return probabilty;
    }

    public void setProbabilty(float probabilty) {
        this.probabilty = probabilty;
    }

    public Impact getImpact() {
        return impact;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
    }

    public String getConsquence_description() {
        return consquence_description;
    }

    public void setConsquence_description(String consquence_description) {
        this.consquence_description = consquence_description;
    }

    public Date getDate_risk() {
        return date_risk;
    }

    public void setDate_risk(Date date_risk) {
        this.date_risk = date_risk;
    }

    public Nature getNature_risk() {
        return nature_risk;
    }

    public void setNature_risk(Nature nature_risk) {
        this.nature_risk = nature_risk;
    }

    public Origin getOrigin_risk() {
        return origin_risk;
    }

    public void setOrigin_risk(Origin origin_risk) {
        this.origin_risk = origin_risk;
    }

    public Type getType_risk() {
        return type_risk;
    }

    public void setType_risk(Type type_risk) {
        this.type_risk = type_risk;
    }

    public CategoriesEnum getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }

    public OwnerLevel getOwnerLevel() {
        return ownerLevel;
    }

    public void setOwnerLevel(OwnerLevel ownerLevel) {
        this.ownerLevel = ownerLevel;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Activity getTaskProject() {
        return taskProject;
    }

    public void setTaskProject(Activity taskProject) {
        this.taskProject = taskProject;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SEITaxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(SEITaxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public LeafEvent getLeafEvent() {
        return leafEvent;
    }

    public void setLeafEvent(LeafEvent leafEvent) {
        this.leafEvent = leafEvent;
    }

    public boolean isExternal(){
        switch (this.origin_risk){
            case external:
                return true;
            case vendor:
                return true;
            case internal:
                return false;
        }
        return false;
    }

}
