package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Mouigosa {

	    public static int[] solution(int[] answers) {
	         int[] answer = {};
	        
	        ArrayList<Integer> arr = new ArrayList<>();
	        
	        int[][] supo = {
	            {1,2,3,4,5},
	            {2,1,2,3,2,4,2,5},
	            {3,3,1,1,2,2,4,4,5,5}
	        };
	        
	        int[] point = new int[3];
	        for(int i = 0 ; i < answers.length ; i++){
	            if(supo[0][i%5] == answers[i]){
	                point[0] += 1;
	            } 
	            if(supo[1][i%8] == answers[i]){
	                point[1] += 1;
	            } 
	            if(supo[2][i%10] == answers[i]){
	                point[2] += 1;
	            } 
	        }
	        
	        int idx = 0;
	        int max = point[0];
	        for(int j = 0 ; j < point.length ; j++){
	            if(point[j] > max){
	                max = point[j];
	                idx = j;
	            }
	        }

	        for(int a : point) {
	        	System.out.println(a);
	        }
	        System.out.println(max);
	        System.out.println(idx);
	        
	        for(int k = 0 ; k < point.length ; k++){
	            if(max	 == point[k]){
	                arr.add(k+1);
	            }
	        }
	        
	        System.out.println(arr);
	        
	        answer = new int[arr.size()];
	        for(int m = 0 ; m < arr.size() ; m++){
	            answer[m] = arr.get(m);
	        }
	        
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	    
	    public static void main(String[] a) {
	    	int[] an = {1,1,1,1,5};
	    	System.out.println(solution(an));
	    }
}
