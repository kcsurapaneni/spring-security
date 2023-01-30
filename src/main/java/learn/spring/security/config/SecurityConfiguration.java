package learn.spring.security.config;

import learn.spring.security.auth.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Krishna Chaitanya
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CustomAuthenticationFilter customAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(customAuthenticationFilter,
                            UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests().anyRequest().authenticated()
                .and().build();
    }
}
