//package com.vs.vs.tournament.models;
//
//
//import org.hibernate.annotations.Cascade;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//@Entity
//@Table(name = "tournament")
//public class Tournament {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    @OneToMany
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<Round> rounds;
//
//    @OneToMany
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<Player> players;
//    private int noOfRounds;
//
//    public Tournament(String name, int noOfRounds, List<Player> players) {
//        this.name = name;
//        this.noOfRounds = noOfRounds;
//        this.players = players;
//    }
//    public Tournament(){}
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Round> getRounds() {
//        return rounds;
//    }
//
//    public void setRounds(ArrayList<Round> rounds) {
//        this.rounds = rounds;
//    }
//
//    public int getNoOfRounds() {
//        return noOfRounds;
//    }
//
//    public void setNoOfRounds(int noOfRounds) {
//        this.noOfRounds = noOfRounds;
//    }
//
//    public void setRounds(List<Round> rounds) {
//        this.rounds = rounds;
//    }
//
//    public List<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }
//
//    public void createTournament(Tournament t, List<Player> players) {
//        int counter = t.getNoOfRounds();
//        ArrayList<Round> rounds = new ArrayList<>();
//
//        Collections.shuffle(players);
//
//        for (int i = 0; i < counter; i++) {
//            Round round = new Round("", i + 1);
//            rounds.add(round);
//        }
//
//        t.setRounds(rounds);
//
//        if (t.getRounds().size() == 4) {
//            // Note to myself (Brian) you need to finish this bit
//            // unsure if coming back to use this code 12/8
//            t.getRounds().get(0).setName("Final");
//            t.getRounds().get(1).setName("Semi-Final");
//            t.getRounds().get(2).setName("Quarter-Final");
//            t.getRounds().get(3).setName("First Round");
//            t.setNoOfRounds(4);
//        }
//
//        if (t.getRounds().size() == 3) {
//            if (players.size() != 8) return;
//            t.getRounds().get(0).setName("Final");
//            t.getRounds().get(1).setName("Semi-Final");
//            t.getRounds().get(2).setName("Quarter-Final");
//            Game g1 = new Game("bear");
//            Game g2 = new Game("river");
//            Game g3 = new Game("fish");
//            Game g4 = new Game("sausage");
//            g1.setPlayer1(players.get(0));
//            g1.setPlayer2(players.get(1));
//            g2.setPlayer1(players.get(2));
//            g2.setPlayer2(players.get(3));
//            g3.setPlayer1(players.get(4));
//            g3.setPlayer2(players.get(5));
//            g4.setPlayer1(players.get(6));
//            g4.setPlayer2(players.get(7));
//            t.getRounds().get(2).addGame(g1);
//            t.getRounds().get(2).addGame(g2);
//            t.getRounds().get(2).addGame(g3);
//            t.getRounds().get(2).addGame(g4);
//            t.setNoOfRounds(3);
//        }
//
//        if (t.getRounds().size() == 2) {
//            if (players.size() != 4) return;
//            t.getRounds().get(0).setName("Final");
//            t.getRounds().get(1).setName("Semi-Final");
//            t.setNoOfRounds(2);
//            Game g2 = new Game("river");
//            Game g3 = new Game("fish");
//            g2.setPlayer1(players.get(0));
//            g2.setPlayer2(players.get(1));
//            g3.setPlayer1(players.get(2));
//            g3.setPlayer2(players.get(3));
//            t.getRounds().get(1).addGame(g2);
//            t.getRounds().get(1).addGame(g3);
//        }
//
//        if (t.getRounds().size() == 1) {
//            if (players.size() != 2) return;
//            t.setNoOfRounds(1);
//            t.getRounds().get(0).setName("Final");
//            Game g1 = new Game("cat");
//            g1.setPlayer1(players.get(0));
//            g1.setPlayer2(players.get(1));
//            t.getRounds().get(0).addGame(g1);
//        }
//
//    }
//}
