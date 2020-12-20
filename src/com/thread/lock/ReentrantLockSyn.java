package com.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSyn {

	public static void main(String[] args) {
		Display display = new Display();
		ReentrantThread thread1 = new ReentrantThread(display, "Dhoni");
		ReentrantThread thread2 = new ReentrantThread(display, "Yuvarj");
		//thread1.start();
		//thread2.start();
		
		//demo code for tryLock()
		ReentrantThreadTryLock tryThread1 = new ReentrantThreadTryLock("'First thread'");
		ReentrantThreadTryLock tryThread2 = new ReentrantThreadTryLock("'Second thread'");
		tryThread1.start();
		tryThread2.start();
	}

}

class Display{
	ReentrantLock lock = new ReentrantLock();
	public void wish(String name){
		//synchronized(this){
		lock.lock();
			for(int i = 0; i < 10; i++){
				System.out.print("Good Morning : ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		lock.unlock();
		//}
	}
}

class ReentrantThread extends Thread{
	Display display;
	String name;
	
	ReentrantThread(Display display,String name){
		this.display = display;
		this.name = name;
	}
	
	@Override
	public void run(){
		display.wish(name);
	}
}

/**
 * Example of tryLock()
 *
 */
class ReentrantThreadTryLock extends Thread{
	
	/**
	 * only for having only one lock object for multiple threads
	 */
	static ReentrantLock lock  = new ReentrantLock();
	/**
	 * 
	 * @param name : associate name to the created thread.
	 */
	ReentrantThreadTryLock(String name){
		super(name);
	}
	@Override
	public void run(){
		if(lock.tryLock()){
			System.out.println(Thread.currentThread().getName()+" got lock and performing safe operations");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			lock.unlock();
		}else{
			System.out.println(Thread.currentThread().getName()+" unable to get lock and hence performing other operations");
		}
	}
}