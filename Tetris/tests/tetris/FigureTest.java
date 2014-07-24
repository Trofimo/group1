package tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class FigureTest {

	@Test
	public void testData() {
		Figure figure = Figure.randomFigure();
		assertNotNull(figure.data);
		assertEquals(4, figure.data.length);
		assertEquals(4, figure.data[0].length);
	}

	@Test
	public void testFigureData() throws Exception {
		assertNotNull(Figure.figureData);
		assertEquals(19, Figure.figureData.size());
	}
	
}
