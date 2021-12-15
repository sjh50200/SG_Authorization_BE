package com.authorization.backend;

import com.authorization.backend.Entity.User;
import com.authorization.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements Runnable{
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run() {
        User user = new User("성종현", "12345");
        userRepository.save(user);
    }
}
