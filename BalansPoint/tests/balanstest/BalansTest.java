package balanstest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import balans.Balans;

public class BalansTest {
	private int[] _a;
	private Balans b=new Balans();
	@Before
	public void setup(){
		_a=new int[]{1,5,6,7,10};
		
	}
	@Test
	public void test() {
		assertEquals(-1, b.balans(_a));
		
	}

}
