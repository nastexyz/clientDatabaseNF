package pl.coderslab.DatabaseNF;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   /*     auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("123"));*/
        auth.userDetailsService(springSecurityUserDetails())
                .passwordEncoder(passwordEncoder());
    }

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(*//*"/person/**", "/service/**", "/therapist/remove", "/therapist/therapistForm", "/therapist/therapistListing"*//*).authenticated() // wszystkie wymienione linki będą wymagały zalogowania
               .antMatchers(  "/", "therapist/**", "/person/**", "/service/**").permitAll() // do strony głównej, rejestracji i logowania będą mieli dostęp wszyscy
                .and().formLogin(); *//*.loginPage("/therapist/login")*//* // będzie wyświetlał się formularz logowania
        http.csrf().disable();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/person/**", "/service/**", "/therapist/form/all", "/therapist/form/edit", "/therapist/form/remove").authenticated() // wszystkie wymienione adresy będą wymagały zalogowania
                .antMatchers(  "/", "/therapist/register").permitAll() // do strony głównej i rejestracji będą mieli dostęp wszyscy
                .and().formLogin(); /*.loginPage("/therapist/login");*/ // będzie wyświetlał się formularz logowania
        http.csrf().disable();
    }

    @Bean
    public SpringSecurityUserDetails springSecurityUserDetails() {
        return new SpringSecurityUserDetails();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
