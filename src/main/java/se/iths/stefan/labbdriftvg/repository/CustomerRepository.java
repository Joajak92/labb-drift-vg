package se.iths.stefan.labbdriftvg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.stefan.labbdriftvg.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
