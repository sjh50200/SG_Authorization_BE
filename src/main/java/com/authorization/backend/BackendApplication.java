package com.authorization.backend;

import com.authorization.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.authorization.backend.Enum.AccountRole;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("성종현", "12345", AccountRole.USER);
        accountRepository.save(user);
    }
}
