package tetris;

public class Controller implements ModelListener, EventProcessor {
	
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		model.setListener(this);
	}

	@Override
	public void updateState(State state) {
		view.updateState(state);
	}

	@Override
	public void moveLeft() {
		model.moveLeft();
	}

	@Override
	public void moveRight() {
		model.moveRight();
	}

	@Override
	public void rotate(boolean b) {
		model.rotate(b);
	}

	@Override
	public void dropDown(boolean b) {
		model.dropDown(b);
	}

	@Override
	public void slideDownOneRow() {
		model.slideDownOneRow();
	}

	public void pause() {
		model.pause();
		
	}

	public void resume() {
		model.resume();
		
	}

	public void menu() {
		model.menu();
		
	}
	
	
	

}
