package com.management.risk.Authentification;

import com.management.risk.Exception.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * The type User details service.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * The User repo.
     */
    @Autowired
    private UserRepo userRepo;

    /**
     * Load user by username user details.
     *
     * @param username the username
     * @return the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(Exceptions.USER_NOT_FOUND.toString());
        }
        return new UserDetailsImpl(user);

    }
}
