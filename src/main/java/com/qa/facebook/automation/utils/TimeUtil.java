package com.qa.facebook.automation.utils;

public class TimeUtil {	
	
	//1]Static wait
	//2]Implicit wait
	//3]Explicit wait
	//4]Fluent wait
	
	//1]Static wait--> thread.sleep(Milisecond);
	//sort wait
	//Medium wait
	//LongWait
	
	
	public static void shortWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
