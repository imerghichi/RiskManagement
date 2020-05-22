package com.management.risk.repositories;

import com.management.risk.models.Identification.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio,Long> {
}
