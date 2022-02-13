import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Column extends Pile {
    private int location;
    private ArrayList<Card> cards;

    public Column(int location) {
        this.location = location;
        this.cards = new ArrayList<Card>();
    }

    @Override
    public void draw(Graphics g) {
        for (Card c: cards) {
            c.draw(g);
        }
    }

    @Override
    public void update(ActionEvent a) {

    }

    @Override
    public boolean canAddCard(Card c) {
        if (cards.size() == 0)
            return true;
        Card lastCard = cards.get(cards.size() - 1);
        if ((c.oppositeColor(c) && c.compareTo(lastCard) == -1) || lastCard.isFaceDown()) {
            return !cards.contains(c);
        }
        return false;
    }

    public void addCard(Card c) {
        if (canAddCard(c)) {
            cards.add(c);
            c.setCardNumber(cards.size());
            c.setColumn(this.location);
            c.flip();
        }
    }

    public int getLocation() {
        return this.location;
    }

    public Card getCard() {
        return cards.remove(cards.size() - 1);
    }

    public void addCards(ArrayList<Card> cards) {
        for (Card c: cards) {
            addCard(c);
        }
    }
    
    
}
