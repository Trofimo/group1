package tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {

	@Test
	public void testWidthHeight() {
		assertEquals(20, Field.HEIGHT);
		assertEquals(9, Field.WIDTH);
	}
	
	@Test
	public void testBox() throws Exception {
		Field field = new Field();
		assertNotNull(field.box);
		assertEquals(20, field.box.length);
		assertEquals(9, field.box[0].length);
	}
	
	@Test
	public void testRemoveFullRows() throws Exception {
		Field field = new Field();
		field.box = new int[][] {
				{2,0,0},	
				{1,1,1},	
				{0,2,0},	
				{1,1,1},	
		};
		/*
		 * 		{0,0,0},	
				{0,0,0},	
				{2,0,0},	
				{0,2,0},	

		 * 
		 * 
		 */
		field.removeFullRows();
		
		assertEquals(2, field.box[2][0]);
		assertEquals(0, field.box[2][1]);
		assertEquals(0, field.box[2][2]);
		
		assertEquals(0, field.box[3][0]);
		assertEquals(2, field.box[3][1]);
		assertEquals(0, field.box[3][2]);
	}

}
