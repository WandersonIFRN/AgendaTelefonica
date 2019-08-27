package com.agenda.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AgendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
