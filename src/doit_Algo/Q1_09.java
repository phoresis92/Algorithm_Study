package doit_Algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1_09 {

	
	private static int sumof(int a, int b) {
		
		int end = 0;
		int start = 0;
		
		if(a >= b) {
			start = b;
			end = a;
		}else {
			start = a;
			end = b;
		}
		
		int sum = 0;
		
		for(int i = start ; i <= end ; i++) {
			
			sum += i;
			
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("insert a :");
		int a = sc.nextInt();
		sc.nextLine();
		System.out.print("insert b :");
		int b = sc.nextInt();
		sc.nextLine();
		
		System.out.println("sum of result "+a+" between "+b+" = "+sumof(a,b));
		
	}
	
}
