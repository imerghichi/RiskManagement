package com.management.risk.Controllers;

import com.management.risk.Identification.Risk;
import com.management.risk.services.Implementation.TopRiskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class TopRisksController {
    @Autowired
    TopRiskService topRiskService;

    @GetMapping(value = "/topTen")
    @ResponseBody
    public List<Risk> topTen(){
        return topRiskService.topRisks();
    }

}
