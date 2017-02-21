package co.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ATM {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			service.execute(new ATMOperation(latch, i));
			latch.countDown();
		}
		service.shutdown();

		/*for (int i = 0; i < 10; i++) {
			ATMOperation a = new ATMOperation(latch, i);
			Thread t = new Thread(a);
			t.start();

		}
*/
	}

}

class ATMOperation implements Runnable {
	CountDownLatch latch;
	int i;

	ATMOperation(CountDownLatch latch, int i) {
		this.latch = latch;
		this.i = i;
	}

	public void run() {
		System.out.println("Person" + i + "entered into ATM Room By " + Thread.currentThread().getName());
		try {
			this.latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}