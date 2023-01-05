package com.vs.vs.tournament.controller;

import com.vs.vs.tournament.models.Player;

import com.vs.vs.tournament.models.TournamentData;
import com.vs.vs.tournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vs.vs.tournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping(value = "/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/players/{id}")
    public ResponseEntity getPlayer(@PathVariable Long id){
        return new ResponseEntity<>(playerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/players")
    public ResponseEntity<Player> postPlayer(@RequestBody Player player){
        playerRepository.save(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping(value = "/players/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player updatePlayer = playerRepository.findById(player.getId()).orElse(null);
        updatePlayer.setRating(player.getRating());
        updatePlayer.setGame(player.getGame());
        updatePlayer.setName(player.getName());
        playerRepository.save(updatePlayer);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/players/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable Long id) {
        Player found = playerRepository.findById(id).orElse(null);
        playerRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
