package br.com.marques.userapi;

import br.com.marques.userapi.domain.User;
import br.com.marques.userapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class UserApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(Arrays.asList(
				new User(null, "João Marques", "joao@mail.com", "123", 20.0),
				new User(null, "Taiane Santos", "taiane@mail.com", "321", 25.0)
		));
	}
}
