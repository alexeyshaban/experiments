package interview.recursion;

import static interview.recursion.StringPermutations.permutations;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringPermutationsTest {

	@Test
    public void compare()  {
		String s = "0123456789";
		int expected = 1;
		for (int i = s.length(); i > 1; i--) {
			expected *= i;
		}
		assertEquals(expected, permutations(s).size());
    }
}
