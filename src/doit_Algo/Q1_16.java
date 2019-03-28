package doit_Algo;

import java.util.Scanner;

public class Q1_16 {

	public static void spira(int n) { //내답
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= (n-1)*2+1 ; j++) {
				
				if(n-(i-1) <= j && j <=n+(i-1)) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
		
	}
	
	static void spira2(int n) {//해답
		for (int i = 1; i <= n; i++) { 					// i행 (i = 1, 2, … ,n)
			for (int j = 1; j <= n - i + 1; j++) { 		// n-i+1개의 ' '를 나타냄
				System.out.print(' ');
			}
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) { 	// (i-1)*2+1개의 '*'를 나타냄
				System.out.print('*');
			}
			System.out.println(); 						// 개행(줄변환)
		}
	}
	
	public static void main(String[] a) {
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.println("insert number : ");
			n = sc.nextInt();
		}while(n <= 0);
		
		spira2(n);
		
	}
	
}


/*
 * 1 4~4 n~n 
 * 2 3~5 n-1 ~ n+1 
 * 3 2~6 n-2 ~ n+2 
 * 4 1~7 n-3 ~ n+3
 */