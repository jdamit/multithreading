package com.thread.example;

public class CreateThread {

	public static void main(String[] args) {
		/*Thread thread = new Thread(()->{
			for(int i =0; i<10; i++){
				System.out.println("Child thread");
				System.out.println(Thread.currentThread().getName());
			}
		});
		thread.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(thread.getPriority());
		for(int i =0; i<10; i++){
			System.out.println("Main thread");
		}*/
		Thread thread = new Thread(new ThreadYield());
		//thread.run();
		thread.start();
		/*thread.setPriority(10);
		Thread.currentThread().setPriority(1);*/
		for(int i =0; i<10; i++){
			System.out.println("Main thread");
		}
		
	}

}

/*
 * if we are not commenting line Thread.yield(); child thread always called yield method because of that main thread 
 * will get more no. of chance and chance of completing main thread high.
 */
class ThreadYield implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Child thread.");
			Thread.yield();// if this line will be commented then both thread execute simultaneously 
		}
		
	}
	
}
