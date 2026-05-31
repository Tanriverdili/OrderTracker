package com.ordertracker.controller;
import com.ordertracker.dto.PaymentWebhookRequest;
import com.ordertracker.repository.WebHookLogRepository;
import com.ordertracker.service.WebHookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/webhooks")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class WebhookController {
    private final WebHookService webHookService;
    private final WebHookLogRepository webHookLogRepository;

    @PostMapping("/payment")
    public String paymentWebhook(@Valid
            @RequestBody PaymentWebhookRequest request) throws Exception {
        String payload = new ObjectMapper()
                .writeValueAsString(request);

        webHookService.handlePaymentWebhook(
                request.getOrderId(),
                request.getStatus(),
                payload
        );
        return "SUCCESS";
    }
    @PostMapping("/shipment")
    public String shipmentWebhook(
            @RequestBody PaymentWebhookRequest request) throws Exception {
        String payload = new ObjectMapper()
                .writeValueAsString(request);

        webHookService.handleShipmentWebhook(
                request.getOrderId(),
                request.getStatus(),
                payload
        );
        return "SHIPMENT UPDATED";
    }
    @GetMapping("/stats")
    public Map<String, Object> getWebhookStats() {
        long success = webHookLogRepository.countByStatus("SUCCESS");
        long failed = webHookLogRepository.countByStatus("FAILED");
        long total = webHookLogRepository.count();

        Map<String, Object> stats = new HashMap<>();
        stats.put("success", success);
        stats.put("failed", failed);
        stats.put("total", total);
        return stats;
    }
}










































