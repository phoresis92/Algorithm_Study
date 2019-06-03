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
		
//		long start = System.currentTimeMillis();
		
		InputStreamReader 	reader 	= new InputStreamReader(in);
		BufferedReader 		br 		= new BufferedReader(reader);
		Util 				util 	= new Util(br);
		ArrayList<Account> 	result 	= new ArrayList<Account>();
		
//		System.out.print("Test Case Count : ");
		int testCase = util.getNumber();
//		System.out.println("======================================");
		
		while (testCase > 0) {
			Account account = new Account();

//			System.out.print("insert days : ");
			final int n = util.getNumber();
//			System.out.print("insert predicted stock : ");
			int[] predict = util.getVariables();
			
			if(n != predict.length) {
				continue;
			}

			ArrayList<Integer> maxList = new ArrayList<Integer>();
			
			int     maxN  = 0;
			boolean slope = false;
			
			// Get Max List
			for(int i = 1 ; i < predict.length ; i++) {
				int prev = predict[i-1];
				int now  = predict[i];
				
				if(prev >= now && slope) {
					maxList.add(maxN);
					slope = false;
				}else {
					maxN  = i;
					slope = true;
					
					if(i == predict.length -1) {
						maxList.add(maxN);
					}
				}// if end
			}// for end
			
			// Calc Result Deposit
			for(int i = 0 ; i < predict.length ; i++) {
//				if(maxList.size() == 0) {
//					break;
//				}
				boolean isBuy     = false;
				boolean isNothing = false;
				
//				if(i == predict.length-1) {
//					account.doSellAll(predict[i]);
//					break;
//				}

				for(int j = 0 ; j < maxList.size() ; j++) {
					isNothing = false;
					
					if(i > maxList.get(j)) {
						isNothing = !isNothing;					
					}else if(predict[i] < predict[maxList.get(j)]) {
						isBuy     = true;
					}
				}// for end
				
				if(isNothing) {
					account.doNothing();
					continue;
				}
				if(isBuy) {
					account.doBuy(predict[i]);
				}else {
					account.doSellAll(predict[i]);
				}
			}// for end
			
			result.add(account);
			testCase--;
		}// testCase while end;
//		System.out.println("======================================");
		
		Iterator<Account> iter = result.iterator();
		while(iter.hasNext()) {
			out.println(iter.next().getDeposit());
		}
		
//		long end = System.currentTimeMillis();
//		System.out.println("Result Time : "+ (end - start)/1000);
	}//solve method end;

	private class Account {
	
		private int deposit;
		private int stock;
		
		public Account() {
			this.deposit = 0;
			this.stock = 0;
		}
	
		public int getDeposit() {
			return deposit;
		}
		
		public void doBuy(int price){
			deposit = deposit - price;
			stock++;
//			System.out.println("buy");
		}
		public void doSellAll(int price) {
			if(stock == 0) {
				return;
			}
			deposit = deposit + (stock * price);
			stock = 0;
//			System.out.println("sell");
		}
		public void doNothing() {
//			System.out.println("nothing");}
		}
	}

}// class Solver end;

class Util {
	
	private BufferedReader br;
	
	public Util(BufferedReader br) {
		this.br = br;
	}

	public int getNumber() {
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
	
	public int[] getVariables() {
		String temp[] = null;
		try {
			temp = br.readLine().trim().split(" ");
		} catch (Exception e) {
//			System.out.println("[wrong list try again] " + e.getMessage());
			getVariables();
			return null;
		}
		int len = temp.length;
		int t[] = new int[len];

			for (int i = 0; i < len; i++) {
				try {
					t[i] = Integer.parseInt(temp[i]);
				} catch (Exception e) {
//					System.out.println("[you must insert number at list] " + e.getMessage());
					getVariables();
					return null;
				}
			}
		return t;
	}
	
}