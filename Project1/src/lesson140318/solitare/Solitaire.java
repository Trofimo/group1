/*
 * Главный класс игры.
 * 
 */
package lesson140318.solitare;

/*
	Simple Solitaire Card Game in Java
	Written by Tim Budd, Oregon State University, 1996
*/

import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
import java.applet.*;

public class Solitaire extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static TablePile tableau[];
	static SuitPile suitPile[];
	static CardPile allPiles[];
	static OpenTablePile opentable[];
	
	
	@Override
	public void init() {
		
		// first allocate the arrays
			allPiles = new CardPile[13];
			suitPile = new SuitPile[4];
			tableau = new TablePile[7];
			opentable=new OpenTablePile[9];//может быть не более 9 карт в открытой колоде table
		// then fill them in
			allPiles[0] = deckPile = new DeckPile(335, 5);
			allPiles[1] = discardPile = new DiscardPile(268, 5);
			
			for (int i = 0; i < 4; i++)
				allPiles[2+i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
			for (int i = 0; i < 7; i++)
				allPiles[6+i] = tableau[i] =  new TablePile(5 + 55 * i, 80, i+1); 
	}
	
	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < 13; i++){
		if (allPiles[i].includes(x, y)) {
			
			
			if(evt.clickCount > 1){
				
				allPiles[i].selectTable(x, y);
				}
			else{
					if(allPiles[i] == deckPile){//if(allPiles[i].equals(deckPile)){
					allPiles[i].selectDiscardPile(x, y);}
					else{
					allPiles[i].selectSuite(x, y);} 
				}
			
			
			repaint();
			return true;
			}}
		return true;

	}
	
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < 13; i++)
			
			allPiles[i].display(g);
		
		
	}
	//Обработка отпускания кнопки
	public boolean mouseUp(Event evtObj, int x,int y) {
//		for (int i = 0; i < 13; i++)
//			if (allPiles[i].includes(x, y)) {
//				allPiles[i].selectSuite(x, y);
//				
//				
//				
//				repaint();
//				return true;
//				}
		
		return true;
	}

	//Обработка перемещения мыши
	public boolean mouseMove(Event evtObj, int x,int y) {
	   

	   return true;
	}

	//Обработка передвижения мыши
	public boolean mouseDrag(Event evtObj, int x,int y) {
		

	      return true;
	}

	//Обработка перемещения указателя мыши на окно
	public boolean mouseEnter(Event evtObj, int x,int y) {
		return true;
	}

	//Обработка выхода мыши за пределы окна
	public boolean mouseExit(Event evtObj, int x,int y) {
	   
	   repaint();

	   return true;
	}
	
}

