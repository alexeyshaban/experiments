package interview.recursion;

/**
 * Calculate number of paths in a square grid from top left to bottom right,
 * if moving down or right.
 */
public class NumberOfPaths {

	static int numPathsDynamic(int m, int n) {
		int[][] paths = new int[m][n];
		for (int i = 0; i < paths.length; i++) {
			paths[i][0] = 1;
		}
		for (int j = 0; j < paths[0].length; j++) {
			paths[0][j] = 1;
		}
		for (int i = 1; i < paths.length; i++) {
			for (int j = 1; j < paths[0].length; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		return paths[m - 1][n - 1];
	}

	/**
	 * C(m - 1 + n - 1, m - 1)
	 */
	static int numPathsCombinatorics(int m, int n) {
		int a = Math.max(m, n);
		int b = Math.min(m, n);
		
		long result = 1;
		int cnt = 0;
		for (int i = a; i <= m + n - 2; i++) {
			result *= i;
			if (++cnt <= b - 1) {
				result /= cnt;
			}
		}
		for (int i = cnt + 1; i <= b - 1; i++) {
			result /= i;
		}
		return (int) result;
	}
}
