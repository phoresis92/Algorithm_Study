package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Q1 {

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
