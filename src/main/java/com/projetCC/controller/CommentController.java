package com.projetCC.controller;

import com.projetCC.domain.Comment;
import com.projetCC.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController implements IController{

    private final CommentRepository commentRepository = new CommentRepository();

    @GetMapping("comments")
    public ResponseEntity<List<Comment>> readAll() {
        try {
            return ResponseEntity.ok(commentRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("comments")
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        try {
            return ResponseEntity.ok(commentRepository.save(comment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
