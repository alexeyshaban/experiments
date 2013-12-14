package interview;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StackBasedQueueTest {

	@Test
    public void test() throws Exception {
		StackBasedQueue<Integer> q = new StackBasedQueue<>();
		q.enqueue(1).enqueue(2).enqueue(3).enqueue(4);
		assertEquals(1, q.dequeue().intValue());
		assertEquals(2, q.dequeue().intValue());
		assertEquals(3, q.dequeue().intValue());
		assertEquals(4, q.dequeue().intValue());
    }
	
}