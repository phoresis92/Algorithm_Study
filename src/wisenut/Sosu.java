package wisenut;

public class Sosu {

	public static void main(String[] args) {
		
		int result = 0;
		
		for(int i = 1 ; i <= 100 ; i++) {
			int cnt = 0 ;
			for(int j = 1 ; j <= i ; j++) {
				if(i%j == 0) {
					cnt++;
				}
			}
			if(cnt == 2) {
				result += i;
			}
		}
		System.out.println(result);
		
	}
	
}
