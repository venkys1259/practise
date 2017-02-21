package co.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	public static void main(String[] args) {
		 int counter = 0;
		 AtomicInteger atomicCounter = new AtomicInteger(0);

		AtomicTest test = new AtomicTest();
		ExecutorService service = Executors.newFixedThreadPool(5);
		for(int i = 0; i<500;i++) {
		service.submit(new NormalCounter());
		service.submit(new AtomicCounter());
		}
		service.shutdown();
		
		/*ExecutorService service2 = Executors.newFixedThreadPool(5);
		for(int i = 0; i<5;i++) {
		service2.submit(new NormalCounter(counter));
		}*/
	    //service2.shutdown();	
	
		
		/*Thread t = new Thread(new NormalCounter(test.counter));
		t.start();*/
	}

}

class NormalCounter implements Runnable{
	private static int counter;
	public void run() {
	counter++;
	System.out.println("Counter Value is " +counter);
	}
}

class AtomicCounter implements Runnable{
	private static AtomicInteger counter = new AtomicInteger(0);
	public void run() {
	System.out.println("Atomic Counter Value is " +counter.incrementAndGet());
	}
}