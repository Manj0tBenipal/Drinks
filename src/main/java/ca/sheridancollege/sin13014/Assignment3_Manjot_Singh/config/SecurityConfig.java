package ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsServiceImpl userDetailsService;
    public SecurityConfig(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService =  userDetailsService;
    }

    @Bean

    public SecurityFilterChain filerChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // Allow H2 console to be accessed in frames
        http.headers().frameOptions().sameOrigin();

        http.authorizeHttpRequests((auth) ->
                        auth

                                .requestMatchers(HttpMethod.GET, "/").permitAll()
                                .requestMatchers(HttpMethod.GET, "/css/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/images/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/home").permitAll()
                                .requestMatchers(HttpMethod.GET, "/h2/").permitAll()
                                .requestMatchers(HttpMethod.POST, "/h2/").permitAll()
                                .requestMatchers(HttpMethod.GET, "/register").permitAll()
                                .requestMatchers(HttpMethod.POST, "/addUser").permitAll()
                                .requestMatchers(HttpMethod.GET, "/viewAllTickets").hasRole("VENDER")
                                .requestMatchers(HttpMethod.GET, "/edit/**").hasRole("VENDER")
                                .requestMatchers(HttpMethod.GET, "/delete/**").hasRole("VENDER")
                                .requestMatchers(HttpMethod.POST, "/add-ticket").hasRole("VENDER")
                                .requestMatchers(HttpMethod.POST, "/update-ticket").hasRole("VENDER")
                                .requestMatchers(HttpMethod.GET, "/login").permitAll()


                                .anyRequest().authenticated())
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/login")
                                .failureUrl("/login?failed")

                                .permitAll())
                .logout((logout) ->
                        logout
                                .deleteCookies("remove")
                                .invalidateHttpSession(true)
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout")
                                .permitAll())
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling
                                .accessDeniedPage("/access-denied"));

        return http.build();
    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passEncoder) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passEncoder);
        return authenticationManagerBuilder.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
