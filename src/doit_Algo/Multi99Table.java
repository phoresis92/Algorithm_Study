package doit_Algo;

public class Multi99Table {

	public static void main (String[] a) {
		
		System.out.println("========Multi99Table=========");
		
		for(int k = 0 ; k < 10 ; k++) {
			if(k != 0) {
				System.out.printf("%3d", k);
			}else {
				System.out.print(" |");
			}
		}
		
		System.out.println("\n-+----------------------------");
		
		for(int i = 1 ; i < 10 ; i++) {
			
				System.out.print(i+"|");
			
			for(int j = 1 ; j < 10 ; j++) {
			
				System.out.printf("%3d",i*j);
				
				
			}//inner for
			
			System.out.println();
			
		}//outer for
		
	}
	
}
