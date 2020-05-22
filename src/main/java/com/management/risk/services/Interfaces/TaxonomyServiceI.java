package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.FirstLevelTaxonomy;
import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Identification.SEITaxonomy;

import java.util.List;

public interface TaxonomyServiceI {
    double frequency (SEITaxonomy seiTaxonomy, List<Risk> risks);
    double frequency (FirstLevelTaxonomy firstLevelTaxonomy, List<Risk> risks);

}
