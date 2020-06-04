package com.management.risk.Authentification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface User repo.
 */
public interface UserRepo extends JpaRepository<User, Long> {
    /**
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
}
