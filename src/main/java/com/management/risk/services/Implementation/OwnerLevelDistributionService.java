package com.management.risk.services.Implementation;

import com.management.risk.models.Identification.Origin;
import com.management.risk.models.Identification.OwnerLevel;
import com.management.risk.models.Identification.Risk;
import com.management.risk.services.Interfaces.OwnerLevelDistributionServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerLevelDistributionService implements OwnerLevelDistributionServiceI {
    @Override
    public List<Float> frequencies(List<Risk> risks) {
    List<Float> res = new ArrayList<>();
    //il peut y avoir des risques sans
    // spec
        List<Integer> occ = occurences(risks);
        int total = occ.get(0)+ occ.get(1)+ occ.get(2)+occ.get(3)+occ.get(4);
        float entreprise_level = occ.get(0) / total;
        float sbu_level = occ.get(1) / total;
        float program = occ.get(2) / total;
        float project = occ.get(3) / total;
        float process = occ.get(4) /total;
        res.add(entreprise_level);
        res.add(sbu_level);
        res.add(program);
        res.add(project);
        res.add(process);
        return res;
}

/*
    Enterprise_Level,
    SBU_Level,
    Program_Level,
    Project_Level,
    process_level
 */
    private List<Integer> occurences(List<Risk> risks){
        List<Integer> res = new ArrayList<>();
        int sum_entreprise = 0;
        int sum_sbu = 0;
        int sum_program = 0;
        int sum_project = 0;
        int sum_process = 0;
        for (Risk risk:
                risks) {
            switch (risk.getOwnerLevel()){
                case SBU_Level:
                    sum_sbu++;
                    break;
                case process_level:
                    sum_process++;
                    break;
                case Program_Level:
                    sum_program++;
                    break;
                case Project_Level:
                    sum_project++;
                    break;
                case Enterprise_Level:
                    sum_entreprise++;
                    break;
            }
        }
        res.add(new Integer(sum_entreprise));
        res.add(new Integer(sum_sbu));
        res.add(new Integer(sum_program));
        res.add(new Integer(sum_project));
        res.add(new Integer(sum_process));
        return res;
    }
}
