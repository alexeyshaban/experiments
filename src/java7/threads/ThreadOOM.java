package java7.threads;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ThreadOOM {

	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			@Override
			public void run() {
				ArrayList<ArrayList<Integer>> c = new ArrayList<>(1_000_000);
				MainOOM.inflate(c, 20);
			};
		}.start();
		
		while (true) {
			System.out.println("Main alive");
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
