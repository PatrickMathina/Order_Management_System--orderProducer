package patrick.math.orderProducer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import patrick.math.orderProducer.model.OrderThings;
import patrick.math.orderProducer.service.OrderSender;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderSender orderSender;

    public OrderController(OrderSender orderSender) {
        this.orderSender = orderSender;
    }

    @PostMapping
    public ResponseEntity<OrderThings> placeOrder(@RequestBody OrderThings orderThings) {
        orderThings.setOrder_status("PENDING");
        orderSender.send(orderThings);
        return ResponseEntity.ok(orderThings);
    }
}

