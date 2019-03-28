package wisenut;

public class TwoFor {

	public static void main(String[] args) {
		
		int result = 1;
		for(int i = 1 ; i < 15 ; i++) {
			int value = 0;
			for(int j = 1 ; j <= i ; j++) {
				value++;
			}
			System.out.println(value);
			result += value;
		}
		System.out.println(result);
	}
	
}
