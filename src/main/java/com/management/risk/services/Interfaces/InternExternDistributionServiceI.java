package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Activity;
import com.management.risk.Identification.Project;
import com.management.risk.Identification.Risk;

import java.util.List;

/**
 * The interface Intern extern distribution service i.
 */
public interface InternExternDistributionServiceI {
    /**
     * Frequencies list.
     *
     * @param risks the risks
     * @return the list
     */
    List<Float> frequencies(List<Risk> risks);
    List<Float> frequencies(Activity activity);
    List<Float> frequencies(Project project);

}
