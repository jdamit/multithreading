package com.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFacts {

	public static void main(String[] args) {
		Thread thread = new Thread(()->System.out.println("Child thread"));
		thread.start();
		ReentrantLock lock = new ReentrantLock();
		if(lock.tryLock()){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		System.out.println("Locked by thread: "+lock.isLocked());
	}

}
