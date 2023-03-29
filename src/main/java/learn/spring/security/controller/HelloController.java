package learn.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Krishna Chaitanya Surapaneni
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    String sayHello() {
        return "hello!";
    }
}
