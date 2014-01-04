package interview.arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EvenOddSortTest {

	@Test
    public void sortBidirectional() throws Exception {
		int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
		EvenOddSort.sortBidirectional(a);
		assertArrayEquals(new int[] {6, 2, 4, 3, 5, 1, 7}, a);
    }
	
	@Test
    public void sortLeftToRight() throws Exception {
		int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
		EvenOddSort.sortLeftToRight(a);
		assertArrayEquals(new int[] {2, 4, 6, 1, 5, 3, 7}, a);
    }

	@Test
    public void random() throws Exception {
		Random r = new Random();
		for (int i = 0; i < 10_000; i++) {
			int[] a = new int[r.nextInt(100)];
			for (int j = 0; j < a.length; j++) {
				a[j] = r.nextInt();
			}
			int[] b = Arrays.copyOf(a, a.length);
			EvenOddSort.sortBidirectional(a);
			EvenOddSort.sortLeftToRight(b);
			boolean oddMet = false;
			for (int j = 0; j < a.length; j++) {
				if (oddMet) {
					assertNotEquals(0, a[j] % 2);
					assertNotEquals(0, b[j] % 2);
				} else if (a[j] % 2 == 1) {
					oddMet = true;
				}
			}
		}
    }
}
