package br.com.pontedeacesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PontedeacessoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontedeacessoApplication.class, args);
	}

}
