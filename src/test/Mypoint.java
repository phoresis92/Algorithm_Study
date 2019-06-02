package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.miridih.exam.Raster;
import com.miridih.exam.Solver;

public class Mypoint implements Solver {

	public static class point {
		double x;
		double y;
		public point() {};
		public point(double x, double y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}

	}

	public static class line {
		double grad;
		point point;
		public line() {};
		public line(point point, double grad) {
			// TODO Auto-generated constructor stub
			this.point = point;
			this.grad = grad;
		}
		


	}

	public static void main(String[] args) {
		new Mypoint().solve(System.in, System.out);
	}

	/*
	 * 문제 풀이 메인 메소드
	 * 
	 * @param in 테스트 케이스 입력을 받이들이는 InputStream
	 * 
	 * @param out 결과값을 출력할 PrintStream
	 */

	public void solve(InputStream in, PrintStream out) {

		String BF = "C:/Users/hushe/dev/";
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
		// 변수 초기화
		int w = 0;
		int h = 0;
		int x_circle = 0;
		int y_circle = 0;
		int r = 0;
		ArrayList<point> pList = new ArrayList<point>();
		ArrayList<line> lList = new ArrayList<line>();
		
		// 두 점 P1 - P3 간의 거리 ==정사각형의 내부 대각선 길이
		double distance = 0;
		// 정사각형 한 변의 길이
		double ll = 0;
		// 대각선 위치에 놓인 두점으로부터 기울어진 각도 추출
		double angle = 0;
		
		
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
				point p1 = new point(Double.parseDouble(value_str[0]),Double.parseDouble(value_str[1]));
				point p3 = new point(Double.parseDouble(value_str[2]),Double.parseDouble(value_str[3]));
				
				distance = PtoPDistance(p1, p3);// 두 점 P1 - P3 간의 거리 ==정사각형의 내부 대각선 길이
				angle = calcAngle(p1, p3);// 대각선 위치에 놓인 두점으로부터 기울어진 각도 추출
				ll = distance / Math.sqrt(2);// 정사각형 한 변의 길이
				
				System.out.println(distance);
				System.out.println(angle);
				System.out.println(ll);
				
				point p2 = new point(p1.x + ll * Math.cos(Math.toRadians(angle)),
						p1.y - ll * Math.sin(Math.toRadians(angle)));
				point p4 = new point(p3.x - ll * Math.sin(Math.toRadians(angle)),
						p3.y + ll * Math.cos(Math.toRadians(angle)));
				
				System.out.println(p2.x);
				System.out.println(p2.y);
				System.out.println(p4.x);
				System.out.println(p4.y);
				
				pList.add(p1);
				pList.add(p2);
				pList.add(p3);
				pList.add(p4);
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

		//line 객체 설정 && ArrayList에 누적저장 처리
		lList.add(   new line(  pList.get(0), gradient( pList.get(0), pList.get(1) )  )   );
		lList.add(   new line(  pList.get(1), gradient( pList.get(1), pList.get(2) )  )   );
		lList.add(   new line(  pList.get(2), gradient( pList.get(2), pList.get(3) )  )   );
		lList.add(   new line(  pList.get(3), gradient( pList.get(3), pList.get(0) )  )   );
		for (int yy = 0; yy < h; yy++) {
			for (int xx = 0; xx < w; xx++) {
				if (radius(x_circle, y_circle, xx, yy) <= r) {// 원 그리기
					answer += "#";
					System.out.print("#");
				} else if (yy <= graph(xx, lList.get(0)) && yy <= graph(xx, lList.get(1)) 
						&& yy >= graph(xx, lList.get(2)) && yy >= graph(xx, lList.get(3))) {
					answer += "#";
					System.out.print("#");
				} else {
					answer += ". ";
					System.out.print(".");
				}
			}
			answer += "\r\n";
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

	private static double PtoPDistance(point p1, point p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}

	private static double gradient(point p1, point p2) {
		return (p1.y - p2.y) / (p1.x - p2.x);
	}

	private static double calcAngle(point p1, point p2) {
		return 45 - Math.toDegrees(Math.atan2((p2.y - p1.y), (p2.x - p1.x)));
	}

	private static double graph(int x, line line) {
		double res_y = 0;
		res_y = (line.grad * x) + line.point.y - (line.grad * line.point.x);
		return res_y;
	}

	private static double radius(int x, int y, int q, int qq) {
		double distance = Math.sqrt(Math.pow((x - q), 2) + Math.pow((y - qq), 2));
		return distance;
	}

}