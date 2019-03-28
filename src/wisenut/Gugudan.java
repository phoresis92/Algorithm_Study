package wisenut;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("insert start : ");
		int start = sc.nextInt();
		System.out.println("insert end : ");
		int end = sc.nextInt();
		
		int max = end;
		int min = start;
		if(start > end) {
			max = start;
			min = end;
		}
		for(int i = 1 ; i < 10 ; i++) {
			for(int k = min; k <= max ; k++) {
				
				System.out.print(k+" * "+ i + " = "+ (k*i));
				System.out.print(" ");
				
			}
			System.out.println();
		}
		
		
		
	}
	
}
