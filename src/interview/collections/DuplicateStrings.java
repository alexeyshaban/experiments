package interview.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateStrings {

	public static List<String> removeDuplicates(ArrayList<String> l) {
		Set<String> s = new HashSet<>();
		int i = 0;
		while (i < l.size()) {
			String current = l.get(i);
			if (s.add(current)) {
				i++;
			} else {
				l.set(i, l.get(l.size() - 1));
				l.remove(l.size() - 1);
			}
		}
		return l;
	}
	
	public static List<String> removeDuplicatesWithStream(Collection<String> l) {
		return l.stream().distinct().sorted().collect(Collectors.<String>toList());
	}
}
