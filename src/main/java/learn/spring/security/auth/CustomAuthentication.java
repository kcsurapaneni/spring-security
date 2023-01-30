package learn.spring.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Krishna Chaitanya
 */
public record CustomAuthentication(String secureKey, boolean authentication) implements Authentication {

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

}
