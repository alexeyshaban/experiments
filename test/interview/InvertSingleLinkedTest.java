package interview;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InvertSingleLinkedTest {

	@Test
    public void testInvertNull() throws Exception {
		assertNull(InvertSingleLinked.invert(null));
		assertNull(InvertSingleLinked.invertRecursive(null));
    }
	
	@Test
    public void testInvertSingle() throws Exception {
		Entry<Integer> head = new Entry<>(123, null);
		Entry<Integer> invert = InvertSingleLinked.invert(head);
		assertEquals(123, invert.value.intValue());
		assertNull(invert.next);
		
		invert = InvertSingleLinked.invertRecursive(head);
		assertEquals(123, invert.value.intValue());
		assertNull(invert.next);
    }
	

	@Test
    public void testInvert() throws Exception {
		Entry<Integer> head = new Entry<>(1,
				new Entry<>(2,
						new Entry<>(3,
								new Entry<>(4, null))));

		System.out.println(head);
		
		Entry<Integer> invert = InvertSingleLinked.invert(head);
		System.out.println(invert);
		head = invert;
		
		assertEquals(4, invert.value.intValue());
		invert = invert.next;
		assertEquals(3, invert.value.intValue());
		invert = invert.next;
		assertEquals(2, invert.value.intValue());
		invert = invert.next;
		assertEquals(1, invert.value.intValue());
		assertNull(invert.next);
		
		
		Entry<Integer> invertBack = InvertSingleLinked.invertRecursive(head);
		System.out.println(invertBack);
		assertEquals(1, invertBack.value.intValue());
		invertBack = invertBack.next;
		assertEquals(2, invertBack.value.intValue());
		invertBack = invertBack.next;
		assertEquals(3, invertBack.value.intValue());
		invertBack = invertBack.next;
		assertEquals(4, invertBack.value.intValue());
		assertNull(invertBack.next);
    }
}
