package level1;

import java.util.ArrayList;
import java.util.Iterator;

public class No_same_num {
	
	public static int[] makeResult(int[] arr) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		Integer prevNum = 10;
	                
	        for(int a : arr){
	        	if(a != prevNum) {
	        		tempList.add(a);
	        		prevNum = a;
	        	}
	        }
	        
	        int[] answer = new int[tempList.size()];
	        for(int i = 0 ; i < answer.length ; i++) {
	        	answer[i] = tempList.get(i).intValue();
	        }
	        
		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1,1,1,1,1};
		for(int result : makeResult(arr)) {
			System.out.println(result);
		}
		
		
	}

}
