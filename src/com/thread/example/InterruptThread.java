package com.thread.example;

public class InterruptThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LazyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("I am lazy thread.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
}
