package interview;

import java.util.Stack;

public class Brackets {

	public static boolean isBalanced(String str) {
		if (str == null) {
	        return false;
        }
		Stack<Byte> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (c == '(' || c == '{' || c == '[') {
	            s.push((byte) c);
            } else if (c == ')' || c == '}' || c == ']') {
            	if (s.isEmpty()) {
	                return false;
                }
				char p = (char) s.pop().byteValue();
				if (c == ')' && p != '(' || c == ']' && p != '[' || c == '}' && p != '{') {
	                return false;
                }
			}
        }
		return s.isEmpty();
	}
}
