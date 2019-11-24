package com.diary.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DiaryBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryBackEndApplication.class, args);
    }

}
