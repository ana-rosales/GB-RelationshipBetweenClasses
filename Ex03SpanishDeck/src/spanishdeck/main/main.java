
package spanishdeck.main;

import spanishdeck.entities.Deck;

/**
 *
 * @author paula
 */
public class main {

    public static void main(String[] args) {
        //this is gonna be the start
        //when the game starts should happen this.
        //also create the players
        
        Deck deck = new Deck();
        deck.showDeck();
        deck.shuffle();
        deck.showDeck();
        //movements of a player
        deck.nextCard();
        deck.availableCards();
        deck.cardsPile();
        
    }
    
}
