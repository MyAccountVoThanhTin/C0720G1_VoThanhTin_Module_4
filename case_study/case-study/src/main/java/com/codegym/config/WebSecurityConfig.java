package com.codegym.config;

import com.codegym.service.impl.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/","/home","/login","/logout").permitAll().and()
                .authorizeRequests().antMatchers("/employee/list","/employee/edit/{id}").access("hasAnyRole('ROLE_EMPLOYEE','ROLE_ADMIN')").and()
        .authorizeRequests().antMatchers("/employee/create","/employee/delete").access("hasAnyRole('ROLE_ADMIN')").and()
                .authorizeRequests().and().formLogin().defaultSuccessUrl("/home").failureForwardUrl("/login").and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");



//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/employee/list");
//        http.authorizeRequests().antMatchers("/","/home","/login","/logout").permitAll().and().
//                authorizeRequests().antMatchers("/admin/*", "/post/*", "/admin/post/comment/*", "/email", "/update-data").access("hasRole('ROLE_ADMIN')").and().
//                authorizeRequests().antMatchers("/post/*", "/post/{id}/comments", "/updateImg/*", "/update-information", "/update-password/*", "/recommendations/*").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')").and().
//                authorizeRequests().antMatchers().access("hasRole('ROLE_USER')")
//                .anyRequest().authenticated()
//                .and().cors();
    }
}
