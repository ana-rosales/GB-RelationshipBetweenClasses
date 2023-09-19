package spanishdeck.entities;

import spanishdeck.enumerations.Suit;

public class Card {

    private int number;
    private Suit suit;

    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public Card() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" + "number=" + number + ", suit=" + suit + '}';
    }
    
}
