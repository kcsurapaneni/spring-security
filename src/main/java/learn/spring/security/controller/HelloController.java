package learn.spring.security.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Krishna Chaitanya
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getAuthorities();
        return "hello";
    }

}
