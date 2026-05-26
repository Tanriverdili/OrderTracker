package com.ordertracker.service;

import com.ordertracker.dto.PaymentWebhookRequest;
import com.ordertracker.entity.OrderEntity;
import com.ordertracker.enums.OrderStatus;
import com.ordertracker.repository.OrderRepository;
import com.ordertracker.repository.WebHookLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
























































//@Service
//@RequiredArgsConstructor
//public class WebHookService {
//
//    private final OrderRepository orderRepository;
//    private final WebHookLogRepository webhookLogRepository;
//
//
//    public void handlePaymentWebhook(
//            Long orderId,
//            OrderStatus status,
//            String payload
//    ) {
//
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        order.setStatus(status);
//
//        orderRepository.save(order);
//
//        System.out.println("DB updated");
//    }
//}

//
//
//    public void handleShipmentWebhook(Long orderId, OrderStatus status, String payload) {
//
//        if (orderId == null || status == null) {
//            throw new RuntimeException("orderId və status boş ola bilməz");
//        }
//
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order tapılmadı"));
//
//        order.setStatus(status);
//        orderRepository.save(order);
//
//        WebhookLogEntity log = new WebhookLogEntity();
//        log.setEventType("shipment");
//        log.setPayload(payload);
//        log.setStatus(status.name());
//
//        webhookLogRepository.save(log);
//    }
//}
//
//





















































@Service
public class WebHookService {

    private final OrderRepository orderRepository;

    public WebHookService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
//
//    @Transactional
//    public void handlePaymentWebhook(Long orderId, OrderStatus orderStatus, String status) {
//
//        if (orderId == null) {
//            throw new IllegalArgumentException("orderId is null");
//        }
//
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        order.setStatus(OrderStatus.valueOf(status));
//
//        orderRepository.save(order);
//    }
//}


















































//
//
//    public void handlePaymentWebhook(Long orderId, OrderStatus status) {
//
//        System.out.println("ORDER ID = " + orderId);
//        System.out.println("STATUS = " + status);
//
//        if (orderId == null) {
//            throw new RuntimeException("orderId is null");
//        }
//
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
//
//        order.setStatus(status);
//
//        orderRepository.save(order);
//
//        System.out.println("UPDATED SUCCESSFULLY");
//    }
//
//}

//
//    public void handlePaymentWebhook(Long orderId, OrderStatus status) {
//
//        if (orderId == null) {
//            throw new RuntimeException("Invalid webhook: orderId is null");
//        }
//
//        OrderEntity order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        order.setStatus(status);
//        orderRepository.save(order);
//    }
//}





















    public void handlePaymentWebhook(Long orderId, OrderStatus status) {

        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        orderRepository.save(order);
    }
}
































//@Service
//@RequiredArgsConstructor
//public class WebHookService {
//
//    private final OrderRepository orderRepository;
//    private final WebHookLogRepository webHookLogRepository;
//    private final EmailService emailService;
//
//    public void handlePaymentWebhook(
//            Long orderId,
//            OrderStatus orderStatus,
//            String payload
//    ) {
//
//        WebhookLogEntity webhookLogEntity =
//                new WebhookLogEntity();
//
//        webhookLogEntity.setEventType("payment");
//        webhookLogEntity.setPayload(payload);
//        webhookLogEntity.setReceivedAt(LocalDateTime.now());
//
//        try {
//
//            OrderEntity orderEntity =
//                    orderRepository.findById(orderId)
//                            .orElseThrow(() ->
//                                    new RuntimeException("Order not found"));
//
//            // STATUS UPDATE
//            orderEntity.setStatus(orderStatus);
//
//            orderRepository.save(orderEntity);
//
//            // EMAIL SEND
//            emailService.sendEmail(
//                    orderEntity.getUser().getEmail(),
//                    "Order Updated",
//                    "Your order status is now: "
//                            + orderStatus
//            );
//
//            webhookLogEntity.setStatus("SUCCESS");
//
//            webhookLogEntity.setResponseMessage(
//                    "Order processed successfully"
//            );
//
//        } catch (Exception e) {
//
//            webhookLogEntity.setStatus("FAILED");
//
//            webhookLogEntity.setResponseMessage(
//                    e.getMessage()
//            );
//        }
//
//        webHookLogRepository.save(webhookLogEntity);
//    }
//}





































































//@Service
//@RequiredArgsConstructor
//public class WebHookService {
//
//    private final OrderRepository orderRepository;
//    private final WebHookLogRepository webHookLogRepository;
//    private final EmailService emailService;
//
//
//    public void handlePaymentWebhook(
//            Long orderId,
//            OrderStatus status,
//            String payload
//    ) {
//
//        WebhookLogEntity log = new WebhookLogEntity();
//
//        log.setEventType("PAYMENT");
//        log.setPayload(payload);
//        log.setReceivedAt(LocalDateTime.now());
//
//        try {
//
//            OrderEntity order = orderRepository.findById(orderId)
//                    .orElseThrow(() ->
//                            new RuntimeException("Order not found"));
//
//            order.setStatus(status);
//
//            orderRepository.save(order);
//
//            // EMAIL SEND
//            emailService.sendEmail(
//                    orderEntity.getUser().getEmail(),
//                    "Order Updated",
//                    "Your order status is now: "
//                            + orderStatus
//            );
//
//            log.setStatus("SUCCESS");
//            log.setResponseMessage("Payment processed");
//
//
//        } catch (Exception e) {
//
//            log.setStatus("FAILED");
//            log.setResponseMessage(e.getMessage());
//
//            e.printStackTrace();
//        }
//
//        webHookLogRepository.save(log);
//    }
//}
//
//

























































//@Service
//@RequiredArgsConstructor
//public class WebHookService {
//    private final WebHookLogRepository webHookLogRepository;
//
////    private final WebHookLogRepository webhookLogRepository;
//
//    @Transactional
//    public void logWebhook(String eventType, String status, String payload) {
//
//        WebhookLogEntity log = new WebhookLogEntity();
//
//        log.setEventType(eventType);
//        log.setStatus(status);
//        log.setPayload(payload);
//        log.setReceivedAt(LocalDateTime.now());
//        log.setResponseMessage("OK");
//
//        webHookLogRepository.save(log);
//    }
//}















































































//@Service
//@RequiredArgsConstructor
//public class WebHookService {
//    private final WebHookLogRepository webHookLogRepository;
//    private final OrderRepository orderRepository;
//    @Transactional
//    public void handlePaymentWebHook(PaymentWebhookRequest request) {
//
//        Long orderId = request.getOrderId();
//
//        // 🔥 BURADA BAŞLAYIR
//        String statusStr = request.getStatus();
//
//        if (statusStr == null || statusStr.trim().isEmpty()) {
//            throw new IllegalArgumentException("Invalid status: " + statusStr);
//        }
//
//        OrderStatus orderStatus = OrderStatus.valueOf(
//                statusStr.trim().toUpperCase()
//        );
//        // 🔥 BURADA BITIR
//
//        String payload = request.getPayload();
//
//        System.out.println("ORDER ID FROM REQUEST = " + orderId);
//
//        WebhookLogEntity log = new WebhookLogEntity();
//        log.setEventType("payment");
//        log.setStatus("RECEIVED");
//        log.setPayload(payload);
//        log.setReceivedAt(LocalDateTime.now());
////
////    @Transactional
////    public void handlePaymentWebHook(Long orderId, OrderStatus orderStatus, String payload) {
////        System.out.println("ORDER ID FROM REQUEST = " + orderId);
////
////        WebhookLogEntity log = new WebhookLogEntity();
////        log.setEventType("payment");
////        log.setStatus("RECEIVED");
////        log.setPayload(payload);
////        log.setReceivedAt(LocalDateTime.now());
//
//        try {
//
//            if (orderId == null) {
//                throw new IllegalArgumentException("orderId is null");
//            }
//
//            OrderEntity orderEntity = orderRepository.findById(orderId)
//                    .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
//
//            orderEntity.setStatus(orderStatus);
//            orderRepository.save(orderEntity);
//
//            log.setResponseMessage("Order successfully processed");
//            log.setStatus("SUCCESS");
//
//        } catch (Exception e) {
//            log.setResponseMessage(e.getMessage());
//            log.setStatus("FAILED");
//        }
//
//        webHookLogRepository.save(log);
//    }
//
//    public void handleShipmentWebHook(Long orderId, OrderStatus orderStatus, String payload) {
//
//        WebhookLogEntity log = new WebhookLogEntity();
//        log.setEventType("shipment");
//        log.setStatus("RECEIVED");
//        log.setPayload(payload);
//        log.setReceivedAt(LocalDateTime.now());
//
//        try {
//
//            if (orderId == null) {
//                throw new IllegalArgumentException("orderId is null");
//            }
//
//            OrderEntity orderEntity = orderRepository.findById(orderId)
//                    .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
//
//            orderEntity.setStatus(orderStatus);
//            orderRepository.save(orderEntity);
//
//            log.setResponseMessage("Shipment successfully processed");
//            log.setStatus("SUCCESS");
//
//        } catch (Exception e) {
//            log.setResponseMessage(e.getMessage());
//            log.setStatus("FAILED");
//        }
//
//        webHookLogRepository.save(log);
//    }
//
//
//}
//






















































































//    public void handlePaymentWebHook(Long orderId, OrderStatus orderStatus,String payload) {
//        WebhookLogEntity webhookLogEntity = new WebhookLogEntity();
//        webhookLogEntity.setEventType("payment");
//        webhookLogEntity.setStatus("RECEIVED");
//        webhookLogEntity.setPayload(payload);
//        webhookLogEntity.setReceivedAt(LocalDateTime.now());
//
//    try{
//        OrderEntity orderEntity = orderRepository.findById(orderId)
//                .orElseThrow(()->new RuntimeException("Order not found"));
//        orderEntity.setStatus(orderStatus);
//        orderRepository.save(orderEntity);
//
//       webhookLogEntity.setResponseMessage("Order successfully processed");
//       webhookLogEntity.setStatus("SUCCESS");
//    }
//    catch(Exception e){
//        e.printStackTrace();
//        webhookLogEntity.setResponseMessage(e.getMessage()); // ÇOX VACİB
//        webhookLogEntity.setStatus("FAILED");
//
//    }
//    webHookLogRepository.save(webhookLogEntity);
//
//    }
//    public void handleShipmentWebHook(Long orderId, OrderStatus orderStatus,String payload) {
//
//        WebhookLogEntity webhookLogEntity = new WebhookLogEntity();
//        webhookLogEntity.setEventType("shipment");
//        webhookLogEntity.setStatus("RECEIVED");
//        webhookLogEntity.setPayload(payload);
//        webhookLogEntity.setReceivedAt(LocalDateTime.now());
//
//        try {
//           OrderEntity orderEntity=orderRepository.findById(orderId)
//                   .orElseThrow(()->new RuntimeException("Order not found"));
//           orderEntity.setStatus(orderStatus);
//           orderRepository.save(orderEntity);
//           webhookLogEntity.setResponseMessage("Shipment successfully processed");
//           webhookLogEntity.setStatus("SUCCESS");
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            webhookLogEntity.setResponseMessage(e.getMessage()); // ÇOX VACİB
//            webhookLogEntity.setStatus("FAILED");
//
//        }
//
//        webHookLogRepository.save(webhookLogEntity);
//    }
//
//}
