
package russianroulette.services;

import java.util.Scanner;
import russianroulette.entities.Player;

/**
 *
 * @author paula
 */
public class PlayerService {
    Scanner ent = new Scanner(System.in);
    
    public Player createPlayer(){
        System.out.println("-- NEW PLAYER --");
        System.out.print("Name: ");
        Player p = new Player(ent.nextLine());
        return p;
    }
    
}
