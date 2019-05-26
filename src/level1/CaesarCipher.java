package level1;

public class CaesarCipher {
	
	public static String answer(String str, int n) {
		String result ="";
		
		char[] arr = str.toCharArray();
		
//		for(char arg : arr) {
//			if(arg == ' ') {
//				result += arg;
//			}else if(arg >= 65 && arg <= 90){
//				result += (char) (((arg%65 + n) % 26) + 65);
//			}else if(arg >= 97 && arg <= 122) {
//				result += (char) (((arg%97 + n) % 26) + 97);
//			}
//		}
		
		for(char arg : arr) {
			if(arg == ' ') {
				result += arg;
			}else if(arg >= 'A' && arg <= 'Z'){
				result += (char) (((arg%'A' + n) % 26) + 'A');
			}else if(arg >= 'a' && arg <= 'z') {
				result += (char) (((arg%'a' + n) % 26) + 'a');
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		//System.out.println(answer("AB",3));
		
		byte A = 'A';  //65
		byte Z = 'Z';  //90
		
		byte a = 'a';  //97
		byte z = 'z';  //122
		
		byte sp = ' '; //32
		
		System.out.println(A);
		System.out.println(Z);
		System.out.println(a);
		System.out.println(z);
		System.out.println(sp);
		
		
		System.out.println("================================");
		System.out.println(a+25);
		System.out.println(50%26);
		System.out.println(90%64 + 1);
		System.out.println((90%64) + 1);
		System.out.println("================================");
		
		String str = "a A Z z";
		char[] arr = str.toCharArray();
		for(char arg : arr) {
			System.out.println((byte)arg);
		}
		
		System.out.println("================================");
		System.out.println(answer(str, 1));
		System.out.println("================================");
		System.out.println((char) 116);
	}

}
