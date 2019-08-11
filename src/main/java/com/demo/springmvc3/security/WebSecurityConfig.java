package com.demo.springmvc3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/resources/**","/products","/").permitAll()
            .antMatchers("/category").hasRole("ADMIN")
            .antMatchers("/product").hasRole("ADMIN")
           // .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
  }
}
