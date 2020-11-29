package com.java.jungle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableJpaRepositories(basePackages = "com.java.jungle.repository")
@SpringBootApplication
public class JungleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JungleApplication.class, args);
    }

}

