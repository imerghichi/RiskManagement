package com.management.risk.repositories;

import com.management.risk.models.Mitigation.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepo extends JpaRepository<Response, Long> {
}
