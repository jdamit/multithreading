package com.thread.syn.example;

public class ThreadComSyn {

	public static void main(String[] args) {
		ChildThreadSyn ct = new ChildThreadSyn();
		ct.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(ct){
			try {
				System.out.println(Thread.currentThread()+" calling wait() method." );
				ct.wait();
				System.out.println(Thread.currentThread()+" got notification." );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(ct.total);
		}

	}

}

class ChildThreadSyn extends Thread{
	int total = 0;
	public void run(){
		synchronized(this){
			System.out.println(Thread.currentThread()+" start calculation.");
			for(int i=0; i<=100; i++){
				total = total + i;
			}
			System.out.println(Thread.currentThread()+" notifying main thread.");
			this.notify();
		}
		for(int i = 0; i<10; i++){
			System.out.print(i);
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}