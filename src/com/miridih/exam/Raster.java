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

		Util util = new Util(new BufferedReader(new InputStreamReader(in)));

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
		Point p2 = new Point();
		Point p3 = new Point(var[7], var[8]);
		Point p4 = new Point();
		
		double diagonal = Math.sqrt(Math.pow(p3.getX() - p1.getX(), 2) + Math.pow(p3.getY() - p1.getY(), 2));
		double angDeg   = 45 - Math.toDegrees(Math.atan2((p3.getY() - p1.getY()), (p3.getX() - p1.getX())));
		double side     = diagonal/Math.sqrt(2);
		
		double calcX    = side * Math.cos(Math.toRadians(angDeg));
		double calcY    = side * Math.sin(Math.toRadians(angDeg));
		
		p2.x = (int) (p1.getX() + calcX);
		p2.y = (int) (p1.getY() - calcY);
		p4.x = (int) (p3.getX() - calcX);
		p4.y = (int) (p3.getY() + calcY);
		
		
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				if(calcRadius(x_circle, y_circle, x, y) <= r) {
					out.print("#");
				}else if(y <= calcY(p1,p2,x) &&
						 y <= calcY(p2,p3,x) &&
					     y >= calcY(p3,p4,x) &&
					     y >= calcY(p4,p1,x)) {
					out.print("#");
				}else {
					out.print(".");
				}
			}
			out.println();
		}// for end;
		

	}// solve end;
	
	private double calcRadius(int x_circle, int y_circle, int x, int y) {
		return Math.sqrt(Math.pow((x_circle - x), 2) + Math.pow((y_circle - y), 2));
	}
	
	private double calcY(Point p1, Point p2, int x) {
		double slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
		return  (slope * x) + p1.getY() - (slope * p1.getX());
	}
	
	private int[] getVar(Util util) {
		int[] var = new int[TOTAL_VAR_CNT];
		
		int varCnt = 1;
//		System.out.println("======================================");
		while (varCnt > 0) {

//			System.out.print("insert {width, height} : ");
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

//			System.out.print("insert {x_circle, y_circle, r} : ");
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

//			System.out.print("insert {x1, y1, x3, y3} : ");
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
//		System.out.println("======================================");
		
		return var;
	}//getVar

} // class Raster end;
