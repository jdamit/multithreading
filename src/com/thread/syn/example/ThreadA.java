package com.thread.syn.example;

class ThreadA extends Thread{
	int total=0;
	public void run(){
		for(int i=1; i<=100; i++){
		total = total+i;
		}
	}
}