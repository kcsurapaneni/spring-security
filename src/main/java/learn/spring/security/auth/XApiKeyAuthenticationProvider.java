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
public class XApiKeyAuthenticationProvider implements AuthenticationProvider {

    @Value("${custom.secure.x-api-key}") private String xApiKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        XApiAuthentication xApiAuthentication = (XApiAuthentication) authentication;
        if(xApiKey.equals(xApiAuthentication.xApiKey())) {
            return new XApiAuthentication(null, true);
        }
        throw new BadCredentialsException("x-api-key is not matching");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(XApiAuthentication.class);
    }

}
