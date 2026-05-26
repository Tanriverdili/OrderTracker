package com.ordertracker.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "webhook_logs")
public class WebhookLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventType;

    @Column(name = "status")
    private String status;

    private LocalDateTime receivedAt;
    private String responseMessage;

    @Column(name = "payload", columnDefinition = "TEXT")
    private String payload;

}
