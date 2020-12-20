package com.thread.threadGroup;

public class ThreadGroupConstructor {
	
	public static void main(String[] args) {
		//creation of ThreadGroup
		ThreadGroup grp = new ThreadGroup("First group");
		System.out.println(grp.getParent().getName());
		
		ThreadGroup subGrp = new ThreadGroup(grp, "Second group");
		System.out.println(subGrp.getParent().getName());
	}
}
