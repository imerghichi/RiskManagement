package com.management.risk.Analysis.Taxonomy;

import com.management.risk.models.Identification.*;

import java.util.Collections;
import java.util.List;

public class Taxonomy {


    double frequency(List<Risk> risks,SEITaxonomy seiTaxonomy){
        int sum = 0;
        for (Risk risk :
                risks) {
            if(risk.getTaxonomy().toString() == seiTaxonomy.toString())
                sum++;
        }
        return sum/risks.size();
    }
    double frequency(List<Risk> risks, FirstLevelTaxonomy firstLevelTaxonomy){
        int sum = 0;
        for (Risk risk :
                risks) {
            if (risk.getTaxonomy().getFirst_level_taxonomy().toString() == firstLevelTaxonomy.toString())
                sum++;
        }
        return sum/risks.size();
    }
}



