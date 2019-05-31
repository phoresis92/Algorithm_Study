package com.miridih.exam;

import java.io.InputStream;
import java.io.PrintStream;



/**
 * 문제 풀이 클래스들의 상위 인터페이스 
 * 
 *  문제 풀이를 위한 메인 클래스들은 이 인테페이스를 구현해야한다. 
 *  그래야만 Grader 클래스에서 채점을 수행할 수 있다. 
 * @author cskang
 *
 */
public interface Solver {
	
	/**
	 * in으로부터 입력을 받아 문제를 풀어 out으로 출력한다.
	 * @param in 테스트 케이스 입력을 받이들이는 InputStream
	 * @param out 결과 값을 출력할 PrintStream 
	 */	
	public void solve(InputStream in, PrintStream out);
}

