package interview.numbers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MediumTest {

	@Test
	public void test() throws Exception {
		int a = Integer.MAX_VALUE / 2;
		int b = Integer.MAX_VALUE;
		int expected = a + (b - a) / 2;
		assertEquals(expected, (b + a) >>> 1);
		assertNotEquals(expected, (b + a) / 2);
		assertNotEquals(expected, (b + a) >> 1);
	}
}
