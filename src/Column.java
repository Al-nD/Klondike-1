import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Column extends Pile {
    private int capacity;
    private ArrayList<Card> cards;

    public Column(int capacity) {
        this.capacity = capacity;
        this.cards = new ArrayList<Card>();
    }

    @Override
    public void draw(Graphics g) {
        try {
            Image img = ImageIO.read(new File("images/cards/hj.png"));
            g.drawImage(img, 200 + capacity * (int)(img.getWidth(null) * 1.1), 100, null);
            } catch(Exception e) {
        }
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean canAddCard(Card c) {
        return cards.size() < this.capacity && !cards.contains(c);
    }

    public void addCard(Card c) {
        if (canAddCard(c)) {
            cards.add(c);
            c.setCardNumber(cards.size());
            c.setColumn(this.capacity);
        }
    }

    public int getCapacity() {
        return this.capacity;
    }
    
}
