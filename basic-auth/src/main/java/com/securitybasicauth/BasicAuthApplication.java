package com.securitybasicauth;

import com.securitybasicauth.dto.CreateUserRequest;
import com.securitybasicauth.model.Role;
import com.securitybasicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {


	private final UserService userService;



	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("apo")
				.username("apo")
				.password("3636")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);
		CreateUserRequest request1 = CreateUserRequest.builder()
				.name("umut")
				.username("umut")
				.password("5353")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request1);
		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("yunus")
				.username("yunus")
				.password("7878")
				.authorities(Set.of(Role.ROLE_YNS))
				.build();
		userService.createUser(request1);
	}

}
