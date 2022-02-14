package de.leonmeister.chinesevocabtrainer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    // This specifies some users
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(environment.getProperty("student"))
                .password(environment.getProperty("studentPassword"))
                .roles("STUDENT")
                .and()
                .withUser(environment.getProperty("admin"))
                .password(environment.getProperty("adminPassword"))
                .roles("ADMIN");
    }

    // This configures which encoding to use
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Using clear text password
    }

    // This configures which api requires which role
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //We don't need CSRF Protection here
                .authorizeRequests()
                .antMatchers("/add").hasAnyRole("STUDENT", "ADMIN")
                .antMatchers("/delete/**").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/random").permitAll()
                .and().formLogin();
    }
}
