package interview.recursion;

import static interview.recursion.NumberOfPaths.numPathsCombinatorics;
import static interview.recursion.NumberOfPaths.numPathsDynamic;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NumberOfPathsTest {

	@Test
    public void compare()  {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				assertEquals(numPathsCombinatorics(i, j), numPathsDynamic(i, j));
			}
		}
		int i = 10, j = 10;
		assertEquals(numPathsCombinatorics(i, j), numPathsDynamic(i, j));
		i = 30; j = 10;
		assertEquals(numPathsCombinatorics(i, j), numPathsDynamic(i, j));
		i = 10; j = 30;
		assertEquals(numPathsCombinatorics(i, j), numPathsDynamic(i, j));
		i = 30; j = 22;
		assertEquals(numPathsCombinatorics(i, j), numPathsDynamic(i, j));
		i = 30; j = 18;
		assertEquals(numPathsCombinatorics(i, j), numPathsDynamic(i, j));
    }
}
