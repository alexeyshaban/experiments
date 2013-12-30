package interview.strings;

import java.util.BitSet;

public class AllUniqueChars {

	public static boolean allUnique(String str) {
		BitSet b = new BitSet(256);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (b.get(c)) {
				return false;
			}
			b.set(c);
		}
		return true;
	}
}
