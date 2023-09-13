
package russianroulette.main;

import java.util.Scanner;
import russianroulette.entities.Game;
import russianroulette.entities.Revolver;
import russianroulette.services.PlayerService;

public class main {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        PlayerService ps = new PlayerService();
        Game g = new Game();
        boolean play = true;
        int opc;
        
        do {            
            System.out.println("\n-- AQUATIC RUSSIAN ROULETTE --\n");
            System.out.println("1. New Game.");
            System.out.println("2. Add Players.");
            System.out.println("3. Exit.");
            System.out.print("Choose an option from above: ");
            opc = ent.nextInt();
            ent.nextLine();
            switch(opc){
                case 1:
                    if(!g.getPlayers().isEmpty()){
                        g.newGame(g.getPlayers());
                        System.out.println("NEW GAME");
                        g.game(ent);
                    } else {
                        System.out.println("There are no players to play!");
                    }
                    break;
                case 2:
                    g.addPlayer(ps.createPlayer());
                    break;
                case 3:
                    System.out.print("Exit? Y/N: ");
                    play = !ent.nextLine().equalsIgnoreCase("Y");
                    break;
                default:
                    System.out.println("Choose a valid option, please.");
            }
        } while (play);
    }
    
}
