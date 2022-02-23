import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GameBoard implements Drawable, Updateable {	
	private Column[] columns;
	private Deck deck;
	// public static final int OFFSET_X = 40, OFFSET_Y = 20;
    public final int xShift = 150, yShift = 200;
    public final int xMargin = 75, yMargin = 50;
	private Card prevCard;
	private int numdraws=0;
	
	
	
	public GameBoard() {
		columns = new Column[7];
		deck = new Deck();
		for (int i = 0; i < 7; i++) {
			columns[i] = new Column(i + 1);
		}

		deck.shuffle();
		deck.giveCardsToColumns(columns);
	}

	/** @param g Graphics context onto which all Objects in the game
	 * draw themselves.  This should NOT change the Objects
	 */
	public void draw(Graphics g) {
		numdraws++;
		g.setColor(new Color(155, 30, 30));
		g.fillRect(0, 0, 3000, 2000);
		
		deck.draw(g);

		for (Column c: columns) {
			c.draw(g);
		}
	}


	/**
	 * This method is called by the game when a click has been made 
	 * on the panel.  Must determine if the click makes sense (is it 
	 * a valid location, If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * @param me
	 */
	public void justClicked(MouseEvent me) {
		for (Column col: columns) {
			for (Card c: col.getCards()) {
				c.clickedOn(me);
			}
		}
	}

	@Override
	// this update will be called each time the timer in the KlondikeGame
	// goes off.  This will be convenient for animating.
	public void update(ActionEvent a) {
		
	}

	public void addToFoundation(Foundation f, Column c) {
		
	}

}
