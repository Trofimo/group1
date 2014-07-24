package tetris;

public class Model implements EventProcessor {

	State state;
	Logic logic;
	
	public Model() {
		state = new State();
		logic = new Logic(state);
	}
	
	ModelListener listener;
	
	public void setListener(ModelListener listener) {
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
	public void rotate(boolean b) {
		logic.rotate(b);
		listener.updateState(state);
	}
	@Override
	public void dropDown(boolean b) {
		logic.dropDown(b);
		listener.updateState(state);
	}
	@Override
	public void slideDownOneRow() {
		logic.slideDownOneRow();
		listener.updateState(state);
	}

	public void pause() {
		logic.pause();
		
	}

	public void resume() {
		logic.resume();
		
	}

	public void menu() {
		logic.menu();
		
	}
}
