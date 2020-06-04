package com.management.risk.Analysis.Taxonomy;

import com.management.risk.Identification.*;

import java.util.List;

/**
 * The type Taxonomy.
 */
public class Taxonomy {

    /**
     * The Risks.
     */
    List<Risk> risks;
    /**
     * The Sei taxonomy.
     */
    SEITaxonomy seiTaxonomy;
    /**
     * The First level taxonomy.
     */
    FirstLevelTaxonomy firstLevelTaxonomy;

    /**
     * Instantiates a new Taxonomy.
     *
     * @param risks       the risks
     * @param seiTaxonomy the sei taxonomy
     */
    public Taxonomy(List<Risk> risks, SEITaxonomy seiTaxonomy) {
        this.risks = risks;
        this.firstLevelTaxonomy = seiTaxonomy.getFirst_level_taxonomy();
        this.seiTaxonomy = seiTaxonomy;
    }

    /**
     * Instantiates a new Taxonomy.
     *
     * @param risks              the risks
     * @param firstLevelTaxonomy the first level taxonomy
     */
    public Taxonomy(List<Risk> risks, FirstLevelTaxonomy firstLevelTaxonomy) {
        this.risks = risks;
        this.firstLevelTaxonomy = firstLevelTaxonomy;
        this.seiTaxonomy = null;
    }

    /**
     * Frequency double.
     *
     * @return the double
     */
    public double frequency() {
        int sum = 0;
        if (this.seiTaxonomy == null) {
            for (Risk risk :
                    risks) {
                if ((risk.getTaxonomy().getFirst_level_taxonomy() != null)) {
                    if(risk.getTaxonomy().getFirst_level_taxonomy().toString().equals(firstLevelTaxonomy.toString()))
                    sum++;
                }
            }
            return (double) sum / (double) risks.size();
        } else {
            for (Risk risk :
                    risks) {
                if ((risk.getTaxonomy() != null)) {
                    if(risk.getTaxonomy().toString().equals(seiTaxonomy.toString()))
                    sum++;
                }
            }
            return (double) sum / (double) risks.size();
        }
    }
}



