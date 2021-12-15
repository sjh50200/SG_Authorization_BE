package com.authorization.backend.Controller;

import com.authorization.backend.Entity.User;
import com.authorization.backend.Repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/ss", method= RequestMethod.POST )
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getId() + userDTO.getPassword());
        User user = new User(userDTO.getId(), userDTO.getPassword());
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Getter
    @Setter
    private static class UserDTO {
        private String id;
        private String password;
    }
}
