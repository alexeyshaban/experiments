package interview.arrays;

import static org.junit.Assert.assertArrayEquals;
import interview.arrays.SortAlgs.Alg;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SortAlgsTest {
	private static Random R = new Random();

	private void test(Alg alg) throws Exception {
		for (int i = 0; i < 1000; i++) {
			int[] a = new int[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = R.nextInt();
			}
			int[] b = Arrays.copyOf(a, a.length);
			alg.sort(a);
			Arrays.sort(b);
			assertArrayEquals(b, a);
		}
    }
	
	@Test
    public void insertion() throws Exception {
		test(new SortAlgs.Insertion());
	}
	
	@Test
    public void mergeBottomUp() throws Exception {
		test(new SortAlgs.MergeBottomUp());
	}
	
	@Test
    public void midPivotQsort() throws Exception {
		test(new SortAlgs.MidPivotQsort());
	}
}
