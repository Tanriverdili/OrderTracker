package com.ordertracker.repository;
import com.ordertracker.entity.OrderEntity;
import com.ordertracker.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    long countByStatus(OrderStatus status);
}
