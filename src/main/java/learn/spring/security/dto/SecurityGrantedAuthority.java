package learn.spring.security.dto;

import learn.spring.security.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Krishna Chaitanya
 */
@AllArgsConstructor
public class SecurityGrantedAuthority implements GrantedAuthority {

    private final Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }

}
