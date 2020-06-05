package com.management.risk.services.Interfaces;

import com.management.risk.Identification.*;

import java.util.List;

/**
 * The interface Taxonomy service i.
 */
public interface TaxonomyServiceI {
    /**
     * Frequency double.
     *
     * @param seiTaxonomy the sei taxonomy
     * @param risks       the risks
     * @return the double
     */
    double frequency (SEITaxonomy seiTaxonomy, List<Risk> risks);

    /**
     * Frequency double.
     *
     * @param firstLevelTaxonomy the first level taxonomy
     * @param risks              the risks
     * @return the double
     */
    double frequency (FirstLevelTaxonomy firstLevelTaxonomy, List<Risk> risks);

    List<Double> frequeciesFirstLevel(List<Risk> risks);
    List<Double> frequenciesSei(List<Risk> risks);


    double frequency (SEITaxonomy seiTaxonomy, Activity activity);

    double frequency (FirstLevelTaxonomy firstLevelTaxonomy, Activity activity);

    List<Double> frequeciesFirstLevel(Activity activity);
    List<Double> frequenciesSei(Activity activity);


    double frequency (SEITaxonomy seiTaxonomy, Project project);

    double frequency (FirstLevelTaxonomy firstLevelTaxonomy, Project project);

    List<Double> frequeciesFirstLevel(Project project);
    List<Double> frequenciesSei(Project project);
}
