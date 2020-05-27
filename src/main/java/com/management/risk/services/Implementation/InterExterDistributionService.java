package com.management.risk.services.Implementation;

import com.management.risk.Identification.Origin;
import com.management.risk.Identification.Risk;
import com.management.risk.services.Interfaces.InternExternDistributionServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterExterDistributionService implements InternExternDistributionServiceI {
    @Override
    public List<Float> frequencies(List<Risk> risks) {
        List<Float> res = new ArrayList<>();
        //il peut y avoir des risques sans
        // spec
        List<Integer> occ = occurences(risks);
        int total = occ.get(0)+ occ.get(1);
        float external = occ.get(0) / total;
        float internal = occ.get(1) / total;
        res.add(external);
        res.add(internal);
        return res;
    }

    private List<Integer> occurences(List<Risk> risks){
        List<Integer> res = new ArrayList<>();
        int sum_intern = 0;
        int sum_extern = 0;
        for (Risk risk:
             risks) {
            if (risk.getOrigin_risk().equals(Origin.external) || risk.getOrigin_risk().equals(Origin.vendor)) sum_extern++;
            else if (risk.getOrigin_risk().equals(Origin.internal)) sum_intern++;
        }
        res.add(new Integer(sum_extern));
        res.add(new Integer(sum_intern));
        return res;
    }
}
