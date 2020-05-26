package com.management.risk.Controllers;


import com.management.risk.models.Identification.DistributionEnum;
import com.management.risk.services.Implementation.AcceptanceRejectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/rejection")
public class AcceptanceRejectionController {
    @Autowired
    private AcceptanceRejectionService acceptanceRejectionService;

    @GetMapping(value = "/{distributionEnum}/{threshold}/{param1}")
    @ResponseBody
    public double get_rejection_value(@PathVariable String distributionEnum, @PathVariable double threshold, @PathVariable double param1){
        DistributionEnum distributionEnum1 = DistributionEnum.valueOf(distributionEnum);
        return acceptanceRejectionService.acceptanceRejection(distributionEnum1, threshold, param1);
    }

    @GetMapping(value = "/{distributionEnum}/{threshold}/{param1}/{param2}")
    @ResponseBody
    public double get_rejection_value(@PathVariable String distributionEnum, @PathVariable double threshold, @PathVariable double param1, @PathVariable double param2){
        DistributionEnum distributionEnum1 =DistributionEnum.valueOf(distributionEnum);
        return acceptanceRejectionService.acceptanceRejection(distributionEnum1, threshold, param1, param2);
    }
}
