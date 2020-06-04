package com.management.risk.services.Implementation;

import com.management.risk.Identification.Risk;
import com.management.risk.services.Interfaces.OwnerLevelDistributionServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Owner level distribution service.
 */
@Service
public class OwnerLevelDistributionService implements OwnerLevelDistributionServiceI {
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
        int total = occ.get(0)+ occ.get(1)+ occ.get(2)+occ.get(3)+occ.get(4);
        float entreprise_level = (float) occ.get(0) / (float)total;
        float sbu_level = (float) occ.get(1) / (float)total;
        float program = (float) occ.get(2) / (float)total;
        float project = (float) occ.get(3) /(float) total;
        float process =(float) occ.get(4) /(float) total;
        res.add(entreprise_level);
        res.add(sbu_level);
        res.add(program);
        res.add(project);
        res.add(process);
        return res;
}

    /**
     * Occurences list.
     *
     * @param risks the risks
     * @return the list
     */
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
        res.add(sum_entreprise);
        res.add(sum_sbu);
        res.add(sum_program);
        res.add(sum_project);
        res.add(sum_process);
        return res;
    }
}
