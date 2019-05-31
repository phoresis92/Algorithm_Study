package test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class myPoint
{
 double x;
 double y;
 public myPoint(double x, double y)
 {
  // TODO Auto-generated constructor stub
  this.x = x;
  this.y = y;
 }
}

class Top
{
 // 폴리곤 x 좌표 : 430, 530, 530, 430
 // 폴리곤 y 좌표 : 100, 100, 500, 500
 // Line 좌표 : 150, 170, 800, 170
 private myPoint p1, p2, p3, p4; // 네개의 좌표
 private int[] xmyPoints = new int[4];
 private int[] ymyPoints = new int[4];
 private myPoint rotP; // 중점
 private myPoint line;

 public Top()
 {
  // TODO Auto-generated constructor stub
 }

 //p1 p2 p3 p4를  xmyPoint ymyPoint에 넣기
 void SetmyPoints()
 {
  xmyPoints[0] = (int)p1.x;
  xmyPoints[1] = (int)p2.x;
  xmyPoints[2] = (int)p3.x;
  xmyPoints[3] = (int)p4.x;

  ymyPoints[0] = (int)p1.y;
  ymyPoints[1] = (int)p2.y;
  ymyPoints[2] = (int)p3.y;
  ymyPoints[3] = (int)p4.y;
 }

 public void paint(Graphics g)
 {
  // myPoint 객체의 x, y 좌표와 점의 개수
  g.fillPolygon(xmyPoints, ymyPoints, ymyPoints.length);
  // g.fillPolygon(new int[] { 430, 530, 530, 430 }, new int[] { 100, 100,
  // 500, 500 }, 4);
  g.drawLine((int)line.x, (int)line.y, (int)line.x + 650, (int)line.y);
 }

 public void rotate(int rad)
 {
  p1 = rotation(p1, rotP, rad);
  p2 = rotation(p2, rotP, rad);
  p3 = rotation(p3, rotP, rad);
  p4 = rotation(p4, rotP, rad);
  
  SetmyPoints();
 }

 private myPoint rotation(myPoint mP, myPoint sP, double degree)
 {
  double x, y;
  double rad = Math.toRadians(degree);

  // 이동 후 좌표(x) = 현재 옮기고자 하는 좌표(mP.x) - x축의 중점(sP.x)
  x = ((mP.x - sP.x) * Math.cos(rad) - (mP.y - sP.y) * Math.sin(rad)) + sP.x;
  y = ((mP.x - sP.x) * Math.sin(rad) + (mP.y - sP.y) * Math.cos(rad)) + sP.y;
  myPoint myPoint = new myPoint(x, y);
  return myPoint;
 }

 public myPoint getP1()
 {
  return p1;
 }

 public void setP1(myPoint p1)
 {
  this.p1 = p1;
 }

 public myPoint getP2()
 {
  return p2;
 }

 public void setP2(myPoint p2)
 {
  this.p2 = p2;
 }

 public myPoint getP3()
 {
  return p3;
 }

 public void setP3(myPoint p3)
 {
  this.p3 = p3;
 }

 public myPoint getP4()
 {
  return p4;
 }

 public void setP4(myPoint p4)
 {
  this.p4 = p4;
 }

 public myPoint getRotP()
 {
  return rotP;
 }

 public void setRotP(myPoint rotP)
 {
  this.rotP = rotP;
 }

 public myPoint getLine()
 {
  return line;
 }

 public void setLine(myPoint line)
 {
  this.line = line;
 }
}
