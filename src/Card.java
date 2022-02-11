
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

    public Card(String v, String s) {
        value = v;
        suit = s;
        isRed = (s.equals("Diamond") || s.equals("Heart"));
    }

    public void draw(Graphics g) {		
		g.drawImage(getImage(), 400 * column, cardNumber * 300, null);
    }

    public void update(ActionEvent e) {

    }

    public Image getImage() {
        try {
			Image img = ImageIO.read(new File("images/cards/" + suit + value + ".png"));
            return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
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
}
