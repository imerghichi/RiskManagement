package com.management.risk.services.Implementation;

import com.management.risk.Analysis.Taxonomy.Taxonomy;
import com.management.risk.Identification.*;
import com.management.risk.services.Interfaces.TaxonomyServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Taxonomy service.
 */
@Service
public class TaxonomyService implements TaxonomyServiceI {
    /**
     * Frequency double.
     *
     * @param seiTaxonomy the sei taxonomy
     * @param risks       the risks
     * @return the double
     */
    @Override
    public double frequency(SEITaxonomy seiTaxonomy, List<Risk> risks) {
        Taxonomy taxonomy = new Taxonomy(risks,seiTaxonomy);
        return taxonomy.frequency();
    }

    /**
     * Frequency double.
     *
     * @param firstLevelTaxonomy the first level taxonomy
     * @param risks              the risks
     * @return the double
     */
    @Override
    public double frequency(FirstLevelTaxonomy firstLevelTaxonomy, List<Risk> risks) {
        Taxonomy taxonomy = new Taxonomy(risks,firstLevelTaxonomy);
        return taxonomy.frequency();
    }

    @Override
    public List<Double> frequeciesFirstLevel(List<Risk> risks) {
        List<Double> resultats = new ArrayList<>();
        for (FirstLevelTaxonomy firstLevelTaxonomy:
             FirstLevelTaxonomy.class.getEnumConstants()) {
            resultats.add(frequency(firstLevelTaxonomy,risks));
        }
        return resultats;
    }

    @Override
    public List<Double> frequenciesSei(List<Risk> risks) {
        List<Double> resultats = new ArrayList<>();
        for (SEITaxonomy seiTaxonomy:
                SEITaxonomy.class.getEnumConstants()) {
            resultats.add(frequency(seiTaxonomy,risks));
        }
        return resultats;
    }

    @Override
    public double frequency(SEITaxonomy seiTaxonomy, Activity activity) {
        return frequency(seiTaxonomy, activity.getRisks());
    }

    @Override
    public double frequency(FirstLevelTaxonomy firstLevelTaxonomy, Activity activity) {
        return frequency(firstLevelTaxonomy, activity.getRisks());
    }

    @Override
    public List<Double> frequeciesFirstLevel(Activity activity) {
        return frequeciesFirstLevel(activity.getRisks());
    }

    @Override
    public List<Double> frequenciesSei(Activity activity) {
        return frequenciesSei(activity.getRisks());
    }

    @Override
    public double frequency(SEITaxonomy seiTaxonomy, Project project) {
        List<Activity> activities= project.getTaskProjects();
        List<Risk> risks =new ArrayList<>();
        for (Activity activia:
             activities) {
            risks.addAll(activia.getRisks());
        }
        return frequency(seiTaxonomy, risks);
    }

    @Override
    public double frequency(FirstLevelTaxonomy firstLevelTaxonomy, Project project) {
        List<Activity> activities= project.getTaskProjects();
        List<Risk> risks =new ArrayList<>();
        for (Activity activia:
                activities) {
            risks.addAll(activia.getRisks());
        }
        return frequency(firstLevelTaxonomy, risks);
    }

    @Override
    public List<Double> frequeciesFirstLevel(Project project) {
        List<Activity> activities= project.getTaskProjects();
        List<Risk> risks =new ArrayList<>();
        for (Activity activia:
                activities) {
            risks.addAll(activia.getRisks());
        }
        return frequeciesFirstLevel(risks);
    }

    @Override
    public List<Double> frequenciesSei(Project project) {
        List<Activity> activities= project.getTaskProjects();
        List<Risk> risks =new ArrayList<>();
        for (Activity activia:
                activities) {
            risks.addAll(activia.getRisks());
        }
        return frequenciesSei(risks);
    }
}
