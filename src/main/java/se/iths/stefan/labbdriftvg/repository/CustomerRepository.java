package se.iths.stefan.labbdriftvg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.stefan.labbdriftvg.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
