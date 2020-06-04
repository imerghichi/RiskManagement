package com.management.risk.Authentification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type User.
 */
@Entity
public class User {

    /**
     * The Id user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    /**
     * The Username.
     */
    private String username;
    /**
     * The Password.
     */
    private String password;
    /**
     * The Role.
     */
    private String role;
    /**
     * The Enabled.
     */
    private boolean enabled;


    /**
     * Gets id user.
     *
     * @return the id user
     */
    public long getId_user() {
        return id_user;
    }

    /**
     * Sets id user.
     *
     * @param id_user the id user
     */
    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
