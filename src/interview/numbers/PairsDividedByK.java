package interview.numbers;

public class PairsDividedByK {

    static boolean allPairsDividedBy(int[] a, int k) {
        int[] b = new int[k];
        for (int i = 0; i < a.length; i++) {
            int r = a[i] % k;
            int j = (k - r) % k;
            if (b[j] > 0) {
                b[j]--;
            } else {
                b[r]++;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
