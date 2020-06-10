package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.UsedMethod;
import com.management.risk.Exception.BusinessException;
import com.management.risk.Exception.Exceptions;
import com.management.risk.services.Implementation.FaultTreeAssessImpl;
import com.management.risk.services.Implementation.FaultTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * The type Fault tree assess controller.
 */
@RestController(value = "/asessFaultTree")
public class FaultTreeAssessController {
    /**
     * The Fault tree assess.
     */
    @Autowired
    private FaultTreeAssessImpl faultTreeAssess;
    /**
     * The Fault tree service.
     */
    private FaultTreeService faultTreeService;

    /**
     * Gets assess.
     *
     * @param id         the id
     * @param usedMethod the used method
     * @return the assess
     * @throws BusinessException the business exception
     */
    @GetMapping(value = "/assessFT/{id}/{usedMethod")
    @ResponseBody
    public double getAssess(@PathVariable long id, @PathVariable String usedMethod) throws BusinessException {
        if(!faultTreeService.findById(id).isPresent()) throw new BusinessException(Exceptions.NO_FAULT_TREE_FOUND.toString());
        LeafEvent leafEvent = faultTreeService.findById(id).orElse(null);
        UsedMethod usedMethod1 = UsedMethod.valueOf(usedMethod);
        return faultTreeAssess.assess(leafEvent,usedMethod1);
    }
}
