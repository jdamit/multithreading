package com.thread.deadlock;

public class DeadLockA {
	
	public synchronized void deadLockMethodA(DeadLockB b){
		System.out.println(Thread.currentThread()+" start execution..!!!");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread()+" trying to call DeadLockB's last method.");
		b.lastB();
	}
	
	public synchronized void lastA(){
		System.out.println(Thread.currentThread()+" executing lastA() method.");
	}

}
