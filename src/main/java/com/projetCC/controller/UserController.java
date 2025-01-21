package com.projetCC.controller;

import com.projetCC.domain.User;
import com.projetCC.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository = new UserRepository();

    @GetMapping("user/{id:[0-9]+}")
    public ResponseEntity<User> readById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("user/{mail}")
    public ResponseEntity<User> readById(@PathVariable String mail) {
        try {
            return ResponseEntity.ok(userRepository.findByMail(mail));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
