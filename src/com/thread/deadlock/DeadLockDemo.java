package com.thread.deadlock;

public class DeadLockDemo extends Thread{
	DeadLockA a = new DeadLockA();
	DeadLockB b = new DeadLockB();
	
	public void createThread(){
		this.start();
		a.deadLockMethodA(b);
	}
	
	public void run(){
		b.deadLockMethodB(a);
	}
	public static void main(String[] args) {
		DeadLockDemo thread = new DeadLockDemo();
		thread.createThread();
	}
}
