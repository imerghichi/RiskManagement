package com.management.risk.models.Identification;

import com.management.risk.models.Mitigation.Response;

import java.util.Date;

public class Risk {

    private long id_risk;
    private String risk_name;
    private String description;
    private TeamMember idetifier_risk;
    private Activity taskProject;
    private float probabilty;
    private float detection_difficulty;
    private float vulnerability; //when detected
    private Impact impact;
    private boolean active; // vs latent
    private String consquence_description;
    private Date date_risk;
    private Nature nature_risk;
    private Origin origin_risk;
    private Type type_risk;
    private Category category;
    private OwnerLevel ownerLevel;
    private Visibility visibility;
    private boolean detected;
    private Response response;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

}
