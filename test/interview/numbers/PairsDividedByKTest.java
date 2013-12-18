package interview.numbers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PairsDividedByKTest {

    @Test
    public void testPositive() throws Exception {
        assertTrue(PairsDividedByK.allPairsDividedBy(
                new int[] { 5, 3, 3, 3, 2, 1, 4, 3 }, 3));
        assertTrue(PairsDividedByK.allPairsDividedBy(
                new int[] { 49, 63, 1, 2, 3, 4, 5, 6 }, 7));
    }
    
    @Test
    public void testNegative() throws Exception {
        assertFalse(PairsDividedByK.allPairsDividedBy(
                new int[] { 5, 3, 3, 8, 2, 1, 4, 3 }, 3));
        assertFalse(PairsDividedByK.allPairsDividedBy(
                new int[] { 49, 62, 1, 2, 3, 4, 5, 6 }, 7));
    }
}
