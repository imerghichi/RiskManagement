package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.Risk;

import java.util.List;

public interface InternExternDistributionServiceI {
    List<Float> frequencies(List<Risk> risks);

}
