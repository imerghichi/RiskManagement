package com.management.risk.repositories;

import com.management.risk.Identification.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Portfolio repo.
 */
@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio,Long> {
}
