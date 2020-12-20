package com.thread.deadlock;

public class DeadLockB {
	
	public synchronized void deadLockMethodB(DeadLockA a){
		System.out.println(Thread.currentThread()+" start execution..!!!");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread()+" trying to call DeadLockA's last method.");
		a.lastA();
	}
	
	public synchronized void lastB(){
		System.out.println(Thread.currentThread()+" executing lastB() method.");
	}
}
