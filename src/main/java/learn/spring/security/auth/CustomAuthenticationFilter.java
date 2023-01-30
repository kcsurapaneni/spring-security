package learn.spring.security.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Krishna Chaitanya
 */
@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.hasText(request.getHeader("secure-key"))) {
            authenticationManager.authenticate(
                    new CustomAuthentication(request.getHeader("secure-key"), false));
        } else if (StringUtils.hasText(request.getHeader("x-api-key"))) {
            authenticationManager.authenticate(
                    new XApiAuthentication(request.getHeader("x-api-key"), false));
        }
        filterChain.doFilter(request, response);
    }

}
