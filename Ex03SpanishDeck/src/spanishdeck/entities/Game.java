package spanishdeck.entities;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Deck deck;
    private List<Player> players;

    public Game() {
        deck = new Deck();
        players = new ArrayList<>();
    }

    public void createGame(int players) {
        deck.shuffle();
        generatePlayers(players);
    }
    
    /**
     * Creates de specified number of players to start the game.
     * @param number of players.
     */
    private void generatePlayers(int num){
        for (int i = 0; i < num; i++) {
            players.add(new Player());
        }
    }

    public void round() {
    }
}
