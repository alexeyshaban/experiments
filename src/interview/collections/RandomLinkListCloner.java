package interview.collections;

import java.util.HashMap;
import java.util.Map;

public class RandomLinkListCloner {

	static class Item<V> {
		V value;
		Item<V> next;
		Item<V> random;
		public Item(V value) {
			this.value = value;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return System.identityHashCode(this) + " " + value + ' ' + next;
		}
	}
	
	static <V> Item<V> cloneExtraN(Item<V> head) {
		Item<V> i = head, result = null, j = null;
		Map<Item<V>, Item<V>> m = new HashMap<>();
		while (i != null) {
			if (result == null) {
				j = result = new Item<V>(i.value);
			} else {
				j.next = new Item<V>(i.value);
				j = j.next;
			}
			m.put(i, j);
			i = i.next;
		}
		i = head;
		j = result;
		while (i != null) {
			j.random = m.get(i.random);
			i = i.next;
			j = j.next;
		}
		return result;
	}
	
	static <V> Item<V> cloneNoExtra(Item<V> head) {
		Item<V> i = head;
		while (i != null) {
			Item<V> next = i.next;
			i.next = new Item<V>(i.value);
			i = i.next.next = next;
		}
		i = head;
		while (i != null) {
			i.next.random = i.random.next;
			i = i.next.next;
		}

		System.out.println(head);
		Item<V> result = head.next;
		i = head;
		while (i != null) {
			Item<V> next = i.next;
			if (i.next != null) {
				i.next = i.next.next;
			}
			i = next;
		}

		return result;
	}

}
