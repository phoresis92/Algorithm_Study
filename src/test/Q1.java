package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Q1 {

<<<<<<< HEAD
	public static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Object> array;

    public void doBuy(){

    }

    public void doSell(){

    }

    public void doSellAll(){

    }

    public void doNothing(){

    }
    
    public static int getNumber() {
    	int t = 0;
    	try {
        	t = Integer.parseInt(sc.next());
        }catch(Exception e) {
        	System.out.println("[you must insert number]\n"+e.getMessage());
        	getNumber();
        	return t;
        }
    	return t;
    }
    
    public static int[] getPredict() {
    	String temp[] = null;
    	try {
    		temp = sc.next().split(" ");
    	}catch(Exception e) {
    		System.out.println("[wrong list try again]\n"+e.getMessage());
    		getPredict();
    		return null;
    	}
    	int len = temp.length;
    	int t[] = new int[len];
    	
    	try {
        	for(int i = 0 ; i < len ; i++) {
        		t[i] = Integer.parseInt(temp[i]);
        	}
        }catch(Exception e) {
        	System.out.println("[you must insert number at list]\n"+e.getMessage());
        	getPredict();
        	return null;
        }
    	return t;
    }

    public static void main(String[] args) {
       
        int t = getNumber();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while( t > 0 ){
        	System.out.println("======================================");
            final int N = getNumber();
           
            int[] predict = getPredict();

            
            t--;
        }

    }// main end

}
=======
	static Util util = new Util();
	
	public static void main(String[] args) {
		
		System.out.print("Test Case Count : ");
		int t = util.getNumber();
		ArrayList result = new ArrayList();

		System.out.println("======================================");
		
		int cnt = 1;
		while (t > 0) {
			System.out.println("[Test "+cnt+"]");
			Account account = new Account();
			System.out.print("insert days : ");
			final int n = util.getNumber();
			System.out.print("insert predicted list : ");
			int[] predict = util.getPredict();
			
			if(n != predict.length) {
				continue;
			}

			for(int i = 0 ; i < n ; i++) {
				int today = predict[i];
				if(i == n) {
					account.doSellAll(today);
					break;
				}
				int tomorrow = predict[i+1];
				if(i == n-1) {
					if(today <= tomorrow) {
						account.doBuy(today);
					}else {
						account.doSellAll(today);
					}
					continue;
				}
				int thirdDay = predict[i+2];
				if(today <= tomorrow) {
					account.doBuy(today);
				}else {
					if(tomorrow <= thirdDay) {
						account.doSell(today);
					}else {
						account.doSellAll(today);
					}
				}
			}

			t--;
			cnt++;
		}
		

		System.out.println("======================================");
	}// main end
	
}

class Account {

	private int deposit;
	private int stock;
	
	public Account() {
		this.deposit = 0;
		this.stock = 0;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
	public void doBuy(int price) {
		deposit = deposit-price;
		stock++;
	}

	public void doSell(int price) {
		if(stock == 0) return;
		
		deposit = deposit+price;
		stock--;
	}

	public void doSellAll(int price) {
		if(stock == 0) return;
		
		deposit = deposit + (stock * price);
		stock = 0;
	}

	public void doNothing() {
		return;
	}

}

class Util {

	public static Scanner sc = new Scanner(System.in);
	
	public static int getNumber() {
		int t = 0;
		try {
			t = Integer.parseInt(sc.nextLine().trim());
		} catch (Exception e) {
			System.out.println("[you must insert number] " + e.getMessage());
			getNumber();
			return t;
		}
		return t;
	}
	
	public static int[] getPredict() {
		String temp[] = null;
		try {
			temp = sc.nextLine().trim().split(" ");
		} catch (Exception e) {
			System.out.println("[wrong list try again] " + e.getMessage());
			getPredict();
			return null;
		}
		int len = temp.length;
		int t[] = new int[len];

			for (int i = 0; i < len; i++) {
				try {
					t[i] = Integer.parseInt(temp[i]);
				} catch (Exception e) {
					System.out.println("[you must insert number at list] " + e.getMessage());
					getPredict();
					return null;
				}
			}
		return t;
	}
	
}
>>>>>>> 1682d31d644a9dadcee432d708f84b7ed108a785
