package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Portfolio;
import com.management.risk.Identification.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface PortfolioServiceI {
    List<Portfolio> findAll();
    List<Portfolio> findAll(Sort sort);
    Optional<Portfolio> findById (long id);
    void deleteById (long id);
    Portfolio save (Portfolio portfolio);

    List<Portfolio> findPortfolioByProject (Project project);
    //

}
