package com.miridih.exam;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class RotatedRect implements Solver {
	
	
	public static void main(String[] args) {
		new RotatedRect().solve(System.in, System.out);		
	}	

	public static final int RECT_DATA_LENGTH = 5;

	public void solve(InputStream in, PrintStream out) {

		InputStreamReader 	reader 	= new InputStreamReader(in);
		BufferedReader 		br 		= new BufferedReader(reader);
		Util 				util 	= new Util(br);
		
		LT_Rect             ltRect  = new LT_Rect();
		C_Rect              cRect   = new C_Rect();

		
		System.out.print("Test Case Count : ");
		int testCase = util.getNumber();
		System.out.println("======================================");
		while (testCase > 0) {

			System.out.print("insert {x1, y1, w, h, a} : ");
			int[] rectData = util.getPredict();
			
			if(RECT_DATA_LENGTH != rectData.length) {
				continue;
			}
			
			ltRect.setX1(rectData[0]);
			ltRect.setY1(rectData[1]);
			
			final int width 	= rectData[2];
			final int height 	= rectData[3];
			final int angle 	= rectData[4];
			
			out.println(rotation(new Point(ltRect.getX1()+width, ltRect.getY1()),ltRect.getPointLT1(),angle).getX());;
			out.println(rotation(new Point(ltRect.getX1()+width, ltRect.getY1()),ltRect.getPointLT1(),angle).getY());;
			
			
			testCase--;
		}// testCase while end;
		System.out.println("======================================");
		
		
	}// solve end;			


private Point rotation(Point targetP, Point rotP, double degree)
{
 int x, y;
 double rad = Math.toRadians(degree);

 // 이동 후 좌표(x) = 현재 옮기고자 하는 좌표(mP.x) - x축의 중점(sP.x)
 x = (int)((targetP.x - rotP.x) * Math.cos(rad) - (targetP.y - rotP.y) * Math.sin(rad)) + rotP.x;
 y = (int)((targetP.x - rotP.x) * Math.sin(rad) + (targetP.y - rotP.y) * Math.cos(rad)) + rotP.y;
 Point myPoint = new Point(x,y);
 return myPoint;
}

}// class Solver end;

class LT_Rect{
	
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];
	 
	public int getX1() {
		return xPoints[1];
	}
	public void setX1(int x1) {
		this.xPoints[1] = x1;
	}
	public int getX2() {
		return xPoints[2];
	}
	public void setX2(int x2) {
		this.xPoints[2] = x2;
	}
	public int getX3() {
		return xPoints[3];
	}
	public void setX3(int x3) {
		this.xPoints[3] = x3;
	}
	public int getX4() {
		return xPoints[4];
	}
	public void setX4(int x4) {
		this.xPoints[4] = x4;
	}
	public int getY1() {
		return yPoints[1];
	}
	public void setY1(int y1) {
		this.yPoints[1] = y1;
	}
	public int getY2() {
		return yPoints[2];
	}
	public void setY2(int y2) {
		this.yPoints[2] = y2;
	}
	public int getY3() {
		return yPoints[3];
	}
	public void setY3(int y3) {
		this.yPoints[3] = y3;
	}
	public int getY4() {
		return yPoints[4];
	}
	public void setY4(int y4) {
		this.yPoints[4] = y4;
	}
	
	public Point getPointLT1(){
		return new Point(xPoints[1], yPoints[1]);
	}
	public Point getPointRT2(){
		return new Point(xPoints[2], yPoints[2]);
	}
	public Point getPointLB3(){
		return new Point(xPoints[3], yPoints[3]);
	}
	public Point getPointRB4(){
		return new Point(xPoints[4], yPoints[4]);
	}
	
}

class C_Rect{
	
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];
	
	public int getX1() {
		return xPoints[1];
	}
	public void setX1(int x1) {
		this.xPoints[1] = x1;
	}
	public int getX2() {
		return xPoints[2];
	}
	public void setX2(int x2) {
		this.xPoints[2] = x2;
	}
	public int getX3() {
		return xPoints[3];
	}
	public void setX3(int x3) {
		this.xPoints[3] = x3;
	}
	public int getX4() {
		return xPoints[4];
	}
	public void setX4(int x4) {
		this.xPoints[4] = x4;
	}
	public int getY1() {
		return yPoints[1];
	}
	public void setY1(int y1) {
		this.yPoints[1] = y1;
	}
	public int getY2() {
		return yPoints[2];
	}
	public void setY2(int y2) {
		this.yPoints[2] = y2;
	}
	public int getY3() {
		return yPoints[3];
	}
	public void setY3(int y3) {
		this.yPoints[3] = y3;
	}
	public int getY4() {
		return yPoints[4];
	}
	public void setY4(int y4) {
		this.yPoints[4] = y4;
	}
	
	public Point getPointLT1(){
		return new Point(xPoints[1], yPoints[1]);
	}
	public Point getPointRT2(){
		return new Point(xPoints[2], yPoints[2]);
	}
	public Point getPointLB3(){
		return new Point(xPoints[3], yPoints[3]);
	}
	public Point getPointRB4(){
		return new Point(xPoints[4], yPoints[4]);
	}
	
}
