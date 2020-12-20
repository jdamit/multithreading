package com.thread.example;

public class JoinExample {

	public static void main(String[] args) {
		ChildThreadJoin.mainThread = Thread.currentThread();
		Thread t = new Thread(new ChildThreadJoin());
		t.start();
		for(int i = 0; i<10; i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main thread.");
		}
		System.out.println("-------------------------------");
		/*Thread thread = new Thread(new ThreadJoin());
		thread.start();
		try {
			//thread.join();
			thread.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i<10; i++){
			System.out.println("Main thread.");
		}*/

	}

}

class ThreadJoin implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Child thread.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
/*
 * Child thread has to wait until main thread completed
 */
class ChildThreadJoin implements Runnable{

	static Thread mainThread;
	@Override
	public void run() {
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0; i<10; i++){
			System.out.println("Child thread.");
		}
		
	}
	
}
