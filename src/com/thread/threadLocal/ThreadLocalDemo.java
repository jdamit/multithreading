package com.thread.threadLocal;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<String>();
		System.out.println(tl.get());
		tl.set("thread local variable value");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());

	}

}
