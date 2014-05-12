/*
 * ����� ��� ������ � ��������� ������� ����
 */
package lesson140318.solitare;

import java.awt.Color;

class DeckPile extends CardPile {

	DeckPile (int x, int y) {
		
		// ������������� ��������� ����������
		super(x, y);
		
		// ����� ����� �������������� ��� ����� ������:
		// ������ ����� ��� ������������� ������
		CardPile pileOne = new CardPile(0, 0);
		CardPile pileTwo = new CardPile(0, 0);
		
		// ����� ����� ������� ������ ������ � �������, ���������� ���������� ���� � ������ ������:
		int count = putCardPile(pileOne);
		
		// ������������(������) ������ ������, ��������� ������:
		
		mix(pileOne, pileTwo, count);
		
	}
	
	@Override
	
	public void selectDiscardPile(int tx, int ty) {
		if(empty()){
			while(!Solitaire.discardPile.empty()){
				Card kar=Solitaire.discardPile.pop();
				kar.flip();
				addCard(kar);
			}
			}// My bylo: return;
		     Solitaire.discardPile.addCard(pop());
		}
	
	
	private final  void mix(CardPile pileOne, CardPile pileTwo, int count) {
		for (; count > 0; count--) {
			
			//1. ���������� �� ��������� �������...
			int limit = pullOutRandomly(count);
			
			//2. ���������� ���� � ��������� �����...	
			
			for (int i = 0; i < limit; i++)
				moveDownToRandomLocation(pileOne, pileTwo);
		
			//3. ����� ����� �������� ��� �����...
			
			findAndAddCard(pileOne);
		
			//4. ����� ���������� ������ ������� ������	
			putDecksBackTogether(pileOne, pileTwo);
			}
		
	}

	/**
	 * @param pileOne
	 * @param pileTwo
	 */
	private final void putDecksBackTogether(CardPile pileOne, CardPile pileTwo) {
		while (! pileTwo.empty())
			moveDownToRandomLocation(pileTwo, pileOne);
	}

	/**
	 * @param pileOne
	 */
	private final void findAndAddCard(CardPile pileOne) {
		addCard(pileOne.pop());
	}

	/**
	 * @param pileOne
	 * @param pileTwo
	 */
	private final void moveDownToRandomLocation(CardPile pileOne, CardPile pileTwo) {
		pileTwo.addCard(pileOne.pop());
	}

	/**
	 * @param count
	 * @return
	 */
	private final int pullOutRandomly(int count) {
		int limit = ((int)(Math.random() * 1000)) % count;
		return limit;
	}

	/**
	 * @param pileOne
	 * @return
	 */
	private final int putCardPile(CardPile pileOne) {
		int count = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j <= 12; j++) {
				pileOne.addCard(new Card(i, j,Color.CYAN));
				count++;
				}
		return count;
	}


}