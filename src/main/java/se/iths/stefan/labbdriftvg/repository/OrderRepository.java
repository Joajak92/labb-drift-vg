package se.iths.stefan.labbdriftvg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.stefan.labbdriftvg.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {


}
