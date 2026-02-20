package se.iths.stefan.labbdriftvg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.stefan.labbdriftvg.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
