package interview.arrays;

public class RotatedArray {

	public static int findMin(int[] a) {
		return findMin(a, 0, a.length - 1);
	}
	
	private static int findMin(int[] a, int lo, int hi) {
		if (lo == hi) {
			return a[lo];
		}
		int med = lo + ((hi - lo) >>> 1);
		return a[med] < a[hi] ? findMin(a, lo, med) : findMin(a, med + 1, hi);
	}
}
