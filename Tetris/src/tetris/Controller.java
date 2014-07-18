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
	public void slideDownOneRow() {
		model.slideDownOneRow();
	}

	@Override
	public void dropdown() {
		model.dropdown();
		
	}

	@Override
	public void rotate() {
		model.rotate();		
	}
	
}
