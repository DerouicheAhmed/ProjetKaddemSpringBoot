package com.example.springprojetkaddem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan(basePackages = {"tn.esprit.kaddem.controller","tn.esprit.kaddem.services"})
//@EnableJpaRepositories(basePackages = "tn.esprit.kaddem.respository")
//@EntityScan (basePackages = "tn.esprit.kaddem.entity")
@SpringBootApplication
public class SpringProjetKaddemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjetKaddemApplication.class, args);
    }

}
