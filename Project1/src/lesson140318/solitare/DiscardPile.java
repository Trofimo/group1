/*
 * ����� ��� ������ �� ������� ����, ������� ������ ��� ������������� � �������� ����
 */
package lesson140318.solitare;

class DiscardPile extends CardPile {
	
	DiscardPile (int x, int y) { 
		super (x, y); 
	}
	// �������������� ���������� �����
	// ���� �������� ������ �� �������������� ����� ���� �����
	// � ������ ������ �� ������
	@Override
	public void addCard (Card aCard) {
		if (! aCard.faceUp())
			aCard.flip();
		super.addCard(aCard);
		}
	@Override
	public void selectSuite (int tx, int ty) {
		if (empty())
			Solitaire.deckPile.addCard(pop());
			
		super.selectSuite(tx, ty);
		
		}
	@Override
	public void selectTable(int tx, int ty) {
		Card topCard = null;
		if (empty()){
			Solitaire.deckPile.addCard(pop());}
		else{	
		//super.selectTable(tx, ty);
		 topCard = pop();
			
			
			for (int i = 0; i < 7; i++){
				
				if (Solitaire.tableau[i].canTake(topCard)) {//topCard
					
					Solitaire.tableau[i].addCard(topCard);  //topCard
					
					return;
					}
				
			
			}
			// else put it back on our pile
			addCard(topCard);
			}
			
	}
	

}