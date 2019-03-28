package doit_Algo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1_11 {

	
	public static void myAns() {
		int num = 0;
		
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("insert number : ");
			try {
				num = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Integer.MAX_VALUE+ "이내의 값을 입력해주세요");
				num = 0;
			}
		}while(num <= 0);
		
		String s = num + "";
		char[] arr = s.toCharArray();
		
		int cnt = 0;
		for(char ch : arr) {
			cnt ++;
		}
		
		System.out.println("자리수 "+cnt+"입니다");
	}
	
	public static void othAns() {
		Scanner sc = new Scanner(System.in);
		int num;
		
		
		do {
			System.out.print("insert number : ");
			num = sc.nextInt();
		}while(num <= 0);

		
		int cnt = 0;
		while(num>0){
			num = num/10; 
			cnt++;
		}
		
		System.out.println("자리수 "+cnt+"입니다");
	}
	
	
	
	public static void main (String[] a) {

		myAns();
		
	}
	
}
