package com.ordertracker.controller;
import com.ordertracker.dto.PaymentWebhookRequest;
import com.ordertracker.service.WebHookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webhooks")
@RequiredArgsConstructor
public class WebHookController {

    private final WebHookService webHookService;

    @PostMapping("/payment")
    public ResponseEntity<String> handlePaymentWebhook(
            @RequestBody PaymentWebhookRequest request
    ) {
        System.out.println("ORDER ID = " + request.getOrderId());
        System.out.println("STATUS = " + request.getStatus());

        webHookService.handlePaymentWebhook(
                request.getOrderId(),
                request.getStatus()
        );
        return ResponseEntity.ok("PAYMENT WEBHOOK RECEIVED");
    }
}

