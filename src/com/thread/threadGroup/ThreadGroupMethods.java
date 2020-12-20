package com.thread.threadGroup;

public class ThreadGroupMethods {

	public static void main(String[] args) {
		ThreadGroup grp = new ThreadGroup("First group");
		System.out.println("Default Thread group max priority: "+grp.getMaxPriority() );
		Thread t1 = new Thread(grp,()->System.out.println("first thread."),"first thread");
		Thread t2 = new Thread(grp,()->System.out.println("second thread."),"second thread");
		System.out.println("first thread priority: "+t1.getPriority());
		System.out.println("second thread priority: "+t2.getPriority());
		grp.setMaxPriority(3);
		System.out.println("priority after chagnes in thread group priority.");
		Thread t3 = new Thread(grp,()->System.out.println("third thread."),"third thread");
		System.out.println("first thread priority: "+t1.getPriority());
		System.out.println("second thread priority: "+t2.getPriority());
		System.out.println("third thread priority: "+t3.getPriority());
		
		grp.list();//prints information about thread group to the console.
		
		System.out.println("Number of active threads: "+grp.activeCount());

	}

}
