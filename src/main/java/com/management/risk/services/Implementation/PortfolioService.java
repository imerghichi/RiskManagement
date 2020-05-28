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

@Service
public class PortfolioService implements PortfolioServiceI {
    @Autowired
    private PortfolioRepo portfolioRepo;

    @Override
    public List<Portfolio> findAll() {
        return portfolioRepo.findAll();
    }

    @Override
    public List<Portfolio> findAll(Sort sort) {
        return portfolioRepo.findAll(sort);
    }

    @Override
    public Optional<Portfolio> findById(long id) {
        return portfolioRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        portfolioRepo.deleteById(id);

    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

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

    @Override
    public Portfolio update(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }
}
