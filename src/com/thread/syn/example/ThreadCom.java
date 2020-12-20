package com.thread.syn.example;

public class ThreadCom {

	public static void main(String[] args) {
		ChildThread ct = new ChildThread();
		ct.start();
		try {
			ct.wait();//Exception in thread "main" java.lang.IllegalMonitorStateException 
			// wait() method only called from synchronized area.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ct.total);

	}

}

class ChildThread extends Thread{
	int total = 0;
	public void run(){
		for(int i=0; i<100; i++){
			total = total + i;
		}
	}
}