package com.management.risk.Controllers;

import com.management.risk.Identification.Risk;
import com.management.risk.services.Implementation.OwnerLevelDistributionService;
import com.management.risk.services.Implementation.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/owner_level_distribution")
public class OwnerLevelDistributionController {
    @Autowired
    private OwnerLevelDistributionService ownerLevelDistributionService;
    private RiskService riskService;

    @GetMapping("/{id}")
    @ResponseBody
    public List<Float> get(@PathVariable long id){
        List<Risk> risks = riskService.findAll();
        return ownerLevelDistributionService.frequencies(risks);
    }
}
