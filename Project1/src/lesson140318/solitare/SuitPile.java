/*
 * ����� ��� ������ � �������� ����, �������� ��� �������� ���� �� ���� �� ������ � �������� ����
 */
package lesson140318.solitare;

class SuitPile extends CardPile {

	SuitPile (int x, int y) {
		super(x, y); 
	}
	
	// ����� �����?
	@Override
	public boolean canTake (Card aCard) {
		if (empty()){
			
			return isAse(aCard);
			}
		Card topCard = top();
		return (aCard.suit() == topCard.suit()) &&
			(aCard.rank() == 1 + topCard.rank());
		}
	
	// ��� ������?
	private boolean isAse(Card aCard) {
		return aCard.rank() == 0;
	}
}