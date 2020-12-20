package com.thread.threadGroup;

public class ThreadGrpActiveCount {

	public static void main(String[] args) throws InterruptedException {
		Runnable target = ()->{
			System.out.println("Child thread runnable.");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		ThreadGroup grp = new ThreadGroup("Parent Group");
		Thread t1 = new MyThread(grp, "first thread");
		Thread t2 = new MyThread(grp, "second thread");
		/*Thread t3 = new Thread(target);
		t3.start();*/
		t1.start();
		t2.start();
		System.out.println("Active counts before main thread sleeping.");
		System.out.println(grp.activeCount());
		System.out.println(grp.activeGroupCount());
		grp.list();

		Thread.sleep(10000);
		System.out.println("Active counts after main thread sleeping.");
		System.out.println(grp.activeCount());
		System.out.println(grp.activeGroupCount());
		grp.list();
		
		ThreadGroup systemGrp = Thread.currentThread().getThreadGroup().getParent();
		Thread[] threadArr = new Thread[systemGrp.activeCount()];
		systemGrp.enumerate(threadArr);
		for(Thread t : threadArr){
			System.out.println("Thread name: "+t.getName()+", Is daemon: "+ t.isDaemon());
		}

	}

}

class MyThread extends Thread{
	
	MyThread(ThreadGroup grp, String name){
		super(grp,name);
	}
	@Override
	public void run(){
		System.out.println("Child thread.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
