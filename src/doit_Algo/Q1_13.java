package doit_Algo;

public class Q1_13 {

	public static void main(String[] a) {
		
		for(int k = 0 ; k < 10 ; k++) {
			if(k == 0) {
				System.out.print("  |");
			}else {
				System.out.printf("%3d", k);
			}
		}
		System.out.println("\n--+---------------------------");
		
		for(int i = 1 ; i < 10 ; i++) {
			System.out.print(i+" |");
			for(int j = 1 ; j < 10 ; j++) {
				System.out.printf("%3d",i+j);
			}
			System.out.println();
		}
		
	}
	
}
