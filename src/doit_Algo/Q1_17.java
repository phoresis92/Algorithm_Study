package doit_Algo;

import java.util.Scanner;

public class Q1_17 {

	public static void npira(int n) {
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n-i ; j++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= (i-1)*2+1 ; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] a) {
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.println("insert number : ");
			n = sc.nextInt();
		}while(n<=0);
		
		npira(n);
		
	}
	
}
