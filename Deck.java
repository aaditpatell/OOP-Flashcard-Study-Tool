import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private String name;
    private ArrayList<Card> cards;

    // constructor sets name and makes empty card list
    public Deck(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    // add card to deck
    public void addCard(Card card) {
        cards.add(card);
    }

    // shuffle the deck randomly
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    // get a random card from the deck
    public Card getRandomCard() {
        if (cards.isEmpty()) return null;
        Random r = new Random();
        return cards.get(r.nextInt(cards.size()));
    }

    // show all cards in the deck
    public void quizAll() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
}
