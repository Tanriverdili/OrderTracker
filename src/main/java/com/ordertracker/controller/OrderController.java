package com.ordertracker.controller;
import com.ordertracker.dto.OrderRequest;
import com.ordertracker.entity.OrderEntity;
import com.ordertracker.enums.OrderStatus;
import com.ordertracker.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderEntity create(@RequestBody OrderRequest orderRequest, Authentication authentication) {
return orderService.create(orderRequest, authentication.getName());


}
@GetMapping
public List<OrderEntity> findAll() {
        return orderService.findAll();
}
@GetMapping("/{id}")
    public OrderEntity findById(@PathVariable Long id) {
        return orderService.findById(id);
}
@PutMapping("/{id}/status")
public OrderEntity updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return orderService.updateStatus(status, id);
}
@DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);

}

}

