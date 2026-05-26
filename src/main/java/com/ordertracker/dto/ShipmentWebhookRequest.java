package com.ordertracker.dto;


import lombok.Data;

@Data
public class ShipmentWebhookRequest {
    private Long orderId;
    private String status;
    private String payload;
}