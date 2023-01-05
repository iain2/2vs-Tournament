package com.vs.vs.tournament.controller;


import com.vs.vs.tournament.models.*;
import com.vs.vs.tournament.repository.GameRepository;



import com.vs.vs.tournament.models.TournamentData;

import com.vs.vs.tournament.repository.RoundRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class TournamentController {



    @Autowired
    RoundRepository roundRepository;

    @Autowired
    GameRepository gameRepository;




//    @PostMapping(value = "/tournament")
//    public ResponseEntity<Tournament> postTournament(@RequestBody TournamentData data){
        // edited tournament class 16/08 which has stopped this
//        Tournament t = new Tournament(data.getName(), data.getNumOfRounds());
//        t.createTournament(t, data.getPlayers());
//        tournamentRepository.save(t);
//        return new ResponseEntity<>(t, HttpStatus.CREATED);
//    }

//    @PostMapping(value = "/tournament/{id}")
//    public ResponseEntity<Tournament> deletePirate(@PathVariable Long id, @RequestBody Round round) {
//        Tournament foundT = tournamentRepository.getOne(id);
//        Round foundR = roundRepository.getOne(round.getId());
//        List<Game> games = gameRepository.findGamesByRoundId(round.getId());
//
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
}
