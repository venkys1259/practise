package co.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksExample {

	public static void main(String[] args) {
		
		Lock machine = new ReentrantLock();
		/*Person p1 = new Person(machine,"venky");
		Person p2 = new Person(machine,"chintu");
		Person p3 = new Person(machine,"latha");
		p1.start();
		p2.start();
		p3.start();*/

	}

}
/*class Person1 extends  Thread {
	Lock machine;
	String name;
	Person1(Lock machine, String name){
		this.machine = machine;
		this.name = name;
	}
	public void run() {
		System.out.println(this.name + " is waiting to go inside" );
		this.machine.lock();
		System.out.println(this.name + " withdrawing the money");
		this.machine.unlock();
		System.out.println(this.name + "Job is done");
		
	}*/

