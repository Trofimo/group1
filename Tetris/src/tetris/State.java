package tetris;

public class State {

	public Field field = new Field();
	public Figure figure;
	public int figureRow;
	
;
	public int figureColumn;
	
	public State(){
		newFigure();
	}
	
	void moveFigureLeft() {
		figureColumn--;
	}
	public int getFigureColumn() {
		return figureColumn;
	}
	public void moveFigureRight() {
		figureColumn ++;
	}
	public void slideDown() {
		figureRow ++;
	}
	public int getFigureRow() {
		return figureRow;
	}
	public boolean hasConflictWhenShifted(int rowShift, int colShift) {
		
		return field.hasConflictAt
				(figureRow + rowShift, 
						figureColumn + colShift, 
						figure.data);
	}
	public void pasteFigure() {
		field.paste(figureRow, figureColumn, figure.data);
	}
	public void newFigure() {
		figure = figure.randomFigure();
		figureRow = 0;
		figureColumn = field.box[0].length / 2 
				- figure.data[0].length / 2 + 1;
		
	}

}
