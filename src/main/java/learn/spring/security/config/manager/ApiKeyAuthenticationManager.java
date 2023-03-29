package learn.spring.security.config.manager;

import learn.spring.security.config.provider.ApiKeyAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Krishna Chaitanya Surapaneni
 */
@RequiredArgsConstructor
public class ApiKeyAuthenticationManager implements AuthenticationManager {

    private final String secret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var apiKeyAuthenticationProvider = new ApiKeyAuthenticationProvider(secret);
        if(apiKeyAuthenticationProvider.supports(authentication.getClass())) {
            return apiKeyAuthenticationProvider.authenticate(authentication);
        }
        return authentication;
    }

}
