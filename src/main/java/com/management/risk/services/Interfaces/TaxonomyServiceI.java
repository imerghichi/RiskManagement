package com.management.risk.services.Interfaces;

import com.management.risk.Identification.FirstLevelTaxonomy;
import com.management.risk.Identification.Risk;
import com.management.risk.Identification.SEITaxonomy;

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

}
