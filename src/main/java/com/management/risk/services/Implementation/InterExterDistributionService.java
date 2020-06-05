package com.management.risk.services.Implementation;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.Origin;
import com.management.risk.Identification.Project;
import com.management.risk.Identification.Risk;
import com.management.risk.repositories.ActivityRepo;
import com.management.risk.repositories.Riskrepo;
import com.management.risk.services.Interfaces.InternExternDistributionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Inter exter distribution service.
 */
@Service
public class InterExterDistributionService implements InternExternDistributionServiceI {


    /**
     * Frequencies list.
     *
     * @param risks the risks
     * @return the list
     */
    @Override
    public List<Float> frequencies(List<Risk> risks) {
        List<Float> res = new ArrayList<>();
        //il peut y avoir des risques sans
        // spec
        List<Integer> occ = occurences(risks);
        int total = occ.get(0)+ occ.get(1);
        float external =(float) occ.get(0) / (float) total;
        float internal =(float) occ.get(1) /(float) total;
        res.add(external);
        res.add(internal);
        return res;
    }

    @Override
    public List<Float> frequencies(Activity activity) {
        return frequencies(activity.getRisks());
    }

    @Override
    public List<Float> frequencies(Project project) {
        List<Float> floats = new ArrayList<>();
        List<Activity> activities = project.getTaskProjects();
        for (Activity activity:
             activities) {
            floats.addAll(frequencies(activity));
        }
        return floats;
    }

    /**
     * Occurences list.
     *
     * @param risks the risks
     * @return the list
     */
    private List<Integer> occurences(List<Risk> risks){
        List<Integer> res = new ArrayList<>();
        int sum_intern = 0;
        int sum_extern = 0;
        for (Risk risk:
             risks) {
            if (risk.getOrigin_risk().equals(Origin.external) || risk.getOrigin_risk().equals(Origin.vendor)) sum_extern++;
            else if (risk.getOrigin_risk().equals(Origin.internal)) sum_intern++;
        }
        res.add(sum_extern);
        res.add(sum_intern);
        return res;
    }
}
