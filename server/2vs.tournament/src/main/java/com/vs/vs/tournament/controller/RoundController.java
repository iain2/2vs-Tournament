package com.vs.vs.tournament.controller;

import com.vs.vs.tournament.models.Round;

import com.vs.vs.tournament.repository.RoundRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RoundController {

    @Autowired
    RoundRepository roundRepository;

    @GetMapping(value = "/rounds")
    public ResponseEntity<List<Round>> getAllRounds() {
        return new ResponseEntity<>(roundRepository.findAll(), HttpStatus.OK);
    }
}
