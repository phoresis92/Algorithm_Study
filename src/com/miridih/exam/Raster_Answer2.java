package com.miridih.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import java.io.InputStream;
import java.io.PrintStream;

public class Raster_Answer2 implements Solver {

	public static void main(String[] args) {
		new Raster_Answer2().solve(System.in, System.out);
	}

	/*
	 * 문제 풀이 메인 메소드
	 * 
	 * @param in 테스트 케이스 입력을 받이들이는 InputStream
	 * 
	 * @param out 결과값을 출력할 PrintStream
	 */

	public void solve(InputStream in, PrintStream out) {

		String BF = "D:/Work/miri-exam/sample/";
		String inputfileName = "래스터그래픽-input00.txt";
		String outputfileName = "래스터그래픽output00.txt";

		byte[] b = new byte[4096];
		InputStreamReader reader = null;
		StringBuffer buf = new StringBuffer();
		in = null;

		try {
			in = new FileInputStream(BF + inputfileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			reader = new InputStreamReader(in, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i;
		try {
			while ((i = in.read(b)) != -1) {
				buf.append(new String(b, 0, i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str = buf.toString();
		String[] arr = str.split("\n");// 20 16\n9 6 5\n16 14 8 14
		
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//////////////////////////////end of initial settings /////////////////////////////////////
		String answer = "";
		//변수 초기화
		int w = 0;
		int h = 0;
		int x_circle = 0;
		int y_circle = 0;
		int r = 0;
		int x1 = 0;
		int y1 = 0;
		int x3 = 0;
		int y3 = 0;
		
		int array_number = 0;
		for (array_number = 0; array_number < arr.length; array_number++) {// 변수 선언을 위한 for문

			String values_str = arr[array_number];
			String[] value_str = values_str.split(" "); 
			if (array_number == 0) {
				w = Integer.parseInt(value_str[0]);
				h = Integer.parseInt(value_str[1]);
			}
			if (array_number == 1) {
				x_circle = Integer.parseInt(value_str[0]);
				y_circle = Integer.parseInt(value_str[1]);
				r = Integer.parseInt(value_str[2]);
			}
			if (array_number == 2) {
				x1 = Integer.parseInt(value_str[0]);
				y1 = Integer.parseInt(value_str[1]);
				x3 = Integer.parseInt(value_str[2]);
				y3 = Integer.parseInt(value_str[3]);
			}

		} // 변수 선언을 위한 for문 닫는 괄호

//////////////////////////////////////////////////////////////////////////////
// algorithm
// w, h, x_circle, y_circle, r,  x1, y1,   x3, y3
// 20,16,       9,        6, 5, (16,14),  (8,14)
// 3-1. 이중for문으로 점(x:20 * y:16 좌표계)들을 찍으면서(9,6)과의 거리(d)를 잰다.
//		거리(d)가 5(r)보다 작거나 같으면 #을 찍고 d가 5(r)보다 크면 .을 찍는다.
// 3-2. 두 점 P1(x1,y1) P3(x3,y3)로 나머지 두점 P2(x2,y2) P4(x4,y4)을 구한다.
//		P1-P2, P2-P3, P3-P4, P4-P1 의 그래프를 만든다.
//		y값이 P1-P2, P2-P3 보다 작고 P3-P4, P4-P1보다 큰 좌표에 #을 찍고 그 외에는 .을 찍는다
//////////////////////////////////////////////////////////////////////////////
		//두 점 P1 - P3 간의 거리 ==정사각형의 내부 대각선 길이
		double distance2 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
		// 정사각형 한 변의 길이
		double ll = distance2 / Math.sqrt(2);
		//임의의 정사각형이 기울어진 각도
		double angle = 45 - Math.toDegrees(Math.atan2((y3 - y1), (x3 - x1)));
		//P2 P4 의 좌표
		double x2 = x1 + ll * Math.cos(Math.toRadians(angle));
		double y2 = y1 - ll * Math.sin(Math.toRadians(angle));
		double x4 = x3 - ll * Math.sin(Math.toRadians(angle));
		double y4 = y3 + ll * Math.cos(Math.toRadians(angle));
		//각각 두점 사이의 기울기
		double grad1 = gradient(x1, y1, x2, y2);
		double grad2 = gradient(x2, y2, x3, y3);
		double grad3 = gradient(x3, y3, x4, y4);
		double grad4 = gradient(x4, y4, x1, y1);
		
		for (int yy = 0; yy < h; yy++) {
			for (int xx = 0; xx < w; xx++) {
				if (distance(x_circle, y_circle, xx, yy) <= r) {//원 그리기
					answer+="#";
					System.out.print("#");
				} else if (yy <= graph(grad1, xx, x1, y1) && yy <= graph(grad2, xx, x2, y2) 
						&& yy >= graph(grad3, xx, x3, y3) && yy >= graph(grad4, xx, x4, y4)) {
					answer+="#";
					System.out.print("#");
				} else {
					answer+=". ";
					System.out.print(".");
				}

			}
			answer+="\r\n";
			System.out.println("");
		}


		OutputStream os = null;
		try {
			os = new FileOutputStream(BF + outputfileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] out_byte = answer.getBytes();
		try {
			os.write(out_byte);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static double gradient(double x1, double y1, double x2, double y2) {

		return (y1 - y2) / (x1 - x2);
	}

	private static double graph(double gradient, double x, double x1, double y1) {
		double res_y = 0;
		res_y = (gradient * x) + y1 - (gradient * x1);
		return res_y;
	}

	private static double distance(int x, int y, int q, int qq) {
		double distance = Math.sqrt(Math.pow((x - q), 2) + Math.pow((y - qq), 2));

		return distance;
	}


}