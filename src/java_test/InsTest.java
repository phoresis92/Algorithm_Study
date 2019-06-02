package java_test;

import java.lang.reflect.Method;

public class InsTest {

	public static void main(String[] args) {
		
		short a = 10;
		Object b = a;
		Short c = 10;

		System.out.println(short.class.isInstance(a)); // true
		System.out.println(b instanceof Short); // true
		System.out.println(c instanceof Short); // true


	}
	
}
