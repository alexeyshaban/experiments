package interview.arrays;


public class JumpsToEndArray {

	static int minJumpsDynamic(int[] a) {
		int[] jumps = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (jumps[j] != Integer.MAX_VALUE && a[j] >= i - j) {
					jumps[i] = jumps[j] + 1;
					break;
				}
			}
		}
		return jumps[jumps.length - 1];
	}

	public static int minJumpsGreedy(int a[]) {
		int jumps = 0;
		for (int i = 0; i < a.length;) {
			int max = Integer.MIN_VALUE;
			int next = 0;
			for (int j = 1; j <= a[i]; j++) {
				if (i + j == a.length - 1) {
					return ++jumps;
				}
				int temp = a[i + j] + j;
				if (temp > max) {
					max = temp;
					next = i + j;
				}
			}
			if (next == 0) {
				return Integer.MAX_VALUE;
			}
			jumps++;
			i = next;
		}
		return jumps;
	}
}
