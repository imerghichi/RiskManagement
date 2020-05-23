package com.management.risk.Controllers;

import com.management.risk.services.Implementation.RiskMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/riskmatrix")
public class RiskMatrixController {
    @Autowired
    private RiskMatrixService riskMatrixService;

    // TODO: 23/05/2020

}
