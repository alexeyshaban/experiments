package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class StreamFilterPerformance {

	public static void main(String[] args) {
		String[] a = new String[] {"abc", "", "def", "", "xyz"};
		int N = Integer.parseInt(args[0]);
		long time = System.nanoTime();
		for (int i = 0; i < N; i++) {
			Arrays.stream(a).filter(s -> !s.isEmpty()).count();
        }
		time = System.nanoTime() - time;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(time));
		
		time = System.nanoTime();
		for (int i = 0; i < N; i++) {
			Arrays.stream(a).unordered().parallel().filter(s -> !s.isEmpty()).count();
        }
		time = System.nanoTime() - time;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(time));
	}

}
