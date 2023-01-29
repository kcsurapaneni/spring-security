package learn.spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author Krishna Chaitanya
 */
@Entity
@Setter
@Getter
public class Role {

    @Id
    private int id;
    private String name;
    private boolean isActive;

    @ManyToMany(
//            fetch = FetchType.EAGER,
            mappedBy = "roles"
    )
    private Set<Customer> customers;

}
