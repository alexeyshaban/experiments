package interview.numbers;

public class NumIntsWithout4 {

	private static boolean contains4(int n) {
		while (n > 0) {
			if (n % 10 == 4) {
	            return true;
            }
			n = n / 10;
		}
		return false;
	}
	
	static int brute(int N) {
		int cnt = 0;
		for (int i = 1; i < N; i++) {
	        if (!contains4(i)) {
	            cnt++;
            }
        }
		return cnt;
	}
	
	static int normalize (int N) {
		int m = N, k = N, d = -1;
		for (int i = 0; m > 0; i++, m = m / 10) {
	        if (m % 10 == 4) {
	            d = i;
	            k = N / (int) Math.pow(10, i);
            }
        }
		if (d >= 0) {
	        k = k * (int) Math.pow(10, d) - 1;
        }
		return k;
	}
	
	static int fast (int N) {
		int n = normalize(N);
		int m = n == N ? 1 : 0;
		int cnt = 0;
		int p = 0;
		while (n > 0) {
			int i = n % 10;
			if (i > 4) {
	            i--;
            }
	        cnt += i * Math.pow(9, p++);
	        n = n / 10;
        }
		return cnt - m;
	}
}
