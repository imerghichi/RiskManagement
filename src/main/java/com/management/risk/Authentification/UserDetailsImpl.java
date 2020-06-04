package com.management.risk.Authentification;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * The type User details.
 */
public class UserDetailsImpl implements UserDetails {
    /**
     * The User.
     */
    private User user;

    /**
     * Instantiates a new User details.
     *
     * @param user the user
     */
    public UserDetailsImpl(User user) {
        this.user =user;
    }

    /**
     * Gets authorities.
     *
     * @return the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority((user.getRole()));
        return Arrays.asList(authority);
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Is account non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Is account non locked boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Is credentials non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
