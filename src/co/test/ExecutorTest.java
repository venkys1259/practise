package co.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPool implements Runnable{

	String cmd;
	ThreadPool(String s){
		this.cmd = s;
	}
	
	@Override
	public void run() {
     
		System.out.println(Thread.currentThread().getName() + cmd  );
		
	}
	
	
	
}

public class ExecutorTest {

	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i = 0; i<10;i++) {
		Runnable runnable = new ThreadPool("" + i);
		exec.execute(runnable);
		}
		
		exec.shutdown();

	}

}
