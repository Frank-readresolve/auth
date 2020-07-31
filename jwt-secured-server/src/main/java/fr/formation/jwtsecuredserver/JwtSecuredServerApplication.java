package fr.formation.jwtsecuredserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
// Disable security:
// @EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class JwtSecuredServerApplication {

    public static void main(String[] args) {
	SpringApplication.run(JwtSecuredServerApplication.class, args);
    }

    /**
     * The password encoder bean for the application.
     *
     * @return a password encoder
     */
    @Bean
    protected PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }
}
