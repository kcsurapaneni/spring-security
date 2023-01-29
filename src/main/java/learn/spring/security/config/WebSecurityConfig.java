package learn.spring.security.config;

import learn.spring.security.service.SecurityUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Krishna Chaitanya
 */
@Configuration
public class WebSecurityConfig {

    /**
     * We are going to use {@link SecurityUserDetailsService}
     * @return
     */
    //@formatter:off
    /**
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
    */
    //@formatter:on
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
