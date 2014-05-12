/*
 * Класс для описания общих методов со стопкой карт
 */
package lesson140318.solitare;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

class CardPile {

	
	protected int x;
    protected int y;
    private Card firstCard;
	//private Color g;

	CardPile (int xl, int yl) {
		x = xl;
		y = yl;
		firstCard = null;
	}

		
	// добавить карту
	
    public void addCard (Card aCard) {
		aCard.link = firstCard;
		firstCard = aCard;
	}
	
	
	// можно взять карту из колоды?
	public boolean canTake (Card aCard) {
		return false; 
	}
	
	// отобразить колоду
	public void display (Graphics g) {
		g.setColor(Color.black);
		
		if (firstCard == null)
			g.drawRect(x, y, Card.width, Card.height);
		else
			firstCard.draw(g, x, y);
	}
	
	// пустая колода?
	public boolean empty() { 
		return firstCard == null; 
	}
	
	 
	public boolean includes (int tx, int ty) {
		return   x <= tx && 
				 tx <= x + Card.width &&
				 y <= ty &&
				 ty <= y + Card.height;
	}
	// достать карту из колоды по порядку
	public Card pop() {
		
		Card result = null;
		if (firstCard != null) {
			result = top();
			firstCard = firstCard.link;
		}
		return result;
	}
	
	// достать карту из колоды по порядку
		public CardPile popPile() {
			CardPile cp=new CardPile(x, y);
			while(top().faceUp()){
			cp.addCard(pop());
			}
			return cp;
			
		}
	public void selectSuite (int tx, int ty) {
		
		Card topCard = pop();
		
		
		// else see if any suit pile can take card
		for (int i = 0; i < 4; i++){
			if (Solitaire.suitPile[i].canTake(topCard)) {
				
				Solitaire.suitPile[i].addCard(topCard);
				return;
				}
			}
		addCard(topCard);
		}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedList addToList() {
		LinkedList list=new LinkedList();
		while(!empty()){
			list.addFirst(pop());
		}
		
		LinkedList list2=selectClosePileFromTablePile(list);
		LinkedList list3=selectOpenPileFromTablePile(list);
		returnClosePileToHomePile(list2);
		if(list3.isEmpty()){return list;}
		return list3;
	}
	@SuppressWarnings("unchecked")
	public void selectTable(int tx, int ty) {
		
		
		 Card topCard = pop();
         for (int i = 0; i < 7; i++){
					
					if (Solitaire.tableau[i].canTake(topCard)) {//topCard
						
						Solitaire.tableau[i].addCard(topCard);  //topCard
						
						return;
						}
					
				
				}
		
     // else put it back on our pile
		addCard(topCard);
        
	}
	// выбрать первую сверху карту
	public Card top() { 
		return firstCard; 
	}
	
	public void moveTableCard(LinkedList<Card> list) {
		Card o;
		o=list.getFirst();
		if(!o.faceUp()){
			o.flip();
		}
		Iterator <Card> i = list.iterator();
		 Card e;
		while (i.hasNext()) {
		    e = i.next();
		    for (int k = 0; k < 7; k++){
		    	if (Solitaire.tableau[k].canTake(e)) {
		        //i.remove();
		        Solitaire.tableau[k].addCard(e);
		        // Return it
		        //return ;
		    	}
		    
		    }
		   
		}			
	}
	public void addIfCanSuitAndTableCard() {
		Card topCard = pop();
		
		
					
		// else see if any suit pile can take card
		for (int i = 0; i < 4; i++)
			if (Solitaire.suitPile[i].canTake(topCard)) {
				
				Solitaire.suitPile[i].addCard(topCard);
				return;
				}
		// else see if any other table pile can take card
		for (int i = 0; i < 7; i++){
			
			if (Solitaire.tableau[i].canTake(topCard)) {
				Solitaire.tableau[i].addCard(topCard);
				
				return;
				}
			
		// else put it back on our pile
		}
		addCard(topCard);
	}


	public void selectDiscardPile(int tx, int ty) {
		
		
	}

	public void returnOpenPileToHomePile(@SuppressWarnings("rawtypes") LinkedList list) {
		while(!list.isEmpty()){
			addCard((Card) list.removeLast());
		}
	}

	public void returnClosePileToHomePile(LinkedList<Card> list3) {
		while(!list3.isEmpty()){
			addCard((Card) list3.removeLast());
		}
	}

	public LinkedList<Card> selectClosePileFromTablePile(@SuppressWarnings("rawtypes") LinkedList list) {
		LinkedList list2=new LinkedList<Card>();
		Card o;
		Iterator<Card> i = list.iterator();
		while (i.hasNext()) {
		    o = i.next();
		    if (!o.faceUp()) {
		    	i.remove();
		        list2.addFirst(o);
		        
		    }
		}	


		return list2;
	}

	public LinkedList<Card> selectOpenPileFromTablePile(LinkedList list) {
		LinkedList list3=new LinkedList();
		Iterator<Card> i = list.iterator();
		while (i.hasNext()) {
		    Card e = i.next();
		    if (e.faceUp()) {
		        // Found, so move it to the front,
		        i.remove();
		        list3.addLast(e);
		        
		    }
		}
		
		return list3;
	}



	
}