package fr.formation.jwtsecuredserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Disable security:
// @EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class JwtSecuredServerApplication {

    public static void main(String[] args) {
	SpringApplication.run(JwtSecuredServerApplication.class, args);
    }
}
