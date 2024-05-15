package com.swe.recify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecifyApplication {

    private static final Logger log = LoggerFactory.getLogger(RecifyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RecifyApplication.class);
    }

}