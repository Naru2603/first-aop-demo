package com.infy.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public void Addition(int a, int b) {
		System.out.println("Inside addition(int int) method");
		System.out.println("Addition is : "+(a+b));
	}
	
	
	
	public void Addition(long a, long b)
	{
		System.out.println("inside addition(long long) method!!");
		System.out.println("Addition is : "+ (a+b));
		throw new ArithmeticException();
	}
	
	public Integer sum(int a, int b) throws InterruptedException  {
		System.out.println("Inside sum method");
		Thread.sleep(5000);
		return a+b;
	}
}
