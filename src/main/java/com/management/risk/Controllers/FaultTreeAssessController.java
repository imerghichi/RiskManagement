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

@RestController(value = "/asessFaultTree")
public class FaultTreeAssessController {
    @Autowired
    private FaultTreeAssessImpl faultTreeAssess;
    private FaultTreeService faultTreeService;

    @GetMapping(value = "/{id}/{usedMethod")
    @ResponseBody
    public double getAssess(@PathVariable long id, @PathVariable String usedMethod) throws Exception, BusinessException {
        if(!faultTreeService.findById(id).isPresent()) throw new BusinessException(Exceptions.NO_FAULT_TREE_FOUND.toString());
        LeafEvent leafEvent = faultTreeService.findById(id).orElse(null);
        UsedMethod usedMethod1 = UsedMethod.valueOf(usedMethod);
        return faultTreeAssess.assess(leafEvent,usedMethod1);
    }
}
