package learn.spring.security.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author Krishna Chaitanya
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${custom.secure.key}")
    private String secureKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var customAuthentication = (CustomAuthentication) authentication;
        if (secureKey.equals(customAuthentication.secureKey())) {
            return new CustomAuthentication(null, true);
        }
        throw new BadCredentialsException("key is not matching");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthentication.class);
    }

}
