package learn.spring.security.config;

import learn.spring.security.config.filters.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Krishna Chaitanya Surapaneni
 */
@Configuration
public class SecurityConfig {

    @Value("${the.secret}") String secret;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                    .httpBasic()
                    .and()
                    .addFilterBefore(new ApiKeyFilter(secret), BasicAuthenticationFilter.class)
                    .authorizeHttpRequests().anyRequest().authenticated()
                    .and()
                .build();
    }
}
