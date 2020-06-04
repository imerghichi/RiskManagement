package com.management.risk.repositories;

import com.management.risk.Identification.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Riskrepo.
 */
@Repository
public interface Riskrepo extends JpaRepository<Risk,Long> {
}
