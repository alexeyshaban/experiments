package java7.threads;

import java.util.ArrayList;

public class MainOOM {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<ArrayList<Integer>> c = new ArrayList<>(1_000_000);
		try {
			inflate(c, 2);
		} catch (OutOfMemoryError e) {
			// expected
		}
		
		// and repeat with a new list
		c = null; // fatal OOM without this
		c = new ArrayList<>(1_000_000);
		inflate(c, 2);
	}

	static void inflate(ArrayList<ArrayList<Integer>> c, int allowedOOMs) {
		long i = 0;
		int t = 0;
		while (true) {
			try {
				c.add(new ArrayList<Integer>(1024));
				System.out.println(i++);
			} catch (OutOfMemoryError e) {
				System.out.println(e);
				if (++t > allowedOOMs) {
					throw e;
				}
			}
		}
	}

}
