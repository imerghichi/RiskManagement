package com.management.risk.Controllers;

import com.management.risk.Exception.BusinessException;
import com.management.risk.Exception.Exceptions;
import com.management.risk.Identification.Risk;
import com.management.risk.services.Implementation.RiskMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Risk matrix controller.
 */
@RestController("/riskmatrix")
public class RiskMatrixController {
    /**
     * The Risk matrix service.
     */
    @Autowired
    private RiskMatrixService riskMatrixService;


    /**
     * Gets .
     *
     * @param risks           the risks
     * @param probability_div the probability div
     * @param capacity        the capacity
     * @return the
     * @throws BusinessException the business exception
     */
    @GetMapping(value = "/3args/")
    @ResponseBody
    public List<ArrayList<ArrayList<Risk>>> getmatrix(@RequestBody ArrayList<Risk> risks,@RequestBody int probability_div, @RequestBody int capacity) throws BusinessException {
        if(probability_div <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_PROBA_DIV.toString());
        if(capacity <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_CAPACITY.toString());
        return riskMatrixService.getMatrix(probability_div, risks,capacity);
    }

    /**
     * Gets 1.
     *
     * @param risks           the risks
     * @param probability_div the probability div
     * @return the 1
     * @throws BusinessException the business exception
     */
    @GetMapping(value = "/2arg/")
    @ResponseBody
    public List<ArrayList<ArrayList<Risk>>> getmatrix1(@RequestBody ArrayList<Risk> risks,@RequestBody int probability_div) throws BusinessException {
        if(probability_div <= 0) throw new BusinessException(Exceptions.NON_VALID_PARAMETER_PROBA_DIV.toString());
        return riskMatrixService.getMatrix(probability_div, risks);
    }

    /**
     * Getmatrix 2 list.
     *
     * @param risks the risks
     * @return the list
     */
    @GetMapping(value = "/1arg")
    @ResponseBody
    public List<ArrayList<ArrayList<Risk>>> getmatrix2(@RequestBody ArrayList<Risk> risks){
        return riskMatrixService.getMatrix(risks);
    }
}
