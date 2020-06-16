package com.management.risk.services.Implementation;

import com.management.risk.Identification.Risk;
import com.management.risk.repositories.Riskrepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

public class TopRiskService  implements com.management.risk.services.Interfaces.TopRiskService {
    @Autowired
    Riskrepo riskrepo;

    public List<Risk> topRisks(){
        List<Risk> all= riskrepo.findAll();
        all.sort(forSortComparingExposure);
        return all;
    }
    public static Comparator<Risk> forSortComparingExposure = new Comparator<Risk>() {
        @Override
        public int compare(Risk risk, Risk t1) {
            Float ex1 = risk.exposure();
            Float ex2 = t1.exposure();
            return ex1.compareTo(ex2);
        }
    };
}
