package com.management.risk.Controllers;


import com.management.risk.Exception.BusinessException;
import com.management.risk.Exception.Exceptions;
import com.management.risk.Identification.Activity;
import com.management.risk.Identification.DistributionEnum;
import com.management.risk.services.Implementation.AcceptanceRejectionService;
import com.management.risk.services.Implementation.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Acceptance rejection controller.
 */
@RestController(value = "/rejection")
public class AcceptanceRejectionController {
    /**
     * The Acceptance rejection service.
     */
    @Autowired
    private AcceptanceRejectionService acceptanceRejectionService;
    /**
     * The Activity service.
     */
    private ActivityService activityService;

    /**
     * Gets rejection value.
     *
     * @param threshold the threshold
     * @param id        the id
     * @return the rejection value
     * @throws Exception         the exception
     * @throws BusinessException the business exception
     */
    @GetMapping(value = "/rejection/{threshold}/{id}")
    @ResponseBody
    public double get_rejection_value(@PathVariable double threshold, @PathVariable long id) throws Exception, BusinessException {
        if (threshold>1 ||  threshold<0) throw new BusinessException(Exceptions.THRESHOLD_EXCEPTION.toString());
        Activity activity = activityService.findById(id).orElseThrow(Exception::new);
        return acceptanceRejectionService.acceptanceRejection(threshold, activity);
    }

}
