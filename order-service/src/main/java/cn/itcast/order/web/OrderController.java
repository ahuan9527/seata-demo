package cn.itcast.order.web;

import cn.itcast.order.entity.Order;
import cn.itcast.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 虎哥
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody Order order){
        logger.info("order:"+order);
        Long orderId = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
