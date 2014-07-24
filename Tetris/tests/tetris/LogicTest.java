package tetris;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogicTest {

	private Logic _logic;

	@Before
	public void setup() {
		State state = new State();
		_logic = new Logic(state);
	}
	
	@Test
	public void testKnowsState() {
		assertNotNull(_logic.state);
	}
	
	@Test
	public void demoLogicInterface() throws Exception {
		_logic.moveLeft();
		_logic.moveRight();
		_logic.rotate();
		_logic.dropDown();
		_logic.slideDownOneRow();
	}
	
	@Test
	public void testMoveLeft() throws Exception {
		int column = _logic.state.figureColumn;
		_logic.moveLeft();
		assertEquals(column - 1, _logic.state.figureColumn);
	}
	
	@Test
	public void testMoveRight() throws Exception {
		int column = _logic.state.figureColumn;
		_logic.moveRight();
		assertEquals(column + 1, _logic.state.figureColumn);
	}
	
	@Test
	public void testNotMoveTooLeft() throws Exception {
		_logic.state.figureColumn = 0;  // Fixture
		_logic.state.figure.data = new int[][] {
				{0,0,0,0},	
				{0,0,0,0},	
				{0,0,0,0},	
				{1,1,1,1},	
		};
		_logic.moveLeft();  // 
		assertEquals(0, _logic.state.figureColumn); // Assertion
	}

	@Test
	public void testNotMoveTooRight() throws Exception {
		_logic.state.figureColumn = Field.WIDTH - 4;  // Fixture
		_logic.state.figure.data = new int[][] {
				{0,0,0,0},	
				{0,0,0,0},	
				{0,0,0,0},	
				{1,1,1,1},	
		};
		_logic.moveRight();  // 
		assertEquals(Field.WIDTH - 4, _logic.state.figureColumn); // Assertion
	}
	
	@Test
	public void testSlideDown() throws Exception {
		int row = _logic.state.figureRow;
		_logic.slideDownOneRow();
		assertEquals(row + 1, _logic.state.figureRow);
	}
	
	@Test
	public void testNotMoveTooLow() throws Exception {
		_logic.state.figureRow = Field.HEIGHT - 4;  // Fixture
		_logic.state.figure.data = new int[][] {
				{0,0,0,0},	
				{0,0,0,0},	
				{0,0,0,0},	
				{1,1,1,1},	
		};

		_logic.slideDownOneRow();  
		assertEquals(0, _logic.state.figureRow); // Assertion
	}
	
	@Test
	public void testNotMoveOverFilledCell() throws Exception {
		_logic.state.figureRow = Field.HEIGHT - 5;
		_logic.state.figure.data = new int[][] {
				{0,0,0,0},	
				{0,0,0,0},	
				{0,0,0,0},	
				{1,1,1,1},	
		};
		
		_logic.state.field.box[Field.HEIGHT - 1][_logic.state.figureColumn + 1] 
				= 2;
		
		_logic.slideDownOneRow();  
		
		assertEquals(0, _logic.state.figureRow); // Assertion
	}
	
}
