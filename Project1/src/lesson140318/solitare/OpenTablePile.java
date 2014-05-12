package lesson140318.solitare;

public class OpenTablePile extends CardPile{
	
	
	private Card _top;
	
	OpenTablePile(int x, int y) {
		super(x, y);
		
//		Card topCard = top();
//		
//		set_top(topCard);
	}



	public Card get_top() {
		return _top;
	}

	public void set_top(Card _top) {
		this._top = _top;
	}

	

	
	

}
