package com.ssnk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //this class will help to create the spring security filter chain

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").hasAuthority("ADMIN")
                .antMatchers("/tempCustomer/**").hasAuthority("MAKER")
                .antMatchers("/checker/**").hasAuthority("CHECKER")
                .anyRequest().authenticated()
//                .antMatchers("/studentInfo").authenticated()
//                .antMatchers("/register").permitAll()
                .and()
                .formLogin() .loginPage("/login")
                .permitAll()
                .and()
                .logout() .invalidateHttpSession(true)
                .clearAuthentication(true) .permitAll()
                .logoutSuccessUrl("/login");
//                .and()
//                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//        .authorizeRequests()
////        .antMatchers("/signup**").permitAll()
//        .anyRequest().authenticated()
////        .and()
////        .formLogin() .loginPage("/login")
////        .permitAll()
//        .and()
//        .logout() .invalidateHttpSession(true)
//        .clearAuthentication(true) .permitAll();
//    }
}