package com.vs.vs.tournament.controller;


import com.vs.vs.tournament.models.TournamentData;
import com.vs.vs.tournament.repository.TournamentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TournamentDataController {

    @Autowired
    TournamentDataRepository tournamentDataRepository;

    @GetMapping(value = "/tournaments")
    public ResponseEntity<List<TournamentData>> getAllTD() {
        return new ResponseEntity<>(tournamentDataRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/tournaments")
    public ResponseEntity<TournamentData> postCreateTournament(@RequestBody TournamentData data){
        System.out.print(data.getName());
        TournamentData t = new TournamentData(data.getName(), data.getNumOfRounds(), data.getPlayers());
        tournamentDataRepository.save(t);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }
}
