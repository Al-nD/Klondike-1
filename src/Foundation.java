import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Foundation extends Pile{

    private String suit;
    private ArrayList<Card> cards;

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean canAddCard(Card c) {
        // TODO Auto-generated method stub
        if (cards.size() == 1) {
            return c.getCardNumber() == 1;
        }
        return c.compareTo(cards.get(cards.size() - 1)) == -1 && c.getSuit().equals(suit);
    }
    
}
