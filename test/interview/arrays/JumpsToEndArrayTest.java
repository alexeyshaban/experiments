package interview.arrays;

import static interview.arrays.JumpsToEndArray.minJumpsDynamic;
import static interview.arrays.JumpsToEndArray.minJumpsGreedy;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JumpsToEndArrayTest {

	@Test
    public void reachable() {
		assertEquals(4, minJumpsDynamic(new int[] {3, 1, 2, 3, 0, 2, 0, 5, 0}));
		assertEquals(4, minJumpsGreedy(new int[] {3, 1, 2, 3, 0, 2, 0, 5, 0}));
		
		assertEquals(4, minJumpsDynamic(new int[] {1,2,3,4,5,6,7,8,9}));
		assertEquals(4, minJumpsGreedy(new int[] {1,2,3,4,5,6,7,8,9}));
		
		assertEquals(2, minJumpsDynamic(new int[] {3, 8, 3, 5, 8, 7, 6, 7, 8, 1}));
		assertEquals(2, minJumpsGreedy(new int[] {3, 8, 3, 5, 8, 7, 6, 7, 8, 1}));
    }
	
	@Test
    public void unreachable() {
		assertEquals(Integer.MAX_VALUE, minJumpsDynamic(new int[] {0, 0, 0, 0, 0, 5, 5}));
		assertEquals(Integer.MAX_VALUE, minJumpsGreedy(new int[] {3, 1, 2, 1, 0, 2, 0, 5}));
    }
	
	@Test
    public void compare() {
		Random r = new Random();
		for (int i = 0; i < 10_000; i++) {
			int[] a = new int[1000];
			for (int j = 0; j < a.length; j++) {
				a[j] = r.nextInt(10);
			}
			assertEquals(minJumpsDynamic(a), minJumpsGreedy(a));
		}
	}
}
