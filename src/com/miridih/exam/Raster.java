package com.miridih.exam;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Raster implements Solver {
		
	public static void main(String[] args) {
		new Raster().solve(System.in, System.out);	
	}
				
	public static final int WIDTH_HEIGHT  = 2;
	public static final int CIRCLE_XYR    = 3;
	public static final int XY13          = 4;
	public static final int TOTAL_VAR_CNT = WIDTH_HEIGHT+CIRCLE_XYR+XY13;
	
	public void solve(InputStream in, PrintStream out) {

		InputStreamReader 	reader 	= new InputStreamReader(in);
		BufferedReader 		br 		= new BufferedReader(reader);
		Util 				util 	= new Util(br);

		int var[]     =   getVar(util);
	  //==========================//
		int width     =   var[0];
		int height    =   var[1];
	  //--------------------------//
		int x_circle  =   var[2];
		int y_circle  =   var[3];
		int r         =   var[4];
	  //--------------------------//
//		int x1        =   var[5];
//		int y1        =   var[6];
//		int x3        =   var[7];
//		int y3        =   var[8];
	  //==========================//
		
		Point p1 = new Point(var[5], var[6]);
		Point p3 = new Point(var[7], var[8]);
		Point p2 = new Point();
		Point p4 = new Point();
		
		double diagonal = Math.sqrt(Math.pow(p3.x - p1.x, 2) + Math.pow(p3.y - p1.y, 2));
		double angDeg    = 45 - Math.toDegrees(Math.atan2((p3.y - p1.y), (p3.x - p1.x)));
		double side     = diagonal/Math.sqrt(2);
		
		p2.x = (int) (p1.x + side * Math.cos(Math.toRadians(angDeg)));
		p2.y = (int) (p1.y - side * Math.sin(Math.toRadians(angDeg)));
		p4.x = (int) (p3.x - side * Math.sin(Math.toRadians(angDeg)));
		p4.y = (int) (p3.y + side * Math.cos(Math.toRadians(angDeg)));
		
		line l1 = new line(  p1, getSlope( p1, p2 )  );
		line l2 = new line(  p2, getSlope( p2, p3 )  );
		line l3 = new line(  p3, getSlope( p3, p4 )  );
		line l4 = new line(  p4, getSlope( p4, p1 )  );
		
		//////////////////////////////////////////////////////////////////////////////
		//algorithm
		//w, h, x_circle, y_circle, r,  x1, y1,   x3, y3
		//20,16,       9,        6, 5, (16,14),  (8,14)
		//3-1. 이중for문으로 점(x:20 * y:16 좌표계)들을 찍으면서(9,6)과의 거리(d)를 잰다.
		//거리(d)가 5(r)보다 작거나 같으면 #을 찍고 d가 5(r)보다 크면 .을 찍는다.
		//3-2. 두 점 P1(x1,y1) P3(x3,y3)로 나머지 두점 P2(x2,y2) P4(x4,y4)을 구한다.
		//P1-P2, P2-P3, P3-P4, P4-P1 의 그래프를 만든다.
		//y값이 P1-P2, P2-P3 보다 작고 P3-P4, P4-P1보다 큰 좌표에 #을 찍고 그 외에는 .을 찍는다
		//////////////////////////////////////////////////////////////////////////////

//		20 16
//		9 6 5
//		16 14 8 14
		
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				if(getRadius(x_circle, y_circle, x, y) <= r) {
					out.print("#");
				} else if (y <= graph(x, l1) && y <= graph(x, l2) 
						&& y >= graph(x, l3) && y >= graph(x, l4)) {
					out.print("#");
				}else {
					out.print(".");
				}
			}
			out.println();
		}// for end;
		

	}// solve end;			
	

	private static double graph(int x, line line) {
		double res_y = 0;
		res_y = (line.slope * x) + line.point.y - (line.slope * line.point.x);
		return res_y;
	}
	
	private static double getSlope(Point p1, Point p2) {
		return (p2.y - p1.y) / (p2.x - p1.x);
	}
	
	private double getRadius(int x_circle, int y_circle, int x, int y) {
		return Math.sqrt(Math.pow((x_circle - x), 2) + Math.pow((y_circle - y), 2));
	}
	
	public static class line {
		double slope;
		Point point;
		public line() {};
		public line(Point point, double slope) {
			// TODO Auto-generated constructor stub
			this.point = point;
			this.slope = slope;
		}
	}
	
	private int[] getVar(Util util) {
		int[] var = new int[TOTAL_VAR_CNT];
		
		int varCnt = 1;
		System.out.println("======================================");
		while (varCnt > 0) {

			System.out.print("insert {width, height} : ");
			int[] width_height = util.getVariables();
			
			if(WIDTH_HEIGHT != width_height.length) {
				continue;
			}
			
			var[0] = width_height[0];
			var[1] = width_height[1];
			
			varCnt--;
			
		}// width_height while end;
		varCnt = 1;
		while (varCnt > 0) {

			System.out.print("insert {x_circle, y_circle, r} : ");
			int[] circle_xyr = util.getVariables();
			
			if(CIRCLE_XYR != circle_xyr.length) {
				continue;
			}
			
			var[2] = circle_xyr[0];
			var[3] = circle_xyr[1];
			var[4] = circle_xyr[2];
			
			varCnt--;
			
		}// circle_xyr while end;
		varCnt = 1;
		while (varCnt > 0) {

			System.out.print("insert {x1, y1, x3, y3} : ");
			int[] xy13 = util.getVariables();
			
			if(XY13 != xy13.length) {
				continue;
			}
			
			var[5] = xy13[0];
			var[6] = xy13[1];
			var[7] = xy13[2];
			var[8] = xy13[3];
			
			varCnt--;
			
		}// xy13 while end;
		System.out.println("======================================");
		
		return var;
	}//getVar

} // class Raster end;
