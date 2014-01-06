package interview.collections;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HashTableTest {

	@Test
    public void test() throws Exception {
	    Random r = new Random();
	    HashTable<Integer, Long> actualMap = new HashTable<>(10);
	    HashMap<Integer, Long> expectedMap = new HashMap<>();
	    for (int i = 0; i < 1000; i++) {
            int key = r.nextInt(20);
            boolean put = r.nextBoolean();
            if (put) {
                long value = r.nextLong();
                Long expected = expectedMap.put(key, value);
                Long actual = actualMap.put(key, value);
                assertEquals(expected, actual);
            } else {
                Long expected = expectedMap.get(key);
                Long actual = actualMap.get(key);
                assertEquals(expected, actual);
            }
        }
	    for (Entry<Integer, Long> entry : expectedMap.entrySet()) {
            assertEquals(entry.getValue(), actualMap.get(entry.getKey()));
        }
    }
}
