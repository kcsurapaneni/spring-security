package learn.spring.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Krishna Chaitanya
 */
@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final XApiKeyAuthenticationProvider xApiKeyAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (customAuthenticationProvider.supports(authentication.getClass())
                && customAuthenticationProvider.authenticate(authentication) != null
                && customAuthenticationProvider.authenticate(authentication).isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(customAuthenticationProvider.authenticate(authentication));
            return authentication;
        }
        if (xApiKeyAuthenticationProvider.supports(authentication.getClass())
                && xApiKeyAuthenticationProvider.authenticate(authentication) != null
                && xApiKeyAuthenticationProvider.authenticate(authentication).isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(xApiKeyAuthenticationProvider.authenticate(authentication));
            return authentication;
        }
        return null;
    }

}
