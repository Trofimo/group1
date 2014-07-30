package sudoku;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;






public class SudokuTest {
	
	private Sudoku sudoku;
	
	
	@Before
	public void setup(){
    sudoku=new Sudoku();
    sudoku.array = new int[][] {
    		{8,7,6,2,5,1,4,3,9},
    		{9,5,1,6,3,4,8,2,7},
    		{3,4,2,7,8,9,5,1,6},
    		
    		{1,3,4,9,7,5,6,8,2},
    		{5,6,8,4,1,2,9,7,3},
    		{2,9,7,8,6,3,1,5,4},

    		{4,8,3,1,2,6,7,9,5},
    		{7,2,9,5,4,8,3,6,1},
    		{6,1,5,3,9,7,2,4,8},
    	};
    }

    @Test
	public void testsmallRectOne() {
    	
    	assertEquals(true, sudoku.smallRectOne());
    	
    }
    @Test
    public void testsmallRectTwo() {
    	
    	assertEquals(true, sudoku.smallRectTwo());
    	
    }
    @Test
    public void testsmallRectThree() {
    	
    	assertEquals(true, sudoku.smallRectThree());
    	
    }
    @Test
    public void testsmallRectFour() {
    	
    	assertEquals(true, sudoku.smallRectFour());
    	
    }
    @Test
    public void testsmallRectFive() {
    	
    	assertEquals(true, sudoku.smallRectFive());
    	
    }
    @Test
    public void testsmallRectSix() {
    	
    	assertEquals(true, sudoku.smallRectSix());
    	
    }
    @Test
    public void testsmallRectSeven() {
    	
    	assertEquals(true, sudoku.smallRectSeven());
    	
    }
    @Test
    public void testsmallRectEight() {
    	
    	assertEquals(true, sudoku.smallRectEight());
    	
    }
    @Test
    public void testsmallRectNine() {
    	
    	assertEquals(true, sudoku.smallRectNine());
    	
    }

	@Test
	public void testRectColOne(){
		
		assertEquals(true, sudoku.RectColOne());
		
	}
	@Test
	public void testRectColTwo(){
		
		assertEquals(true, sudoku.RectColTwo());
		
	}
	@Test
	public void testRectColThree(){
		
		assertEquals(true, sudoku.RectColThree());
		
	}
	@Test
	public void testRectRowOne(){
		assertEquals(true, sudoku.RectRowOne());
		
	}
	@Test
	public void testRectRowTwo(){
		assertEquals(true, sudoku.RectRowTwo());
		
	}
	@Test
	public void testRectRowThree(){
		assertEquals(true, sudoku.RectRowThree());
		
	}
}
