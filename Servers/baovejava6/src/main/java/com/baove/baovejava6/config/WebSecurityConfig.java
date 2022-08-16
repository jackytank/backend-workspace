package com.baove.baovejava6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.baove.baovejava6.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private CustomUserDetailsService service;

        // @Autowired
        // private DatabaseLoginSuccessHandler databaseLoginSuccessHandler;

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider getDaoAuthenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                provider.setPasswordEncoder(passwordEncoder());
                provider.setUserDetailsService(service);
                return provider;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.authenticationProvider(getDaoAuthenticationProvider());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable();
                http.authorizeRequests()
                                .antMatchers("/", "/admin/**").hasRole("ADMIN")
                                .antMatchers("/rest/authorities").hasRole("ADMIN")
                                .anyRequest().permitAll();

                http.formLogin();
                http.logout()
                                .logoutUrl("/logoff")
                                .logoutSuccessUrl("/logoff/success")
                                .clearAuthentication(true)
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID");
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
                web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        }

}
