package com.management.risk.Analysis.Taxonomy;

import com.management.risk.models.Identification.*;

import java.util.Collections;
import java.util.List;

public class Taxonomy {

    List<Risk> risks;
    SEITaxonomy seiTaxonomy;
    FirstLevelTaxonomy firstLevelTaxonomy;

    public Taxonomy(List<Risk> risks, SEITaxonomy seiTaxonomy) {
        this.risks = risks;
        this.firstLevelTaxonomy = seiTaxonomy.getFirst_level_taxonomy();
        this.seiTaxonomy = seiTaxonomy;
    }

    public Taxonomy(List<Risk> risks, FirstLevelTaxonomy firstLevelTaxonomy) {
        this.risks = risks;
        this.firstLevelTaxonomy = firstLevelTaxonomy;
        this.seiTaxonomy = null;
    }

    public double frequency() {
        int sum = 0;
        if (this.seiTaxonomy == null) {
            for (Risk risk :
                    risks) {
                if (risk.getTaxonomy().getFirst_level_taxonomy().toString().equals(firstLevelTaxonomy.toString()))
                    sum++;
            }
            return sum / risks.size();
        } else {
            for (Risk risk :
                    risks) {
                if (risk.getTaxonomy().toString().equals(seiTaxonomy.toString()))
                    sum++;
            }
            return sum / risks.size();
        }
    }
}



