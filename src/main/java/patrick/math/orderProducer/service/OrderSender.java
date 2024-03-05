package patrick.math.orderProducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.math.orderProducer.model.OrderThings;
import patrick.math.orderProducer.repository.OrderRepository;

@Service
public class OrderSender {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OrderThings SaveOrder(OrderThings things) {
        return orderRepository.save(things);
    }

    public void send(OrderThings things) {
        rabbitTemplate.convertAndSend("ordersQueue", things);
    }
}

