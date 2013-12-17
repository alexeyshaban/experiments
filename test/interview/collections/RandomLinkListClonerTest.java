package interview.collections;

import static org.junit.Assert.*;
import interview.collections.Entry;
import interview.collections.InvertSingleLinked;
import interview.collections.RandomLinkListCloner.Item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RandomLinkListClonerTest {

	@Test
    public void cloneExtraN() throws Exception {
		Item<Integer> first = create();
		first = RandomLinkListCloner.cloneExtraN(first);
		check(first);
    }
	
	@Test
    public void cloneNoExtra() throws Exception {
		Item<Integer> first = create();
		first = RandomLinkListCloner.cloneNoExtra(first);
		check(first);
    }
	
	private Item<Integer> create() {
		Item<Integer> first = new Item<Integer>(1);
		Item<Integer> second = new Item<Integer>(2);
		Item<Integer> third = new Item<Integer>(3);
		Item<Integer> fourth = new Item<Integer>(3);
		Item<Integer> fifth = new Item<Integer>(5);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		first.random = second;
		second.random = fourth;
		third.random = fourth;
		fourth.random = second;
		fifth.random = fifth;
		return first;
	}

	private void check(Item<Integer> first) {
		assertEquals(1, first.value.intValue());
		Item<Integer> second = first.next;
		assertEquals(2, second.value.intValue());
		Item<Integer> third = second.next;
		assertEquals(3, third.value.intValue());
		Item<Integer> fourth = third.next;
		assertEquals(3, fourth.value.intValue());
		Item<Integer> fifth = fourth.next;
		assertEquals(5, fifth.value.intValue());
		
		assertEquals(second, first.random);
		assertEquals(fourth, second.random);
		assertEquals(fourth, third.random);
		assertEquals(second, fourth.random);
		assertEquals(fifth, fifth.random);
	}
}
