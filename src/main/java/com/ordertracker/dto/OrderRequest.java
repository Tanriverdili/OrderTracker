package com.ordertracker.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String orderNumber;
   private double totalPrice;
}
