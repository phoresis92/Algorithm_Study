package com.miridih.exam;

import java.util.*;


import java.io.*;

public class Stock implements Solver {
	
	public static void main(String[] args) {
		new Stock().solve(System.in, System.out);		
	}
	
	/**
	 * 문제 풀이 메인 메소드   
	 * @param in 테스트 케이스 입력을 받이들이는 InputStream
	 * @param out 결과값을 출력할 PrintStream 
	 */
	
	
	
	public void solve(InputStream in, PrintStream out) {

		InputStreamReader 	reader 	= new InputStreamReader(in);
		BufferedReader 		br 		= new BufferedReader(reader);
		Util 				util 	= new Util(br);
		ArrayList<Account> 	result 	= new ArrayList<Account>();
		
//		System.out.print("Test Case Count : ");
		int testCase = util.getNumber();
//		System.out.println("======================================");
		
		while (testCase > 0) {
			Account account = new Account();
			int 	max  	= 0;
			int		gain 	= 0;

//			System.out.print("insert days : ");
			final int n = util.getNumber();
//			System.out.print("insert predicted stock : ");
			int[] predict = util.getPredict();
			
			if(n != predict.length) {
				continue;
			}
			
			for(int i = n-1 ; i > -1 ; i--) {
				if(predict[i] > max) {
					max = predict[i];
				}else {
					gain += (max - predict[i]);
				}
			}
			account.setDeposit(gain);
			result.add(account);
			testCase--;
		}// testCase while end;
//		System.out.println("======================================");
		
		Iterator iter = result.iterator();
		while(iter.hasNext()) {
			out.println(((Account)iter.next()).getDeposit());
		}
	}//solve end;
}// class Solver end;

class Account {

	private int deposit;
	
	public Account() {
		this.deposit = 0;
	}

	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
}


class Util {
	
	static BufferedReader br;
	
	public Util(BufferedReader br) {
		this.br = br;
	}

	public static int getNumber() {
		int t = 0;
		try {
			t = Integer.parseInt(br.readLine().trim());
		} catch (Exception e) {
//			System.out.println("[you must insert number] " + e.getMessage());
			getNumber();
			return t;
		}
		return t;
	}
	
	public static int[] getPredict() {
		String temp[] = null;
		try {
			temp = br.readLine().trim().split(" ");
		} catch (Exception e) {
//			System.out.println("[wrong list try again] " + e.getMessage());
			getPredict();
			return null;
		}
		int len = temp.length;
		int t[] = new int[len];

			for (int i = 0; i < len; i++) {
				try {
					t[i] = Integer.parseInt(temp[i]);
				} catch (Exception e) {
//					System.out.println("[you must insert number at list] " + e.getMessage());
					getPredict();
					return null;
				}
			}
		return t;
	}
	
}