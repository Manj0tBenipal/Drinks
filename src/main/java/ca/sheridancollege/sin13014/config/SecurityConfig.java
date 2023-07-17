package ca.sheridancollege.sin13014.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails user1 = User.withUsername("user").password(passwordEncoder.encode("123")).roles("USER").build();
        UserDetails user2 = User.withUsername("bartender").password(passwordEncoder.encode("123")).roles("BARTENDER").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }
}
