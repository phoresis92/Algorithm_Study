package test;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Test extends JFrame
{
 Top top = new Top();
 int angle = 5;
 public Test()
 {
  // TODO Auto-generated constructor stub
  top.setP1(new myPoint(430, 100));
  top.setP2(new myPoint(530, 100));
  top.setP3(new myPoint(530, 500));
  top.setP4(new myPoint(430, 500));
  top.setLine(new myPoint(100, 170));
  
  top.setRotP(new myPoint(480,300));//직사각형의 센터
  
  top.rotate(0);  

  this.setVisible(true);
  this.setSize(800, 600);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  //좌우 키를 누루면 회전
  this.addKeyListener(new KeyAdapter()
  {
   @Override
   public void keyPressed(KeyEvent e)
   {
    // TODO Auto-generated method stub
    if(e.getKeyCode() == KeyEvent.VK_LEFT)
     top.rotate(-angle);
    
    if(e.getKeyCode() == KeyEvent.VK_RIGHT)
     top.rotate(angle);
    
    repaint();
   }
  });  
 }

 @Override
 public void paint(Graphics g)
 {
  // TODO Auto-generated method stub
  g.clearRect(0, 0, 800,600);//화면 전체 지우기
  top.paint(g);
 }
 
 
 public static void main(String args[])
 {
  new Test();
 }
}