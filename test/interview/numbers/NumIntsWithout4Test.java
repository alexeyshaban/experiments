package interview.numbers;

import static org.junit.Assert.*;
import interview.numbers.NumIntsWithout4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NumIntsWithout4Test {

	@Test
	public void test() throws Exception {
		int[] a = { 1, 2, 3, 4, 5, 9, 10, 11, 19, 39, 40, 43, 44, 45, 49, 50,
		        99, 100, 101, 103, 104, 105, 999, 1404, 1323234 };
		for (int i : a) {
			assertEquals("Testing " + i, NumIntsWithout4.brute(i),
			        NumIntsWithout4.fast(i));
		}
	}
	
	@Test
    public void testNormalize() throws Exception {
		assertEquals(3, NumIntsWithout4.normalize(4));
		assertEquals(3651, NumIntsWithout4.normalize(3651));
		assertEquals(1399, NumIntsWithout4.normalize(1404));
    }
}
