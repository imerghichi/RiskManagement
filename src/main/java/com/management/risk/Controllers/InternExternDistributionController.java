package com.management.risk.Controllers;

import com.management.risk.Exception.BusinessException;
import com.management.risk.Exception.Exceptions;
import com.management.risk.Identification.Risk;
import com.management.risk.services.Implementation.InterExterDistributionService;
import com.management.risk.services.Implementation.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/inter_extern")
public class InternExternDistributionController {
    @Autowired
    private InterExterDistributionService interExterDistributionService;
    private RiskService riskService;

    @GetMapping(value = "/{id}}")
    @ResponseBody
    public  List<Float> get(@PathVariable long id) throws BusinessException {
        List<Risk> risks = riskService.findAll();
        if(risks == null) throw new BusinessException(Exceptions.NO_RISK_FOUND.toString());
        return interExterDistributionService.frequencies(risks);
    }
}
