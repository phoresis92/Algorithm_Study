package wisenut;

public class Reverse {

	public static void main(String[] args) {
		
		String rev = "hello wisenut";
		
		char[] arr = rev.toCharArray();
		
		String result = "";
		for(int i = arr.length-1 ; i >=0 ; i--) {
			result += arr[i];
		}
		System.out.println(result);
		
	}
	
}
