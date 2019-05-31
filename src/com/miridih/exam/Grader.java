package com.miridih.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

/**
 * 채점을 수행하는 클래스
 * 
 * to 응시자님 : 실제 이 클래스를 통해서 채점을 수행합니다. 프로그램 작성시 참조해 주세요
 * 
 * @author cskang
 *
 */
public class Grader {

	public static void main(String[] args) {
		final String BF = "C:/Users/hushe/dev/";

		grade(new Stock(), BF + "주식투자-input02.txt", BF + "주식투자-output02.txt");
		grade(new RotatedRect(), BF + "회전사각형-input.txt", BF + "회전사각형-output.txt");
//		grade(new Raster(), BF + "래스터그래픽-input00.txt", BF + "래스터그래픽output00.txt");

	}

	/**
	 * solver의 채점을 수행한다.
	 * 
	 * @param solver
	 *            문제 풀이 객체
	 * @param inFileName
	 *            체점용 입력 파일명
	 * @param answerFileName
	 *            채점용 정답 파일명
	 */
	static private void grade(Solver solver, String inFileName, String answerFileName) {
		System.out.println(solver.getClass().getSimpleName() + " start.");

		try {

			File outputFile = File.createTempFile("miridih", ".txt");

			solver.solve(new FileInputStream(inFileName), new PrintStream(outputFile));

			boolean isCorrect = Grader.isSameTextFile(answerFileName, outputFile.getPath());

			System.out.println("\tGrading result : " + isCorrect);

			if (!isCorrect) {
				System.out.println("/tOutput filename is " + outputFile.getPath());
			}

		} catch (Exception e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}
	}

	/**
	 * 두개의 "톅스트" 파일이 동일하면 true를 반환한다.
	 * 
	 * @param file1
	 * @param file2
	 * @return
	 * @throws IOException
	 */
	static public boolean isSameTextFile(String file1, String file2) throws IOException {
		List<String> fc1 = Files.readAllLines(FileSystems.getDefault().getPath(file1));
		List<String> fc2 = Files.readAllLines(FileSystems.getDefault().getPath(file2));

		trim(fc1);
		trim(fc2);

		if (fc1.size() != fc2.size()) {
			System.out.println("fc1 line size : " + fc1.size());
			System.out.println("fc2 line size : " + fc2.size());
			return false;
		}

		for (int i = 0; i < fc1.size(); i++) {
			if (!fc1.get(i).trim().equals(fc2.get(i).trim())) {
				System.out.println("Line no : " + (i + 1));
				System.out.println("fc1 : " + fc1.get(i));
				System.out.println("fc2 : " + fc2.get(i));
				return false;
			}
		}

		return true;
	}

	/**
	 * strings의 뒷 부분에서 비어있는 라인을 제거한다.
	 * 
	 * @param strings
	 */
	static public void trim(List<String> strings) {
		int size = strings.size();

		for (int i = size - 1; i >= 0; i--) {
			if (strings.get(i).trim().length() == 0) {
				strings.remove(i);
			}

			else {
				return;
			}

		}
	}

}

