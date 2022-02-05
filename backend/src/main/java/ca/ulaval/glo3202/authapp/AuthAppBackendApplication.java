package ca.ulaval.glo3202.authapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class AuthAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthAppBackendApplication.class, args);
	}

}
