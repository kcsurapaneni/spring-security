package learn.spring.security.config.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learn.spring.security.config.authentication.ApiKeyAuthentication;
import learn.spring.security.config.manager.ApiKeyAuthenticationManager;
import learn.spring.security.config.provider.ApiKeyAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Krishna Chaitanya Surapaneni
 */
@Log4j2
@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String apiKey = request.getHeader("x-api-key");
        log.atInfo().log("Input x-api-key : {}", apiKey);
        if (apiKey == null || apiKey.isBlank()) {
            filterChain.doFilter(request, response);
        }

        var apiKeyAuthenticationManager = new ApiKeyAuthenticationManager(secret);
        var authentication = apiKeyAuthenticationManager.authenticate(new ApiKeyAuthentication(apiKey));
        if(authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    }

}
