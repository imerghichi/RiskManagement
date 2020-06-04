package com.management.risk.Controllers;

import com.management.risk.Identification.FirstLevelTaxonomy;
import com.management.risk.Identification.Risk;
import com.management.risk.Identification.SEITaxonomy;
import com.management.risk.services.Implementation.TaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Taxonomy controller.
 */
@RestController("/taxonomy")
public class TaxonomyController {
    /**
     * The Taxonomy service.
     */
    @Autowired
    private TaxonomyService taxonomyService;

    /**
     * Frequency double.
     *
     * @param seiTaxonomy the sei taxonomy
     * @param risks       the risks
     * @return the double
     */
    @GetMapping(value = "/bysei/")
    @ResponseBody
    public double frequency (@PathVariable SEITaxonomy seiTaxonomy, @PathVariable List<Risk> risks){
        return taxonomyService.frequency(seiTaxonomy, risks);
    }

    /**
     * Frequency double.
     *
     * @param firstLevelTaxonomy the first level taxonomy
     * @param risks              the risks
     * @return the double
     */
    @GetMapping(value = "/byfrstlvl/")
    @ResponseBody
    public double frequency (@PathVariable FirstLevelTaxonomy firstLevelTaxonomy, @PathVariable List<Risk> risks){
        return taxonomyService.frequency(firstLevelTaxonomy, risks);
    }
}
