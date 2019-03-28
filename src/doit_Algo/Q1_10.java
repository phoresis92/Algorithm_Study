package doit_Algo;

import java.util.Scanner;

public class Q1_10 {

	public static int minus(int a , int b) {
		return b-a;
	}
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		
		System.out.println("insert a : ");
		a = sc.nextInt();
		sc.nextLine();
		
		while(true) {
			
			System.out.println("insert b : ");
			b = sc.nextInt();
			sc.nextLine();
			
			if(b >= a) {
				
				
				break;
				
				
			}else {
				System.out.println(a +" 보다 큰 값을 입력하세요");
			}
			
		}
		
		
		/*
		 * System.out.print("a : "); int a = 0; do { a = sc.nextInt(); sc.nextLine();
		 * }while(a<=0);
		 * 
		 * System.out.print("b :"); int b = 0; do { b = sc.nextInt(); sc.nextLine();
		 * }while(b<a);
		 */
		
		System.out.println("b-a = "+minus(a,b));
		
	}
	
}
