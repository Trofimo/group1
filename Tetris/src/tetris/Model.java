package tetris;

public class Model implements EventProcessor{

	State state;
	Logic logic;
	
	public Model() {
		this.state = new State();
		this.logic = new Logic(state);
	}
	ModelListener listener;
	
	public void setListener(ModelListener listener){
		this.listener = listener;
	}
	
	@Override
	public void moveLeft() {
		logic.moveLeft();
		listener.updateState(state);
	}
	@Override
	public void moveRight() {
		logic.moveRight();
		listener.updateState(state);
	}
	@Override
	public void slideDownOneRow() {
		logic.slideDownOneRow();
		listener.updateState(state);
	}
	@Override
	public void dropdown() {
		logic.dropdown();
		listener.updateState(state);
	}
	@Override
	public void rotate() {
		logic.rotate();
		listener.updateState(state);
	}
	
	
}
