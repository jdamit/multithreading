package com.thread.syn.example;

public class MyThread extends Thread
{
  private  String name;
  public  Display d;
  
  MyThread(String name, Display d){
    this.name = name;
    this.d = d;
  }
  
  public void run(){
    Display.wish(name);
  }
}