package com.management.risk.services.Interfaces;

import com.management.risk.Identification.FirstLevelTaxonomy;
import com.management.risk.Identification.Risk;
import com.management.risk.Identification.SEITaxonomy;

import java.util.List;

public interface TaxonomyServiceI {
    double frequency (SEITaxonomy seiTaxonomy, List<Risk> risks);
    double frequency (FirstLevelTaxonomy firstLevelTaxonomy, List<Risk> risks);

}
