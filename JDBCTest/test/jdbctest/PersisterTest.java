package jdbctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersisterTest {

	@Test
	public void test() {
		User fakeuser=new User("Mike","321","mike@mail.ru");
		Persister.persist(fakeuser);
		assertTrue(Persister.tables.size()>0);
		assertEquals("User", Persister.tables.get(0));
	}

}
