package interview.strings;

public class RLE {

	static String encode(String s) {
		char prev = 0;
		int count = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (count == 0) {
				result.append(prev = c);
				count = 1;
			} else if (c == prev) {
				count++;
			} else {
				if (count > 1) {
					result.append(count);
				}
				result.append(prev = c);
				count = 1;
			}
		}
		if (count > 1) {
			result.append(count);
		}
		return result.toString();
	}
}
