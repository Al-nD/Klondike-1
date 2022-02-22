import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.management.MBeanServer;

public class Deck extends Pile {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (int i = 1; i <  11; i++) {
            cards.add(new Card("" + i, "h"));
            cards.add(new Card("" + i, "d"));
            cards.add(new Card("" + i, "s"));
            cards.add(new Card("" + i, "c"));
        }
        String[] faces = {"j", "q", "k"};
        for (int i = 0; i < faces.length; i++) {
            cards.add(new Card(faces[i], "h")); 
            cards.add(new Card(faces[i], "d"));
            cards.add(new Card(faces[i], "s"));
            cards.add(new Card(faces[i], "c"));
        }

    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void draw(Graphics g) {
        for (Card c: cards) {
            c.draw(g);
        }
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub  
    }

    @Override
    public boolean canAddCard(Card c) {
        return !cards.contains(c);
    }

    public void addCard(Card c) {
        if (canAddCard(c)) {
            cards.add(c);
        }
    }

    public Card getCard() {
        Card c = cards.remove(cards.size() - 1);
        return c;
    }

    public void giveCardsToColumns(Column[] cols) {
        for (Column col: cols) {
            for (int j = 0; j < col.getLocation(); j++) {
                Card c = getCard();
                if (j < col.getLocation() - 1) {
                    c.flip();
                }
                c.setInDeck(false);
                c.setInColumn(true);
                col.addCard(c);                
            }
        }
    }

    public void addAll(ArrayList<Card> cards) {
        for (int i = cards.size() - 1; i > -1; i--) {
            Card c = cards.remove(i);
            addCard(c);
        }
    }
}
