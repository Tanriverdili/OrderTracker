package com.ordertracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class OrderTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTrackerApplication.class, args);
    }

}
