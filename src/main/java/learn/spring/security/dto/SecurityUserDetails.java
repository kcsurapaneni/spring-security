package learn.spring.security.dto;

import learn.spring.security.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Krishna Chaitanya
 */
@AllArgsConstructor
public class SecurityUserDetails implements UserDetails {

    private final Customer customer;

    @Override
    public String getUsername() {
        return customer.getName();
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return customer
                .getRoles()
                .stream()
                .map(SecurityGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return customer.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return customer.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return customer.isActive();
    }

    @Override
    public boolean isEnabled() {
        return customer.isActive();
    }

}
