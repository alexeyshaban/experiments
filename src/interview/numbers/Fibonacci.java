package interview.numbers;

public class Fibonacci {

    static long iterative(int n) {
        if (n < 2) {
            return n;
        }
        long prev = 0, result = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = result;
            result += prev;
            prev = tmp;
        }
        return result;
    }
    
    static long tailRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return tailRecursive(n, 1, 1);
    }
    
    private static long tailRecursive(int n, long current, long prev) {
        if (n == 2) {
            return current;
        }
        return tailRecursive(n - 1, current + prev, current);
    }
    
    private static long[] memo = null;
    static long recursive(int n) {
        if (n < 2) {
            return n;
        }
        memo = new long[n];
        memo[1] = 1;
        return recursiveMemoization(n);
    }
    
    private static long recursiveMemoization(int n) {
        if (n == 2) {
            return 1;
        }
        long n2 = memo[n - 2];
        if (n2 == 0) {
            memo[n - 2] = n2 = recursiveMemoization(n - 2);
        }
        long n1 = memo[n - 1];
        if (n1 == 0) {
            memo[n - 1] = n1 = recursiveMemoization(n - 1);
        }
        return n1 + n2;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i <= 90; i++) {
            System.out.printf("%s %s %s\n", iterative(i), tailRecursive(i), recursive(i));
        }
        
        
        int N = 1000000;
        long time = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            iterative(90);
        }
        System.out.println("iterative " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            tailRecursive(90);
        }
        System.out.println("tailRecursive " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            recursive(90);
        }
        System.out.println("recursive " + (System.currentTimeMillis() - time));
    }
}
