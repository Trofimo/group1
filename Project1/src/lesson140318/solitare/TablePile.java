/*
 * Класс для работы с колодами карт, лежащими на игральном столе
 */
package lesson140318.solitare;


import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;





class TablePile extends CardPile {

	

	TablePile (int x, int y, int c) {
			// инициализация родительского класса
		super(x, y);
			// инициализация нашей колоды карт
		for (int i = 0; i < c; i++) {
			addCard(Solitaire.deckPile.pop());
			}
			// перевернуть верхнюю открытую карту
		   top().flip();
		   
		}
	
	@Override
	public boolean canTake (Card aCard) {
		if (empty())
			return isKing(aCard);
		Card topCard = top();
		return (aCard.color() != topCard.color()) &&
			(aCard.rank() == topCard.rank() - 1);
		}

	private final boolean isKing(Card aCard) {
		return aCard.rank() == 12;
	}
	
	@Override
	public void display (Graphics g) {
		stackDisplay(g, top());
		}
	
	@Override
	public boolean includes (int tx, int ty) {
			// don't test bottom of card
		
		return x <= tx && tx <= x + Card.width &&
			y <= ty;
		}
	
	@Override
	public void selectSuite (int tx, int ty) { 
		if (empty())
			return;

			// if face down, then flip
		Card topCard = top();
		if (! topCard.faceUp()) {
			topCard.flip();
			return;
			}
		

			
		super.selectSuite(tx, ty);	
		
			
			
		}
		
		@Override
		public void selectTable(int tx, int ty) {
			if (empty())
				return;

				// if face down, then flip
			Card topCard = top();
			
			if (! topCard.faceUp()) {
				topCard.flip();
				return;
				}
			

			
			if(!empty()){
				super.moveTableCard(addToList());
				}	
			
		}
		
		private int stackDisplay(Graphics g, Card aCard) {
		int localy;
		if (aCard == null)
			return y;
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy);
		return localy + 35;
		}

	

}