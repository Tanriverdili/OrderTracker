package com.ordertracker.controller;
import com.ordertracker.entity.WebhookLogEntity;
import com.ordertracker.enums.OrderStatus;
import com.ordertracker.repository.OrderRepository;
import com.ordertracker.repository.WebHookLogRepository;
import com.ordertracker.service.WebHookService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final OrderRepository orderRepository;
    private final WebHookLogRepository webHookLogRepository;
    private final WebHookService webhookService;

    @GetMapping("/webhook_logs")
    public List<WebhookLogEntity> getLogs(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String date) {
        return webhookService.getLogs(status, date);
    }
    @GetMapping("/webhook-logs")
    public Page<WebhookLogEntity> getLogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return webhookService.getLogs(page, size);
    }
    @GetMapping("/order-stats")
    public Map<String, Object> getOrderStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalOrders", orderRepository.count());
        stats.put("paidOrders", orderRepository.countByStatus(OrderStatus.PAID));
        stats.put("shippedOrders", orderRepository.countByStatus(OrderStatus.SHIPPED));
        return stats;
    }
    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        return webhookService.getDashboardData();
    }
    @GetMapping("/webhook-logs/export")
    public void exportLogs(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition",
                "attachment; filename=webhook-logs.csv");

        List<WebhookLogEntity> logs = webHookLogRepository.findAll();

        PrintWriter writer = response.getWriter();

        writer.println("ID,ORDER_ID,EVENT_TYPE,STATUS,RETRY_COUNT,RECEIVED_AT,RESPONSE_MESSAGE");

        for (WebhookLogEntity log : logs) {
            writer.println(
                    log.getId() + "," +
                            log.getOrderId() + "," +
                            log.getEventType() + "," +
                            log.getStatus() + "," +
                            log.getRetryCount() + "," +
                            log.getReceivedAt() + "," +
                            log.getResponseMessage()
            );
        }
        writer.flush();
        writer.close();
    }
}









