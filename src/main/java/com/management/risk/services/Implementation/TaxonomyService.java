package com.management.risk.services.Implementation;

import com.management.risk.Analysis.Taxonomy.Taxonomy;
import com.management.risk.Identification.FirstLevelTaxonomy;
import com.management.risk.Identification.Risk;
import com.management.risk.Identification.SEITaxonomy;
import com.management.risk.services.Interfaces.TaxonomyServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Taxonomy service.
 */
@Service
public class TaxonomyService implements TaxonomyServiceI {
    /**
     * Frequency double.
     *
     * @param seiTaxonomy the sei taxonomy
     * @param risks       the risks
     * @return the double
     */
    @Override
    public double frequency(SEITaxonomy seiTaxonomy, List<Risk> risks) {
        Taxonomy taxonomy = new Taxonomy(risks,seiTaxonomy);
        return taxonomy.frequency();
    }

    /**
     * Frequency double.
     *
     * @param firstLevelTaxonomy the first level taxonomy
     * @param risks              the risks
     * @return the double
     */
    @Override
    public double frequency(FirstLevelTaxonomy firstLevelTaxonomy, List<Risk> risks) {
        Taxonomy taxonomy = new Taxonomy(risks,firstLevelTaxonomy);
        return taxonomy.frequency();
    }
}
