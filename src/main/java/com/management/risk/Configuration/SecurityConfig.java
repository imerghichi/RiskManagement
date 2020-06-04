package com.management.risk.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The type Security config.
 */
@Configuration("H2")
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    /**
     * Configure.
     *
     * @param http the http
     * @throws Exception the exception
     */
//for h2 console
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
