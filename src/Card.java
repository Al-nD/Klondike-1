
/** represents a playing card that can draw itself. */
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Card implements Drawable, Updateable{

    private String value;
    private String suit;
    private boolean isRed;
    private int column;
    private int cardNumber;
    private boolean faceDown;
    private Image frontImage;
    private Image backImage;
    private boolean inDeck;
    private boolean inColumn;
    private boolean inFoundation;
    public final int xShift = 150, yShift = 200;
    public final int xMargin = 75, yMargin = 50;

    private int x, y;

    public Card(String v, String s) {
        value = v;
        suit = s;
        isRed = (s.equals("d") || s.equals("h"));
        try {
            frontImage = ImageIO.read(new File("images/cards/" + suit + value + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            backImage = ImageIO.read(new File("images/cards/b1fv.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        faceDown = true;
        inDeck = true;
        inColumn = false;
        inFoundation = false;
    }

    public void draw(Graphics g) {		
        Image img = (faceDown)? (backImage):(frontImage);
        if (inColumn) {
            x = xShift + xMargin * column;
            y = yShift +  yMargin * cardNumber;
            g.drawImage(img, x, y, null);
        } else if (inDeck) {
            x = 50;
            y = 250;
            g.drawImage(img, 50, 250, null);
        } else {
            int foundationNumber = (suit.equals("s"))? 1: (suit.equals("c"))? 2: (suit.equals("h"))? 3:  4;
            x = 200 + 75 * foundationNumber;
            y = 100;
            g.drawImage(img, x, 100, null);
        }
    }

    public void update(ActionEvent e) {

    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public int getColumn() {
        return this.column;
    }

    public void setCardNumber(int cN) {
        this.cardNumber = cN;
    }

    public void setColumn(int c) {
        this.column = c;
    }

    public int compareTo(Card other) {
        try {
            return Integer.parseInt(value) - Integer.parseInt(other.value);
        } catch (Exception e) {
            
        }
        int val = (this.value.equals("j"))? (11): (this.value.equals("q"))? (12) : (13);
        int val2 = (other.value.equals("j"))? (11): (other.value.equals("q"))? (12) : (13);
        return val - val2;
    }

    public void flip() {
        this.faceDown = (faceDown)? false: true;
    }

    public boolean oppositeColor(Card c) {
        return (this.isRed && !c.isRed) || (!this.isRed && c.isRed);
    }

    public String toString() {
        return this.value + " of " + this.suit;
    }

    public boolean isFaceDown() {
        return this.faceDown;
    }

    public String getSuit() {
        return this.suit;
    }

    public String getValue() {
        return this.value;
    }

    public void setInDeck(boolean inDeck) {
        this.inDeck = inDeck;
    }

    public void setInColumn(boolean inColumn) {
        this.inColumn = inColumn;
    }

    public void setInFoundation(boolean inFoundation) {
        this.inFoundation = inFoundation;
    }

    public void clickedOn(MouseEvent me) {

        String ans = x + ", " + y;
        Image temp = (faceDown)? backImage: frontImage;
        // if (inColumn) {
        //     if ((x < me.getX() && me.getX() < x + temp.getWidth(null)) && 
        //     (y < me.getY() && me.getY() < y + temp.getHeight(null))) {
        //         System.out.println(ans);
        //     }
        // } else if (inDeck && (x < me.getX() && me.getX() < x + temp.getWidth(null)) && 
        // (y < me.getY() && me.getY() < y + temp.getHeight(null))) {
        //     System.out.println(ans);;
        // } else if (inFoundation) {
        //     if ((x < me.getX() && me.getX() < x + temp.getWidth(null)) && 
        //     (y < me.getY() && me.getY() < y + temp.getHeight(null))) {
        //         System.out.println(ans);;
        //     }
        // }
        // System.out.println(x + ", " + me.getX());
        // System.out.println(y + ", " + me.getY());
        if ((x < me.getX() && me.getX() < x + temp.getWidth(null)) && 
            (y < me.getY() && me.getY() < y + temp.getHeight(null)) && !this.faceDown) {
                System.out.println(ans);;
            }
    }

    
}
