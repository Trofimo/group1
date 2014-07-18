package tetris;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends KeyAdapter {

	private static final int CELL_SIZE = 30;
	private Graphics2D graphics;
	private EventProcessor processor;

	public View(Graphics2D graphics) {
		this.graphics = graphics;
	}
	
	public void setEventProcessor(EventProcessor processor){
		this.processor = processor;
		
	}

	public void updateState(State state) {

		graphics.clearRect(0, 0, 400, 700);
		
		graphics.setColor(Color.black);
		graphics.fillRect(state.getFigureColumn() * CELL_SIZE, 
				state.getFigureRow() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			processor.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			processor.moveRight();
		}
	}
}
