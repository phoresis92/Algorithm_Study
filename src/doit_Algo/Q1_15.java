package doit_Algo;

import java.util.Scanner;

public class Q1_15 {
	
	public static void triangleLB(int n) {
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public static void triangleRB(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(n-i >= j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	public static void triangleLT(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int j = n ; j >= i ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void triangleRT(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(i <= j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		System.out.println("how many line: ");
		//triangleLB(sc.nextInt());
		int n = sc.nextInt();
		System.out.println();
		triangleLB(n);
		System.out.println();
		triangleRB(n);
		System.out.println();
		triangleLT(n);
		System.out.println();
		triangleRT(n);
	}
}
