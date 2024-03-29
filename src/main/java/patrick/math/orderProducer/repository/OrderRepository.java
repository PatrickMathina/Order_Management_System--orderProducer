package patrick.math.orderProducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patrick.math.orderProducer.model.OrderThings;

@Repository
public interface OrderRepository extends JpaRepository<OrderThings, String> {

}
