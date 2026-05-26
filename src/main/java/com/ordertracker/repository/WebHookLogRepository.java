package com.ordertracker.repository;
import com.ordertracker.entity.WebhookLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebHookLogRepository extends JpaRepository<WebhookLogEntity,Long> {
}
