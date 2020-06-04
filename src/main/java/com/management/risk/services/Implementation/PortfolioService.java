package com.management.risk.services.Implementation;

import com.management.risk.Identification.Portfolio;
import com.management.risk.Identification.Project;
import com.management.risk.repositories.PortfolioRepo;
import com.management.risk.services.Interfaces.PortfolioServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Portfolio service.
 */
@Service
public class PortfolioService implements PortfolioServiceI {
    /**
     * The Portfolio repo.
     */
    @Autowired
    private PortfolioRepo portfolioRepo;

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Portfolio> findAll() {
        return portfolioRepo.findAll();
    }

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    @Override
    public List<Portfolio> findAll(Sort sort) {
        return portfolioRepo.findAll(sort);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    @Override
    public Optional<Portfolio> findById(long id) {
        return portfolioRepo.findById(id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(long id) {
        portfolioRepo.deleteById(id);

    }

    /**
     * Save portfolio.
     *
     * @param portfolio the portfolio
     * @return the portfolio
     */
    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    /**
     * Find portfolio by project list.
     *
     * @param project the project
     * @return the list
     */
    @Override
    public List<Portfolio> findPortfolioByProject(Project project) {
        List<Portfolio> portfolios = portfolioRepo.findAll();
        List<Portfolio> res = new ArrayList<>();
        for (Portfolio portfolio:
                portfolios) {
            if(portfolio.getProject() == project)
                res.add(portfolio);
        }
        return res;
    }

    /**
     * Update portfolio.
     *
     * @param portfolio the portfolio
     * @return the portfolio
     */
    @Override
    public Portfolio update(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }
}
