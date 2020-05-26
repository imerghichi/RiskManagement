package com.management.risk.Controllers;

import com.management.risk.Analysis.TreesAnalysis.FaultTree.LeafEvent;
import com.management.risk.Analysis.TreesAnalysis.FaultTree.UsedMethod;
import com.management.risk.services.Implementation.FaultTreeAssessImpl;
import com.management.risk.services.Implementation.FaultTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/asessFaultTree")
public class FaultTreeAssessController {
    @Autowired
    private FaultTreeAssessImpl faultTreeAssess;
    private FaultTreeService faultTreeService;

    @GetMapping(value = "/{id}/{usedMethod")
    @ResponseBody
    public double getAssess(@PathVariable long id, @PathVariable String usedMethod) throws Exception {
        LeafEvent leafEvent = faultTreeService.findById(id).orElseThrow(Exception::new);
        UsedMethod usedMethod1 = UsedMethod.valueOf(usedMethod);
        return faultTreeAssess.assess(leafEvent,usedMethod1);
    }

}
