package jdbctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersisterTest {

	@Test
	public void test() {
		Persister.persist("one");
		assertTrue(Persister.tables.size()>0);
		assertEquals("Users", Persister.tables.get(0));
	}

}
