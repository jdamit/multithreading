package com.thread.syn.example;

public class Demo
{
  public static void main(String[] args)
  {
   System.out.println("Demo working");
    Display d1 = new Display();
	Display d2 = new Display();
    MyThread t1 = new MyThread("Dhoni",d1);
	MyThread t2 = new MyThread("Yuvraj",d2);
    t1.start();
	t2.start();
  }
}
