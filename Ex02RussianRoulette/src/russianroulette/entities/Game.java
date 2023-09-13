
package russianroulette.entities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private Set<Player> players;

    private Revolver revolver;

    public Game(HashSet<Player> players, Revolver revolver) {
        this.players = players;
        this.revolver = revolver;
    }

    public Game() {
        players = new HashSet<>();
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Revolver getRevolver() {
        return revolver;
    }

    public void setRevolver(Revolver revolver) {
        this.revolver = revolver;
    }
    
    public void newGame(Set<Player> players){
        this.players = players;
        this.revolver = new Revolver();
    }
    
    /**
     * Each round consists of a player shutting to himself/herself and returns
     * true if the player is wet, in order to continue playing if not.
     * @param p
     * @return if the player who shot got wet.
     */
    public boolean round(Player p){
        return p.shot(revolver);
    }
    
    public void game(Scanner ent){
        boolean next = true;
        while(next){
            for (Player player : players) {
                System.out.println(player.getName() + " turn.");
                if(round(player)){
                    System.out.println(player.getName() + " got SHOT! GAME OVER");
                    return;
                } else {
                    System.out.print("Enter for next round: ");
                    ent.nextLine();
                }
            }
        }
    }
    
    public Player whoIsDipped(){
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            Player next = it.next();
            if(next.isDipped()){
                return next;
            }
        }
        return null;
    }
    
    public void addPlayer(Player p){
        players.add(p);
    }
}
