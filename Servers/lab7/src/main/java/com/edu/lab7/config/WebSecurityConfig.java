package com.edu.lab7.config;

import com.edu.lab7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers("/auth/**", "/css/**", "/js/**", "/images/**")
                .permitAll()
                .antMatchers("/home/admins").hasRole("ADMIN")
                .antMatchers("/home/users").hasAnyRole("USER", "ADMIN")
                .antMatchers("/home/authenticated").authenticated()
                .anyRequest().permitAll();

        http.formLogin()
                .loginPage("/auth/login/form")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/auth/login/success", false)
                .failureUrl("/auth/login/error")
                .usernameParameter("username")
                .passwordParameter("password");

        http.rememberMe().rememberMeParameter("remember");

        http.logout()
                .logoutUrl("/auth/logoff")
                .logoutSuccessUrl("/auth/logoff/success")
                .deleteCookies("JSESSIONID");

        http.exceptionHandling()
                .accessDeniedPage("/auth/access/denied");
    }

    // @Bean
    // InMemoryUserDetailsManager userDetailsManager() {
    // // PasswordEncoder encoder =
    // PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // UserDetails user = User
    // .withUsername("batman")
    // .password(passwordEncoder().encode("1221"))
    // .roles("GUEST")
    // .username("user2")
    // .password(passwordEncoder().encode("1221"))
    // .roles("USER", "GUEST")
    // .username("user3")
    // .password(passwordEncoder().encode("1221"))
    // .roles("USER", "GUEST", "ADMIN")
    // .build();
    // return new InMemoryUserDetailsManager(user);
    // }

    // @Bean
    // SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http.csrf().and().cors().disable()
    // .authorizeRequests()
    // .antMatchers("/home/index", "/auth/login/**").permitAll()
    // .anyRequest().authenticated();
    // http.formLogin()
    // .loginPage("/auth/login/form")
    // .loginProcessingUrl("/auth/login")
    // .defaultSuccessUrl("/auth/login/success", false)
    // .failureUrl("/auth/login/error")
    // .usernameParameter("username")
    // .passwordParameter("password");

    // http.rememberMe().rememberMeParameter("remember");

    // http.logout()
    // .logoutUrl("/auth/logoff")
    // .logoutSuccessUrl("/auth/logoff/success");

    // return http.build();
    // }

    // @Bean
    // WebSecurityCustomizer webSecurityCustomizer() {
    // return (web) -> web.ignoring().antMatchers("/images/**", "/css/**",
    // "/js/**");
    // }
}
