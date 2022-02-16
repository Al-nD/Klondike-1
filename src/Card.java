
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
    public final int xShift = 150, yShift = 200;
    public final int xMargin = 75, yMargin = 50;

    public Card(String v, String s) {
        value = v;
        suit = s;
        isRed = (s.equals("Diamond") || s.equals("Heart"));
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
    }

    public void draw(Graphics g) {		
        Image img = (faceDown)? (backImage):(frontImage);
        g.drawImage(img, xShift + xMargin * column, yShift +  yMargin * cardNumber, null);
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
}
