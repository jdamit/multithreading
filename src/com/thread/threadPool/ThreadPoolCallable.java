package com.thread.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolCallable {

	public static void main(String[] args) {
		PrintJobCallable[] jobs = { new PrintJobCallable(90),
				new PrintJobCallable(10),
				new PrintJobCallable(20),
				new PrintJobCallable(30),
				new PrintJobCallable(80),
				new PrintJobCallable(100)};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(PrintJobCallable job : jobs){
			Future<Integer> future = service.submit(job);
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		service.shutdown();

	}

}

class PrintJobCallable implements Callable<Integer>{

	int num;
	public PrintJobCallable(int num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		System.out.print(Thread.currentThread().getName()
				+" is resposible to find sum of first "+ num 
				+ " numbers: ");
		Thread.sleep(2000);
		int sum = 0;
		for(int i = 1; i<=num; i++){
			sum=sum+i;
		}
		return sum;
	}
	
}