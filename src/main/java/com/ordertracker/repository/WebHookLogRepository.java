package com.ordertracker.repository;
import com.ordertracker.entity.WebhookLogEntity;
import com.ordertracker.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
//public interface WebHookLogRepository extends JpaRepository<WebhookLogEntity, Long> {
//
//    List<WebhookLogEntity> findByStatus(String status);
//
//    List<WebhookLogEntity> findByDate(String date);
//
////    List<WebhookLogEntity> findByStatusAndDate(String status, String date);
//    List<WebhookLogEntity> findByCreatedAtBetween(
//            LocalDateTime start,
//            LocalDateTime end
//    );
//
public interface WebHookLogRepository extends JpaRepository<WebhookLogEntity, Long> {

    List<WebhookLogEntity> findByStatus(String status);
//
//    List<WebhookLogEntity> findByCreatedAtBetween(
//            LocalDateTime start,
//            LocalDateTime end
//    );
//
//
//
//
//
//}


    List<WebhookLogEntity> findByStatusIgnoreCase(String status);

    //        List<WebhookLogEntity> findByCreatedAtBetween(
//                LocalDateTime start,
//                LocalDateTime end
//        );
    List<WebhookLogEntity> findByReceivedAtBetween(
            LocalDateTime start,
            LocalDateTime end
    );




    List<WebhookLogEntity> findByStatusIgnoreCaseAndReceivedAtBetween(
            String status,
            LocalDateTime start,
            LocalDateTime end
    );

//    long countByStatus(String status);
long countByStatus(String status);



}


