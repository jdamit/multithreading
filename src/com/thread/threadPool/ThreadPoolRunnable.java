package com.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRunnable {

	public static void main(String[] args) {
		PrintJob[] jobs = { new PrintJob("Rahul"),
							new PrintJob("Ekta"),
							new PrintJob("Durga"),
							new PrintJob("Shiva"),
							new PrintJob("Ravi"),
							new PrintJob("Shipra")};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(PrintJob job : jobs){
			service.submit(job);
		}
		service.shutdown();
	}

}

class PrintJob implements Runnable{

	String name;
	PrintJob(String name){
		this.name=name;
	}
	@Override
	public void run() {
		System.out.println(name+" job started by Thread: "+Thread.currentThread().getName());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		System.out.println(name+" job completed by Thread: "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
	}
	
}