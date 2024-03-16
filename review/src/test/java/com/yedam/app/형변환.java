package com.yedam.app;
/*
 * byte		- Byte
 * char 	- Character
 * int		- Integer
 * short
 * float
 * double
 * boolean
 * 
 * */
public class 형변환 {
	public static void main(String[] args) {
		
		// Wrapper Class(형변환)
		Integer score = 100;
		String s = Integer.toString(score);
		
		double avg = 90.5;
		s = Double.toString(avg);
		
		// String => other type
		score = Integer.parseInt(s);
		avg = Double.parseDouble(s);
	}
}
