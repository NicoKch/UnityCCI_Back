package com.projetCC.controller;

import com.projetCC.domain.Stats;
import com.projetCC.repository.StatsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController implements IController {

    private final StatsRepository statsRepository = new StatsRepository();

    @GetMapping("user/{id:[0-9]+}/stats")
    public ResponseEntity<Stats> readById(@PathVariable int id) {
        try {
            ResponseEntity<Stats> stats =  ResponseEntity.ok(statsRepository.getPlayerStat(id));
            return stats;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
