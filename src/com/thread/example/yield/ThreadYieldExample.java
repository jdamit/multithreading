package com.thread.example.yield;

public class ThreadYieldExample {
	
	static Runnable count = ()->{
		Thread.yield();
		int count = 0;
		while(count < 2){
			System.out.println("Thread Name: "+ Thread.currentThread().getName());
			count++;
		}
	};
	
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(count);
		Thread threadB = new Thread(count);
		threadA.start();
		threadB.start();
		
	}
	

}
