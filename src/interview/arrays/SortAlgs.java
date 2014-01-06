package interview.arrays;

import java.util.Arrays;

public class SortAlgs {

	interface Alg {
		void sort(int[] a);
	}
	
	static class Insertion implements Alg {
		@Override
		public void sort(int[] a) {
			for (int i = 1; i < a.length; i++) {
				for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
					swap(a, j, j - 1);
				}
			}
		}
	}
	
	static class MergeBottomUp implements Alg {
		private static void merge(int[] a, int lo, int mid, int hi) {
			int[] b = new int[hi - lo + 1];
			int i = lo, j = mid + 1;
			for (int k = 0; k < b.length; k++) {
				if (i > mid) {
					b[k] = a[j++];
				} else if (j > hi) {
					b[k] = a[i++];
				} else if (a[i] < a[j]) {
					b[k] = a[i++];
				} else {
					b[k] = a[j++];
				}
			}
			System.arraycopy(b, 0, a, lo, b.length);
		}
		@Override
		public void sort(int[] a) {
			for (int size = 1; size < a.length; size += size) {
				for (int i = 0; i < a.length - size; i += 2 * size) {
					merge(a, i, i + size - 1, Math.min(i + 2 * size - 1, a.length - 1));
				}
			}
		}
	}
	
	static abstract class QsortBase implements Alg {
		@Override
		public void sort(int[] a) {
			sort(a, 0, a.length - 1);
		}

		private void sort(int[] a, int lo, int hi) {
			if (lo >= hi) {
				return;
			}
			int p = partition(a, lo, hi);
			sort(a, lo, p - 1);
			sort(a, p + 1, hi);
		}

		protected abstract int partition(int[] a, int lo, int hi);
	}
	
	static class MidPivotQsort extends QsortBase {
		@Override
		protected int partition(int[] a, int lo, int hi) {
			int mid = (lo + hi) >>> 1;
			int pivot = a[mid];
			swap(a, mid, lo);
			int i = lo, p = hi + 1;
			while (true) {
				while (a[++i] < pivot)
					if (i == hi)
						break;
				while (pivot < a[--p])
					if (p == lo)
						break;
				if (i >= p)
					break;
				swap(a, i, p);
			}
			swap(a, lo, p);
			return p;
		}
	}
	
	static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
