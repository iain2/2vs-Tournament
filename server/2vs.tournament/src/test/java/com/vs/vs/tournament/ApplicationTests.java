//package com.vs.vs.tournament;
//
//import com.vs.vs.tournament.models.Game;
//import com.vs.vs.tournament.models.Player;
//import com.vs.vs.tournament.models.Round;
//import com.vs.vs.tournament.models.Tournament;
//import com.vs.vs.tournament.repository.GameRepository;
//import com.vs.vs.tournament.repository.PlayerRepository;
//import com.vs.vs.tournament.repository.RoundRepository;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ApplicationTests {
//
//	@Autowired
//	PlayerRepository playerRepository;
//	@Autowired
//	GameRepository gameRepository;
//
//	@Autowired
//	RoundRepository roundRepository;
//
//	@Test
//	void contextLoads() {
//	}
//
////	@Test
////	public void gameCanAddPlayers() {
////		Game game1 = gameRepository.findById(1l).orElse(null);
////		List<Player> players = playerRespository.findAll();
////		assert game1 != null;
////		game1.setPlayer1(players.get(0));
////		game1.setPlayer2(players.get(1));
////		assertNotNull(game1.getPlayer1());
////		assertNotNull(game1.getPlayer2());
////	}
//
//	@Test
//	public void canAddGamesToRound(){
//		Round round1 = new Round("test", 2);
//		Game game1 = new Game("game1");
//		Game game2 = new Game("game2");
//		round1.addGame(game1);
//		round1.addGame(game2);
//		assertEquals(2, round1.getGames().size());
//	}
//
//	@Test
//	public void canCreateRoundsFromTournament() {
//		Tournament tournament = new Tournament("Test Tournament", 1);
//		List<Player> players = new ArrayList<>();
//		Player player1 = new Player("Brian");
//		Player player2 = new Player("Iain");
//		players.add(player1);
//		players.add(player2);
//		tournament.createTournament(tournament, players);
//		assertEquals(1, tournament.getRounds().size());
//	}
//
//	@Test
//	public void canCreateTournamentAndGetRoundName() {
//		Tournament tournament = new Tournament("Test Tournament", 1);
//		List<Player> players = new ArrayList<>();
//		Player player1 = new Player("Brian");
//		Player player2 = new Player("Iain");
//		players.add(player1);
//		players.add(player2);
//		tournament.createTournament(tournament, players);
//		assertEquals("Final", tournament.getRounds().get(0).getName());
//	}
//
//
//	@Test
//	public void roundCanAddGame() {
//		Round round = new Round();
//		Game game = new Game("Horse");
//		List<Game> games = new ArrayList<>();
//		games.add(game);
//		round.setGames(games);
//		assertEquals("Horse", round.getGames().get(0).getName());
//	}
//
//	@Test
//	public void canCreateTournamentAndGetGamesFromFirstRound() {
//		Tournament tournament = new Tournament("Test Tournament", 1);
//		List<Player> players = new ArrayList<>();
//		Player player1 = new Player("Brian");
//		Player player2 = new Player("Iain");
//		players.add(player1);
//		players.add(player2);
//		tournament.createTournament(tournament, players);
//		assertNotNull(tournament.getRounds().get(0).getGames());
//	}
//
//	@Test
//	public void canCreateTournamentAndGetGamesFromSecondRound() {
//		Tournament t1 = new Tournament("Second Test Tournament", 2);
//		List<Player> players = new ArrayList<>();
//		Player p1 = new Player("Brian");
//		Player p2 = new Player("Iain");
//		Player p3 = new Player("Ken");
//		Player p4 = new Player("Ally");
//		players.add(p1);
//		players.add(p2);
//		players.add(p3);
//		players.add(p4);
//		t1.createTournament(t1, players);
//		assertEquals("river", t1.getRounds().get(1).getGames().get(0).getName());
//	}
//
//	@Test
//	public void canCreateTournamentAndGetPlayersFromFinal() {
//		Tournament tournament = new Tournament("Test Tournament", 1);
//		List<Player> players = new ArrayList<>();
//		Player player1 = new Player("Brian");
//		Player player2 = new Player("Iain");
//		players.add(player1);
//		players.add(player2);
//		tournament.createTournament(tournament, players);
//		assertEquals("Brian", tournament.getRounds().get(0).getGames().get(0).getPlayer1().getName());
//	}
//
//
//
//	@Test
//	public void ratingChangeAfterWin(){
//		Player player1 = new Player("Brian");
//		Player player2 = new Player("Iain");
//		Game game1 = new Game("test");
//		game1.setPlayer1(player1);
//		game1.setPlayer2(player2);
//		game1.setWinner(player1);
//		assertEquals(1216, player1.getRating());
//	}
//
//}
