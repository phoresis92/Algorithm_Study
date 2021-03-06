package com.miridih.exam;

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

		Util util = new Util(new BufferedReader(new InputStreamReader(in)));
		ArrayList<C_Rect> result = new ArrayList<C_Rect>();
		
		
//		System.out.print("Test Case Count : ");
		int testCase = util.getNumber();
//		System.out.println("======================================");
		while (testCase > 0) {

//			System.out.print("insert {x1, y1, w, h, a} : ");
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
			
		 	double diagonal     = Math.sqrt( Math.pow(width, 2)+Math.pow(height, 2));
			double rad          = Math.toRadians(angle);
			double ang          = Math.atan2(height/2, width/2);  

			double movedCenterX = 0.5*diagonal*Math.cos(rad+ang);
			double movedCenterY = 0.5*diagonal*Math.sin(rad+ang);
			
			double tmpX2 = ltRect.getX1() - 0.5*width   +  movedCenterX;
			double tmpY2 = ltRect.getY1() - 0.5*height  +  movedCenterY;
			
			
			C_Rect cRect    = new C_Rect();
			cRect.setX2((int)Math.round(tmpX2));
			cRect.setY2((int)Math.round(tmpY2));

			result.add(cRect);
			testCase--;
			
		}// testCase while end;
//		System.out.println("======================================");
		
		Iterator<C_Rect> iter = result.iterator();
		while(iter.hasNext()) {
			C_Rect cRect = iter.next();
			out.println(cRect.getX2()+" "+cRect.getY2());
		}		
		
	}// solve method end;			

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

