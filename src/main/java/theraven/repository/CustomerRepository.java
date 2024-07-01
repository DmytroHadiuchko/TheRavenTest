package theraven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import theraven.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
