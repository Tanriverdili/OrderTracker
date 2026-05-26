package com.ordertracker.dto;

import com.ordertracker.enums.OrderStatus;
import lombok.Data;

@Data
public class PaymentWebhookRequest {
    private Long orderId;
    private OrderStatus status;
}