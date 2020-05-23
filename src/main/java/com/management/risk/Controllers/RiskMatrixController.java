package com.management.risk.Controllers;

import com.management.risk.models.Identification.Risk;
import com.management.risk.services.Implementation.RiskMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/riskmatrix")
public class RiskMatrixController {
    @Autowired
    private RiskMatrixService riskMatrixService;


    @GetMapping
    @ResponseBody
    public List<ArrayList<ArrayList<Risk>>> getmatrix(@RequestBody ArrayList<Risk> risks,@RequestBody int probability_div, @RequestBody int capacity){
        return riskMatrixService.getMatrix(probability_div, risks,capacity);
    }

    @GetMapping
    @ResponseBody
    public List<ArrayList<ArrayList<Risk>>> getmatrix(@RequestBody ArrayList<Risk> risks,@RequestBody int probability_div){
        return riskMatrixService.getMatrix(probability_div, risks);
    }
    @GetMapping
    @ResponseBody
    public List<ArrayList<ArrayList<Risk>>> getmatrix(@RequestBody ArrayList<Risk> risks){
        return riskMatrixService.getMatrix(risks);
    }
}
