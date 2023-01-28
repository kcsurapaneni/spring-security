package learn.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Krishna Chaitanya
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();
        var userDetails = User
                .builder()
                .username("kc")
                .password("hello")
                .authorities("read")
                .build();
        userDetailsManager.createUser(userDetails);
        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
