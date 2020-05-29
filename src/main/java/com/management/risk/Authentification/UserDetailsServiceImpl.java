package com.management.risk.Authentification;

import com.management.risk.Exception.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(Exceptions.USER_NOT_FOUND.toString());
        }
        return new UserDetailsImpl(user);

    }
}
