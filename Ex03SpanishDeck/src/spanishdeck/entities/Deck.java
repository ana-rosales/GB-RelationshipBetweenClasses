package spanishdeck.entities;


import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import spanishdeck.enumerations.Suit;

public class Deck {

    private List<Card> deck;
    private List<Card> pile;

    public Deck() {
        deck = generateDeck();
        pile = new ArrayList<>();
    }

    public ArrayList<Card> generateDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();
        EnumSet.allOf(Suit.class).forEach(suit ->{for (int i = 1; i < 12; i++) {
            i = (i == 8)? i + 2: i;
            newDeck.add(new Card(i, suit));
        }});
        return newDeck;
    }
    
    /**
     * Changes the order of each card on the deck randomly.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Returns the last card of the deck.
     * @return a card.
     */
    public Card nextCard() {
        if(deck.isEmpty()){
            System.out.println("Deck is empty...");
            return null;
        }
        Card out = deck.remove(deck.size()-1);
        pile.add(out);
        return out;
    }

    /**
     * Shows the number of cards remaining on the deck.
     */
    public void availableCards() {
        System.out.println(deck.size() + " remaining cards.");
    }

    /**
     * According to a specified number of cards, they will be taken off the deck
     * and given to the player.
     * @param num
     * @return the specified number of cards in a list.
     */
    public ArrayList<Card> giveCards(int num) {
        if(deck.size() >= num){
            ArrayList<Card> cards = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                cards.add(deck.remove(deck.size()-1));
            }
            pile.addAll(cards);
            return cards;
        }
        System.out.println("There are not enough cards.");
        return null;
    }

    /**
     * Shows all the cards that are out, if any of the cards has exited, it 
     * shows a different message.
     */
    public void cardsPile(){
        if(pile.size()>0){
            System.out.println("Pile{" + "pile=" + pile + "}");
        } else {
            System.out.println("There are no cards in the pile!");
        }
    }
    
    /**
     * Shows the remaining cards on the deck.
     */
    public void showDeck() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "Deck{" + "deck=" + deck + '}';
    }
    
    
}
