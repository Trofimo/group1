package balanstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import balans.Balans;

public class BalansTest {

	private Balans b=new Balans();
	private int[] _a;
	@Test
	public void testNotBalanced() {
		_a=new int[]{1,5,6,7,10};
		assertEquals(-1, b.balans(_a));
		
		
	}

	@Test
	public void testBalanced() {
		
		_a=new int[]{1,5,6,7,9,10};
		assertEquals(3, b.balans(_a));
		
	}
	
}
