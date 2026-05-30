package com.ordertracker.dto;
import com.ordertracker.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class PaymentWebhookRequest {
    @NotNull(message = "orderId must not be null")
    private Long orderId;
    @NotNull(message = "status must not be null")
    private OrderStatus status;
}