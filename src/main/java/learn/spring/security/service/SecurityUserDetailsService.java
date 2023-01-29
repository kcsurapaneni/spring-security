package learn.spring.security.service;

import learn.spring.security.dto.SecurityUserDetails;
import learn.spring.security.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Krishna Chaitanya
 */
@Service
@AllArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionalCustomer = customerRepository.findCustomerByUsername(username);

        return optionalCustomer
                .map(SecurityUserDetails::new)
                .orElseThrow(() -> new BadCredentialsException("Credentials are not matching"));
    }

}
