package com.ricardoclaro.colegial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tinylog.Logger;

import java.util.Scanner;

@SpringBootApplication
public class ColegialApplication {

    public static void main(String[] args) {
        try {
        SpringApplication.run(ColegialApplication.class, args);

        } catch (Exception e) {
            Logger.warn("AppWarn: ", e);
            Logger.error("AppError: ", e);

        }
    }
}



