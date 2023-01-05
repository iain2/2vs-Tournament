package com.vs.vs.tournament.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "rounds")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "numOfGames")
    private int numOfGames;

    @JsonBackReference
    @OneToMany(mappedBy = "round", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Game> games;

    @OneToMany
    @JsonIgnoreProperties({"game"})
    @JoinColumn(name = "winner_player_id", nullable = true)
    private List<Player> winners;
    @OneToMany
    @JoinColumn(name = "loser_player_id", nullable = true)
    private List<Player> losers;
    @Column(name = "finished")
    private boolean finished;

    public Round(String name, int numOfGames) {
        this.name = name;
        this.numOfGames = numOfGames;
        this.games = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.losers = new ArrayList<>();
        this.finished = false;
    }

    public Round() {

    }

    public void addGame(Game game) {
        this.games.add(game);
        game.setRound(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Player> getWinners() {
        return winners;
    }

    public void setWinners(List<Player> winners) {
        this.winners = winners;
    }

    public List<Player> getLosers() {
        return losers;
    }

    public void setLosers(List<Player> losers) {
        this.losers = losers;
    }

    public boolean isFinished() {
        if (this.numOfGames == this.winners.size()){
            this.finished = true;
        }
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void addWinner(Player winner){
        winners.add(winner);
    }

//    public void populateRounds(Tournament t, List<Player> players) {
//
//        int numGames = t.getRounds().size() * 2;
//        Game g1 = new Game("cat");
//        Game g2 = new Game("dog");
//
//        Collections.shuffle(players);

//        for (int i = 0; i < t.getRounds().size(); i++) {
//            g1 = new Game("cat");
//            g2 = new Game("dog");
//            t.getRounds().get(0).addGame(g1);
//            t.getRounds().get(0).addGame(g2);
//        }
   }

