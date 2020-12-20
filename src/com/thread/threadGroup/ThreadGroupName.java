package com.thread.threadGroup;

public class ThreadGroupName {

	public static void main(String[] args) {
		System.out.println("Thread name: " + Thread.currentThread() + ", Thread group name: "
				+ Thread.currentThread().getThreadGroup().getName());
		if(!Thread.currentThread().isDaemon())
		System.out.println("Parent Thread group name: "
				+ Thread.currentThread().getThreadGroup().getParent().getName());
		
	}

}
