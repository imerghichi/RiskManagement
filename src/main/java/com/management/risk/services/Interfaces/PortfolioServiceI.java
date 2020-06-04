package com.management.risk.services.Interfaces;

import com.management.risk.Identification.Portfolio;
import com.management.risk.Identification.Project;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * The interface Portfolio service i.
 */
public interface PortfolioServiceI {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Portfolio> findAll();

    /**
     * Find all list.
     *
     * @param sort the sort
     * @return the list
     */
    List<Portfolio> findAll(Sort sort);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Portfolio> findById (long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById (long id);

    /**
     * Save portfolio.
     *
     * @param portfolio the portfolio
     * @return the portfolio
     */
    Portfolio save (Portfolio portfolio);

    /**
     * Update portfolio.
     *
     * @param portfolio the portfolio
     * @return the portfolio
     */
    Portfolio update(Portfolio portfolio);

    /**
     * Find portfolio by project list.
     *
     * @param project the project
     * @return the list
     */
    List<Portfolio> findPortfolioByProject (Project project);
    //

}
