package interview.arrays;

import static interview.arrays.RotatedArray.findMin;
import static org.junit.Assert.*;
import interview.collections.Entry;
import interview.collections.InvertSingleLinked;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RotatedArrayTest {

	@Test
    public void rotate1() throws Exception {
		assertEquals(7, findMin(new int[] {7}));
    }

	@Test
    public void rotate2inc() throws Exception {
		assertEquals(7, findMin(new int[] {7, 9}));
    }

	@Test
    public void rotate2dec() throws Exception {
		assertEquals(7, findMin(new int[] {9, 7}));
    }
	
	@Test
    public void rotate3inc() throws Exception {
		assertEquals(1, findMin(new int[] {1, 2, 3}));
    }
	
	@Test
    public void rotate3dec() throws Exception {
		assertEquals(1, findMin(new int[] {2, 3, 1}));
    }

	@Test
    public void rotate5mid() throws Exception {
		assertEquals(1, findMin(new int[] {4, 5, 1, 2, 3}));
    }

	@Test
    public void rotate4_1() throws Exception {
		assertEquals(1, findMin(new int[] {1, 2, 3, 4}));
    }

	@Test
    public void rotate4_2() throws Exception {
		assertEquals(1, findMin(new int[] {4, 1, 2, 3}));
    }

	@Test
    public void rotate4_3() throws Exception {
		assertEquals(1, findMin(new int[] {3, 4, 1, 2}));
    }

	@Test
    public void rotate4_4() throws Exception {
		assertEquals(1, findMin(new int[] {2, 3, 4, 1}));
    }
	
	@Test
    public void rotate5hi() throws Exception {
		assertEquals(1, findMin(new int[] {2, 3, 4, 5, 1}));
    }

	@Test
    public void rotate5lo() throws Exception {
		assertEquals(1, findMin(new int[] {1, 2, 3, 4, 5}));
    }
}
