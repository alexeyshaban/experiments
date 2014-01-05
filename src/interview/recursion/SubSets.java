package interview.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {

	static <T> List<Set<T>> iterative(Set<T> set) {
		int size = 1 << set.size();
		List<Set<T>> result = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			int j = 0;
			Set<T> subSet = new HashSet<>();
			for (T t : set) {
				if ((i & (1 << j)) != 0) {
					subSet.add(t);
				}
				j++;
			}
			result.add(subSet);
		}
		return result;
	}
	
	static <T> List<Set<T>> recursive(T[] set) {
		return recursive(set, set.length - 1);
	}
	
    private static <T> List<Set<T>> recursive(T[] set, int from) {
		if (from == 0) {
			List<Set<T>> current = new ArrayList<>();
			HashSet<T> withCurrent = new HashSet<T>();
			withCurrent.add(set[0]);
			current.add(withCurrent);
			current.add(new HashSet<T>());
			return current;
		} else {
			List<Set<T>> rec = recursive(set, from - 1);
			for (int i = rec.size() - 1; i >= 0; i--) {
				HashSet<T> withCurrent = new HashSet<T>(rec.get(i));
				withCurrent.add(set[from]);
				rec.add(withCurrent);
			}
			return rec;
		}
	}
}
