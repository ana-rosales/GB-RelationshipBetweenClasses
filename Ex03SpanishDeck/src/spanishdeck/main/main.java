package spanishdeck.main;

import java.awt.BorderLayout;
import java.util.Scanner;
import spanishdeck.entities.Deck;

/**
 *
 * @author paula
 */
public class main {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Deck deck = new Deck();
        boolean cont = true;
        int opc;
        deck.showDeck();

        do {
            System.out.println("MENU.");
            System.out.println("1. Shuffle.");
            System.out.println("2. Next card.");
            System.out.println("3. Show available cards.");
            System.out.println("4. Request cards.");
            System.out.println("5. Cards from the pile.");
            System.out.println("6. Show deck.");
            System.out.println("7. EXIT.");
            opc = ent.nextInt();
            ent.nextLine();
            switch (opc) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.nextCard();
                    break;
                case 3:
                    deck.availableCards();
                    break;
                case 4:
                    System.out.print("How many cards do you want? :");
                    int num = ent.nextInt();
                    ent.nextLine();
                    deck.giveCards(num);
                    break;
                case 5:
                    deck.cardsPile();
                    break;
                case 6:
                    deck.showDeck();
                    break;
                case 7:
                    cont = false;
                    break;
                default:
                    System.out.println("Choose a correct option.");
            }
            
        } while (cont);

    }

}
