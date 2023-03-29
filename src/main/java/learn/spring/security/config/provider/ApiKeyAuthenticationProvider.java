package learn.spring.security.config.provider;

import learn.spring.security.config.authentication.ApiKeyAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Krishna Chaitanya Surapaneni
 */
@RequiredArgsConstructor
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {

    private final String secret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var apiKeyAuthentication = (ApiKeyAuthentication) authentication;
        if(secret.equals(apiKeyAuthentication.getApiKey())) {
            apiKeyAuthentication.setAuthenticated(true);
            return authentication;
        }
        throw new BadCredentialsException("Wrong `x-api-key` has been provided");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }

}
