package learn.spring.security.repository;

import learn.spring.security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("""
            SELECT c FROM Customer c WHERE c.name = :username
    """)
    Optional<Customer> findCustomerByUsername(String username);

}