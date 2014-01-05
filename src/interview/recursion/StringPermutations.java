package interview.recursion;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

	static Collection<String> permutations(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() < 2) {
			return Collections.singleton(s);
		}
		Collection<String> remainder = permutations(s.substring(1));
		Set<String> result = new HashSet<String>(remainder.size() * s.length(), 1);
		for (String string : remainder) {
			for (int i = 0; i <= string.length(); i++) {
				result.add(string.substring(0, i) + s.charAt(0) + string.substring(i));
			}
		}
		return result;
	}
}
