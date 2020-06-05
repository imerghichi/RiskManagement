package com.management.risk.Identification;

import com.management.risk.Analysis.TreesAnalysis.CausalTree.Event;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Mitigation.Response;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Risk.
 */
@Data
@Entity
public class Risk {
    /**
     * The Id risk.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_risk;
    /**
     * The Risk name.
     */
    @Column(nullable = false, updatable = false)
    private String risk_name;
    /**
     * The Description.
     */
    private String description;
    /**
     * The Identifier risk.
     */
    @ManyToOne
    private TeamMember identifier_risk;
    /**
     * The Task project.
     */
    @ManyToOne
    private Activity taskProject;
    /**
     * The Probability.
     */
    @Column(columnDefinition = "float default 0.0")
    private float probability;
    /**
     * The Detection difficulty.
     */
    @Column(columnDefinition = "float default 0.0")
    private float detection_difficulty;
    /**
     * The Vulnerability.
     */
    @Column(columnDefinition = "float default 0.0")
    private float vulnerability; //when detected
    /**
     * The Impact.
     */
    @Enumerated(EnumType.STRING)
    private Impact impact;
    /**
     * The Active.
     */
    private boolean active; // vs latent
    /**
     * The Consquence description.
     */
    private String consquence_description;
    /**
     * The Date risk.
     */
    @CreationTimestamp
    private Date date_risk;
    /**
     * The Nature risk.
     */
    @Enumerated(EnumType.STRING)
    private Nature nature_risk;
    /**
     * The Origin risk.
     */
    @Enumerated(EnumType.STRING)
    private Origin origin_risk;
    /**
     * The Type risk.
     */
    @Enumerated(EnumType.STRING)
    private Type type_risk;
    /**
     * The Category.
     */
    @Enumerated(EnumType.STRING)
    private CategoriesEnum category;
    /**
     * The Owner level.
     */
    @Enumerated(EnumType.STRING)
    private OwnerLevel ownerLevel;
    /**
     * The Visibility.
     */
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    /**
     * The Detected.
     */
    private boolean detected;
    /**
     * The Taxonomy.
     */
    @Enumerated
    private SEITaxonomy taxonomy;
    /**
     * The Response.
     */
    @OneToOne
    private Response response;
    /**
     * The Leaf event.
     */
    @OneToOne
    private LeafEvent leafEvent;
    /**
     * The Project.
     */
    @ManyToOne
    private Project project;
    @OneToOne
    private Event event;

    /**
     * Instantiates a new Risk.
     *
     * @param taskProject the task project
     */
    public Risk(Activity taskProject) {
        this.taskProject = taskProject;
    }

    /**
     * Instantiates a new Risk.
     */
    public Risk() {
    }

    /**
     * Impact int.
     *
     * @return the int
     */
    public int impact(){
        return this.impact.getValue();
    }

    /**
     * Exposure float.
     *
     * @return the float
     */
    public float exposure(){
        if(isDetected()) return 1;
        return this.probability * impact();

    }

    /**
     * Gets vulnerability.
     *
     * @return the vulnerability
     */
    public float getVulnerability() {
        return vulnerability;
    }


    /**
     * Sets vulnerability.
     *
     * @param vulnerability the vulnerability
     */
    public void setVulnerability(float vulnerability) {
        this.vulnerability = vulnerability;
    }
    //fmea

    /**
     * Risk priority number float.
     *
     * @return the float
     */
    public float risk_priority_number(){
        if(! isDetected()){
        return exposure() * detection_difficulty;
        }
        return this.vulnerability * this.impact.getValue();
    }


    /**
     * Gets detection difficulty.
     *
     * @return the detection difficulty
     */
    public float getDetection_difficulty() {
        return detection_difficulty;
    }

    /**
     * Sets detection difficulty.
     *
     * @param detection_difficulty the detection difficulty
     */
    public void setDetection_difficulty(float detection_difficulty) {
        this.detection_difficulty = detection_difficulty;
    }

    /**
     * Is detected boolean.
     *
     * @return the boolean
     */
    public boolean isDetected() {
        return detected;
    }

    /**
     * Sets detected.
     *
     * @param detected the detected
     */
    public void setDetected(boolean detected) {
        this.detected = detected;
    }

    /**
     * Gets id risk.
     *
     * @return the id risk
     */
    public long getId_risk() {
        return id_risk;
    }

    /**
     * Sets id risk.
     *
     * @param id_risk the id risk
     */
    public void setId_risk(long id_risk) {
        this.id_risk = id_risk;
    }

    /**
     * Gets risk name.
     *
     * @return the risk name
     */
    public String getRisk_name() {
        return risk_name;
    }

    /**
     * Sets risk name.
     *
     * @param risk_name the risk name
     */
    public void setRisk_name(String risk_name) {
        this.risk_name = risk_name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets identifier risk.
     *
     * @return the identifier risk
     */
    public TeamMember getIdentifier_risk() {
        return identifier_risk;
    }

    /**
     * Sets identifier risk.
     *
     * @param idetifier_risk the idetifier risk
     */
    public void setIdentifier_risk(TeamMember idetifier_risk) {
        this.identifier_risk = idetifier_risk;
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
     * @param probabilty the probabilty
     */
    public void setProbability(float probabilty) {
        this.probability = probabilty;
    }

    /**
     * Gets impact.
     *
     * @return the impact
     */
    public Impact getImpact() {
        return impact;
    }

    /**
     * Sets impact.
     *
     * @param impact the impact
     */
    public void setImpact(Impact impact) {
        this.impact = impact;
    }

    /**
     * Gets consquence description.
     *
     * @return the consquence description
     */
    public String getConsquence_description() {
        return consquence_description;
    }

    /**
     * Sets consquence description.
     *
     * @param consquence_description the consquence description
     */
    public void setConsquence_description(String consquence_description) {
        this.consquence_description = consquence_description;
    }

    /**
     * Gets date risk.
     *
     * @return the date risk
     */
    public Date getDate_risk() {
        return date_risk;
    }

    /**
     * Sets date risk.
     *
     * @param date_risk the date risk
     */
    public void setDate_risk(Date date_risk) {
        this.date_risk = date_risk;
    }

    /**
     * Gets nature risk.
     *
     * @return the nature risk
     */
    public Nature getNature_risk() {
        return nature_risk;
    }

    /**
     * Sets nature risk.
     *
     * @param nature_risk the nature risk
     */
    public void setNature_risk(Nature nature_risk) {
        this.nature_risk = nature_risk;
    }

    /**
     * Gets origin risk.
     *
     * @return the origin risk
     */
    public Origin getOrigin_risk() {
        return origin_risk;
    }

    /**
     * Sets origin risk.
     *
     * @param origin_risk the origin risk
     */
    public void setOrigin_risk(Origin origin_risk) {
        this.origin_risk = origin_risk;
    }

    /**
     * Gets type risk.
     *
     * @return the type risk
     */
    public Type getType_risk() {
        return type_risk;
    }

    /**
     * Sets type risk.
     *
     * @param type_risk the type risk
     */
    public void setType_risk(Type type_risk) {
        this.type_risk = type_risk;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public CategoriesEnum getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(CategoriesEnum category) {
        this.category = category;
    }

    /**
     * Gets owner level.
     *
     * @return the owner level
     */
    public OwnerLevel getOwnerLevel() {
        return ownerLevel;
    }

    /**
     * Sets owner level.
     *
     * @param ownerLevel the owner level
     */
    public void setOwnerLevel(OwnerLevel ownerLevel) {
        this.ownerLevel = ownerLevel;
    }

    /**
     * Gets visibility.
     *
     * @return the visibility
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * Sets visibility.
     *
     * @param visibility the visibility
     */
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets response.
     *
     * @return the response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets response.
     *
     * @param response the response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * Gets task project.
     *
     * @return the task project
     */
    public Activity getTaskProject() {
        return taskProject;
    }

    /**
     * Sets task project.
     *
     * @param taskProject the task project
     */
    public void setTaskProject(Activity taskProject) {
        this.taskProject = taskProject;
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets taxonomy.
     *
     * @return the taxonomy
     */
    public SEITaxonomy getTaxonomy() {
        return taxonomy;
    }

    /**
     * Sets taxonomy.
     *
     * @param taxonomy the taxonomy
     */
    public void setTaxonomy(SEITaxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    /**
     * Gets leaf event.
     *
     * @return the leaf event
     */
    public LeafEvent getLeafEvent() {
        return leafEvent;
    }

    /**
     * Sets leaf event.
     *
     * @param leafEvent the leaf event
     */
    public void setLeafEvent(LeafEvent leafEvent) {
        this.leafEvent = leafEvent;
    }

    /**
     * Is external boolean.
     *
     * @return the boolean
     */
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
