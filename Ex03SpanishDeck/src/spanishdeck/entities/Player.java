package spanishdeck.entities;


import java.util.ArrayList;
import java.util.List;
import spanishdeck.entities.Card;

public class Player {

    private List<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }
}
