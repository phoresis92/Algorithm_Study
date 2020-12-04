
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] input = {2,8,10,21};
		int target = 12;

		int[] result = solve(input, target);

		Arrays.stream(result)
			.forEach(System.out::println);
	
	}	

	private static int[] solveMine(int[] input, int target){
		
		int[] result = new int[2];

		for(int i = 0; i < input.length - 1; i++) {
		    int item1 = input[i];
	//        for (int item1 : input) {
		    if (item1 < target) {


			for(int j = i + 1; j < input.length; j++) {
			    int item2 = input[j];
	//                for (int item2 : input) {
			    if (item2 < target) {

				if ((item1 + item2) == target) {
				    System.out.println("item1 = " + item1);
				    System.out.println("item2 = " + item2);
				    result[0] = i+1;
				    result[1] = j+1;
				}

			    }
			}

		    }
		}

		return result;
	
	}	

	private static int[] solve(int[] input, int target) {
		
		int[] result = new int[2];

		/*
		* key : 자신과 더해서 target이 되는 파트너 넘버 
		* value : 본인의 인덱스
		*/
		Map<Integer, Integer> map = new HashMap<>();

		// for(int item : input){
		for(int i = 0; i < input.length; i++){
			int item = input[i];

			if(map.containsKey(item)){
				// match partner
				int partnerIndex = map.get(item);
				
				result[0] = partnerIndex + 1;
				result[1] = i + 1;

				break;
			} else {
				// not exist partner
				map.put(
					target - item, // partner number
					i // this index
				);
			}

		}

		return result;
		
	}

}

