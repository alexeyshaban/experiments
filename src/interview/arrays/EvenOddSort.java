package interview.arrays;

public class EvenOddSort {

	static void sortBidirectional(int[] a) {
		if (a == null || a.length < 2) {
			return;
		}
		int l = 0, r = a.length - 1;
		while (true) {
			while (l < r && a[l] % 2 == 0) {
				l++;
			}
			while (l < r && a[r] % 2 != 0) {
				r--;
			}
			if (l < r) {
				int tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
			} else {
				break;
			}
		}
	}
	
	static void sortLeftToRight(int[] a) {
		if (a == null || a.length < 2) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] % 2 == 0) {
						int tmp = a[i];
						a[i] = a[j];
						a[j] = tmp;
						break;
					}
				}
			}
		}
	}
}
