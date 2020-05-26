package com.management.risk.Controllers;

import com.management.risk.models.Identification.FirstLevelTaxonomy;
import com.management.risk.models.Identification.Risk;
import com.management.risk.models.Identification.SEITaxonomy;
import com.management.risk.services.Implementation.TaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/taxonomy")
public class TaxonomyController {
    @Autowired
    private TaxonomyService taxonomyService;

    @GetMapping(value = "/bysei/")
    @ResponseBody
    public double frequency (@PathVariable SEITaxonomy seiTaxonomy, @PathVariable List<Risk> risks){
        return taxonomyService.frequency(seiTaxonomy, risks);
    }
    @GetMapping(value = "/byfrstlvl/")
    @ResponseBody
    public double frequency (@PathVariable FirstLevelTaxonomy firstLevelTaxonomy, @PathVariable List<Risk> risks){
        return taxonomyService.frequency(firstLevelTaxonomy, risks);
    }
}
