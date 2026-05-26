package com.ordertracker.service;
import com.ordertracker.dto.OrderRequest;
import com.ordertracker.entity.OrderEntity;
import com.ordertracker.entity.UserEntity;
import com.ordertracker.enums.OrderStatus;
import com.ordertracker.repository.OrderRepository;
import com.ordertracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderEntity create(OrderRequest orderRequest,String email) {


    UserEntity user=userRepository.findByEmail(email)
            .orElseThrow(()->new RuntimeException("User not found"));
    OrderEntity orderEntity=new OrderEntity();
    orderEntity.setUser(user);
  orderEntity.setTotalPrice(orderRequest.getTotalPrice());
  orderEntity.setStatus(OrderStatus.PENDING);
  orderEntity.setOrderNumber(orderRequest.getOrderNumber());
  return orderRepository.save(orderEntity);
}
public List<OrderEntity> findAll() {
        return orderRepository.findAll();
}
public OrderEntity findById(long id) {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
}

public OrderEntity updateStatus(OrderStatus status, Long id) {
        OrderEntity order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
