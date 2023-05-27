package com.chic.qh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.chic"})
public class QhApplication {

    public static void main(String[] args) {
        SpringApplication.run(QhApplication.class, args);
    }

}
