package interview.collections;

import static interview.collections.DuplicateStrings.removeDuplicates;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DuplicateStringsTest {

	@Test
    public void testArrayList() throws Exception {
		ArrayList<String> a = new ArrayList<>(Arrays.asList(new String[] {
				"abc", "abc", "abc", "xyz", "a", "abc"
		}));
		assertArrayEquals(
				new String[] {"abc", "a", "xyz"},
				removeDuplicates(a).toArray(new String[] {}));
    }
	
	@Test
    public void testStream() throws Exception {
		ArrayList<String> a = new ArrayList<>(Arrays.asList(new String[] {
				"abc", "abc", "abc", "xyz", "a", "abc"
		}));
		assertArrayEquals(
				new String[] {"a", "abc", "xyz"},
				DuplicateStrings.removeDuplicatesWithStream(a).toArray(new String[] {}));
    }
}
