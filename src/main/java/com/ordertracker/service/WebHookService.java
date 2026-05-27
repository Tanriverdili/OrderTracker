package com.ordertracker.service;

import com.ordertracker.dto.PaymentWebhookRequest;
import com.ordertracker.entity.OrderEntity;
import com.ordertracker.enums.OrderStatus;
import com.ordertracker.repository.OrderRepository;
import com.ordertracker.repository.WebHookLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WebHookService {

    private final OrderRepository orderRepository;

    public WebHookService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

  public void handlePaymentWebhook(Long orderId, OrderStatus status) {

        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        orderRepository.save(order);
    }
}











































































