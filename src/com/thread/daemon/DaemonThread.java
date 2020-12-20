package com.thread.daemon;

public class DaemonThread {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.setDaemon(true);
		System.out.println("Daemon nature of "+thread.getName()+ " "+thread.isDaemon());
		thread.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End of "+Thread.currentThread());
	}

}

class MyThread extends Thread{
	@Override
	public void run(){
		for(int i=0; i<=10; i++){
			System.out.println("Child thread.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
