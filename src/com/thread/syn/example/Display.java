package com.thread.syn.example;

public class Display{
  public static synchronized void wish(String name){
    for(int i=0; i<10; i++){
    	System.out.print("GOOD MORNING:");
      try{
        Thread.sleep(2000);
      }catch(InterruptedException ie){
      }
      System.out.println(name);
    }
  }
}