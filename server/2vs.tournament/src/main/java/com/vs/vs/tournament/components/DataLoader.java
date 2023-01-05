package com.vs.vs.tournament.components;
import com.vs.vs.tournament.models.Player;
import com.vs.vs.tournament.repository.GameRepository;
import com.vs.vs.tournament.repository.PlayerRepository;
import com.vs.vs.tournament.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    RoundRepository roundRepository;



    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

    Player player1 = new Player("Gary");
    playerRepository.save(player1);
    Player player2 = new Player("Mark");
    playerRepository.save(player2);
    Player player3 = new Player("Harry");
    playerRepository.save(player3);
    Player player4 = new Player("Larry");
    playerRepository.save(player4);
    Player player5 = new Player("Mary");
    playerRepository.save(player5);
    Player player6 = new Player("Neil");
    playerRepository.save(player6);
    Player player7 = new Player("Parry");
    playerRepository.save(player7);
    Player player8 = new Player("Katy");
    playerRepository.save(player8);

    }
}
