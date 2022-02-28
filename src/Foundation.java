import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Foundation extends Pile{

    private String suit;
    private ArrayList<Card> cards;

    public Foundation(String suit) {
        this.suit = suit;
        this.cards = new ArrayList<Card>();
    }

    @Override
    public void draw(Graphics g) {
        if (cards.size() > 0) {
            cards.get(cards.size() - 1).draw(g);
        } else {
            int loc = (suit.equals("h"))? 0: (suit.equals("d"))? 1 : 4;
            // g.setColor(new Color(50, 50, 50))
            // g.fillRect(0, 0, 3000, 2000);
        }
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean canAddCard(Card c) {
        // TODO Auto-generated method stub
        if (cards.size() == 0) {
            return c.getValue().equals("1");
        }
        return c.compareTo(cards.get(cards.size() - 1)) == -1 && c.getSuit().equals(suit);
    }

    public void addCard(Card c) {
        if (canAddCard(c)) {
            cards.add(c);
        }
    }

    public void addAll(ArrayList<Card> cards) {
        for (Card c: cards) {
            addCard(c);
        }
    }
    
}
