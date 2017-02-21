package co.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class TestMultiThread {

	public static void main(String[] args) throws InterruptedException { 

		String paragraph = "This is to test how multithreading works in Java";
		LinkedBlockingQueue queue = new LinkedBlockingQueue(paragraph.length());
		String[] words = paragraph.split(" ");	
		for(String word: words) {
			queue.put(word);
		}
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(int i =0; i< words.length;i++) {
		service.submit(new printThread(queue));
		}
		service.shutdown();
		
	}
	
	

}
class printThread implements Runnable{
	LinkedBlockingQueue queue;
	printThread(LinkedBlockingQueue queue){
		this.queue = queue;
	}
	public void run() {
		synchronized (queue) {
			System.out.println(Thread.currentThread().getName() + " " + queue.poll());
		}
	}
	
	public  synchronized  void printTask() {
		
	

	}
	
	
}