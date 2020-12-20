package com.thread.syn.example;

class MainThread{
	public static void main(String[] args){
		ThreadA tA = new ThreadA();
		tA.start();
		System.out.println("abbabbaba");
		System.out.println(tA.total);
	}
}