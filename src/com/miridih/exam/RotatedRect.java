package com.miridih.exam;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class RotatedRect implements Solver {
	
	public static void main(String[] args) {
		new RotatedRect().solve(System.in, System.out);		
	}	

	public static final int RECT_DATA_LENGTH = 5;

	public void solve(InputStream in, PrintStream out) {

		InputStreamReader 	reader 	= new InputStreamReader(in);
		BufferedReader 		br 		= new BufferedReader(reader);
		Util 				util 	= new Util(br);
		ArrayList<C_Rect> 	result 	= new ArrayList<C_Rect>();
		
		
		System.out.print("Test Case Count : ");
		int testCase = util.getNumber();
		System.out.println("======================================");
		while (testCase > 0) {

			System.out.print("insert {x1, y1, w, h, a} : ");
			int[] rectData = util.getVariables();
			
			if(RECT_DATA_LENGTH != rectData.length) {
				continue;
			}
			
			LT_Rect   ltRect    = new LT_Rect();
			
			ltRect.setX1(rectData[0]);
			ltRect.setY1(rectData[1]);
			final int width 	= rectData[2];
			final int height 	= rectData[3];
			final int angle 	= rectData[4];
			
		 	double distance = Math.sqrt( Math.pow(width, 2)+Math.pow(height, 2));
			double rad      = Math.toRadians(angle);
			double ang      = Math.atan2(height/2, width/2);

			//////////////////////////////////////////////////////////////////////////////
			// algorithm
			// x좌표:    x1-0.5w+0.5sqt(  pow(w,2)+pow(h,2)  )*cos( a+arctan( (w/2)/(h/2) ) )
			// y좌표:		y1-0.5h+0.5sqt(  pow(w,2)+pow(h,2)  )*sin( a+arctan( (w/2)/(h/2) ) )		
			//////////////////////////////////////////////////////////////////////////////
				
			//////////////////////////////////////////////////////////////////////////////
			// x좌표:    x1-0.5w+0.5sqt(  pow(w,2)+pow(h,2)  )*cos( a+arctan( (w/2)/(h/2) ) )
			// y좌표:		y1-0.5h+0.5sqt(  pow(w,2)+pow(h,2)  )*sin( a+arctan( (w/2)/(h/2) ) )		
			//////////////////////////////////////////////////////////////////////////////
			
			double tmpX2 = ltRect.getX1()-0.5*width+0.5*distance*Math.cos(rad+ang);
			double tmpY2 = ltRect.getY1()-0.5*height+0.5*distance*Math.sin(rad+ang);

			C_Rect cRect    = new C_Rect();
			cRect.setX2((int)Math.round(tmpX2));
			cRect.setY2((int)Math.round(tmpY2));

			result.add(cRect);
			testCase--;
			
		}// testCase while end;
		System.out.println("======================================");
		
		Iterator<C_Rect> iter = result.iterator();
		while(iter.hasNext()) {
			C_Rect cRect = iter.next();
			out.println(cRect.getX2()+" "+cRect.getY2());
		}		
		
	}// solve method end;			
	
	 private Point rotation(Point mP, Point sP, double rad) {
		  int x, y;
		  //double rad = Math.toRadians(degree);

		  // 이동 후 좌표(x) = 현재 옮기고자 하는 좌표(mP.x) - x축의 중점(sP.x)
		  x = (int) (((mP.x - sP.x) * Math.cos(rad) - (mP.y - sP.y) * Math.sin(rad)) + sP.x);
		  y = (int) (((mP.x - sP.x) * Math.sin(rad) + (mP.y - sP.y) * Math.cos(rad)) + sP.y);
		  Point myPoint = new Point(x, y);
		  return myPoint;
	 }

	private class LT_Rect{
		
		private int x1;
		private int y1;
		
		public LT_Rect() {
			this.x1 = 0;
			this.y1 = 0;
		}
		
		public int getX1() {
			return x1;
		}
		public void setX1(int x1) {
			this.x1 = x1;
		}
		public int getY1() {
			return y1;
		}
		public void setY1(int y1) {
			this.y1 = y1;
		}
		 
	}// class LT_Rect end;
	
	private class C_Rect{
		
		private int x2;
		private int y2;
		
		public C_Rect() {
			this.x2 = 0;
			this.y2 = 0;
		}

		public int getX2() {
			return x2;
		}
		public void setX2(int x2) {
			this.x2 = x2;
		}
		public int getY2() {
			return y2;
		}
		public void setY2(int y2) {
			this.y2 = y2;
		}
		
	}// class C_Rect end
	
}// main class RotatedRect

