/*
 * Класс описания общих методов для работы с картой
 */
package lesson140318.solitare;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

class Card {
	
	// поля для цветов и мастей
	final static int width = 50;
    final static int height = 70;
    final static int red = 0;
    final static int black = 1;
    final static int heart = 0;
    final static int spade = 1;
    final static int diamond = 2;
    final static int club = 3;
	final static int green= 10;
	final static int magenta= 20;
    
    
	private boolean faceup;
	private int rank;
	private int suit;
	
	public Card link;
	private boolean _isSelect;
	
	// конструктор
	Card (int sv, int rv,Color bg) {
		suit = sv;
		rank = rv;
		
		faceup = false;
	}
	
	
	
	



		// получаем атрибуты карты
		// ранг 
		public int  rank () {
			return rank; 
		}
		// масть
		public int  suit() { 
			return suit; 
		}
		// определить цвет рубашки
		public int  color() 	{
				if (suit() == heart || suit() == diamond)
					return red;
				return black;
			}
		public void setColorBackground(Graphics g){
			g.setColor(Color.GREEN);
		}
		// рубашка сверху?
		public boolean	faceUp(){ 
			return faceup; 
		}
	
	// методы для создания карты
	// рисуем узор рубашки 
	private final void drawBodyOfCard(Graphics g, int x, int y, String[] names) {
			if (faceUp()) {
				if (color() == red)
					g.setColor(Color.red);
				else
					g.setColor(Color.blue);
				g.drawString(names[rank()], x+3, y+15);
				if (suit() == heart) {
					g.drawLine(x+25, y+30, x+35, y+20);
					g.drawLine(x+35, y+20, x+45, y+30);
					g.drawLine(x+45, y+30, x+25, y+60);
					g.drawLine(x+25, y+60, x+5, y+30);
					g.drawLine(x+5, y+30, x+15, y+20);
					g.drawLine(x+15, y+20, x+25, y+30);
					}
				else if (suit() == spade) {
					g.drawLine(x+25, y+20, x+40, y+50);
					g.drawLine(x+40, y+50, x+10, y+50);
					g.drawLine(x+10, y+50, x+25, y+20);
					g.drawLine(x+23, y+45, x+20, y+60);
					g.drawLine(x+20, y+60, x+30, y+60);
					g.drawLine(x+30, y+60, x+27, y+45); 
					}
				else if (suit() == diamond) {
					g.drawLine(x+25, y+20, x+40, y+40);
					g.drawLine(x+40, y+40, x+25, y+60);
					g.drawLine(x+25, y+60, x+10, y+40);
					g.drawLine(x+10, y+40, x+25, y+20);
					}
				else if (suit() == club) {
					g.drawOval(x+20, y+25, 10, 10);
					g.drawOval(x+25, y+35, 10, 10);
					g.drawOval(x+15, y+35, 10, 10);
					g.drawLine(x+23, y+45, x+20, y+55);
					g.drawLine(x+20, y+55, x+30, y+55);
					g.drawLine(x+30, y+55, x+27, y+45); 
					}
			}
			else { // face down
				g.setColor(Color.yellow);
				g.drawLine(x+15, y+5, x+15, y+65);
				g.drawLine(x+35, y+5, x+35, y+65);
				g.drawLine(x+5, y+20, x+45, y+20);
				g.drawLine(x+5, y+35, x+45, y+35);
				g.drawLine(x+5, y+50, x+45, y+50);
			}
		}
	
	// нарисовать карту(нарисовать прямоугольник, нарисовать рубашку, нарисовать лицевую часть)
	public void   	draw (Graphics g, int x, int y) {
		
			String names[] = {"A", "2", "3", "4", "5", "6","7", "8", "9", "10", "J", "Q", "K"};
		    
			// clear rectangle, draw border
			g.clearRect(x, y, width, height);
			g.setColor(Color.black);
			g.drawRect(x, y, width, height);
		
			// draw body of card
			drawBodyOfCard(g, x, y, names);
	}
    
	// перевернуть стороны карты
	public void   	flip() { 
		faceup = ! faceup; 
	}





	public void setIsSelect(Event evt){
		if(evt.clickCount>1){
			_isSelect=true;}
	}

	public boolean isSelect() {
		// TODO Auto-generated method stub
		return _isSelect;
	}
	
	
	
}