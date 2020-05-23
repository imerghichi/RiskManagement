package com.management.risk.services.Implementation;

import com.management.risk.Analysis.Taxonomy.Taxonomy;
import com.management.risk.models.Identification.FirstLevelTaxonomy;
import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Identification.SEITaxonomy;
import com.management.risk.services.Interfaces.TaxonomyServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxonomyService implements TaxonomyServiceI {
    @Override
    public double frequency(SEITaxonomy seiTaxonomy, List<Risk> risks) {
        Taxonomy taxonomy = new Taxonomy(risks,seiTaxonomy);
        return taxonomy.frequency();
    }

    @Override
    public double frequency(FirstLevelTaxonomy firstLevelTaxonomy, List<Risk> risks) {
        Taxonomy taxonomy = new Taxonomy(risks,firstLevelTaxonomy);
        return taxonomy.frequency();
    }
}
