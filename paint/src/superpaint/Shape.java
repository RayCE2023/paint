/*
 * Author: Raymond Chen
 * 
 * Date: 2017/04/26
 * 
 * Discription: This is the Shape abstract class, this class contains many basic methods from draw a shape. 
 */
package superpaint;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape{
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  private Color color;
  
  // pass in x1,y1,x2,y2 and color and calls setX1(x1)...setColor(color)
  public Shape( int x1, int y1, int x2, int y2, Color color){
     setX1( x1);
     setY1( y1); 
     setX2( x2); 
     setY2( y2); 
     setColor( color); 
  }
  
  //return the x1
  public int getX1(){
   return x1; 
  }
  
  //return the y1
  public int getY1(){
   return y1; 
  }
  
  //return the x2
  public int getX2(){
   return x2; 
  }
  
  //return the y2
  public int getY2(){
   return y2; 
  }
  
  //return the color
  public Color getColor(){
    return color;
  }
  
  //set the x1
  public void setX1(int x1){
    this.x1 = Math.abs(x1);
  }
  
  //set the y1
  public void setY1(int y1){
    this.y1 = Math.abs(y1);
  }
  
  //set the x2
  public void setX2(int x2){
    this.x2 = x2;
  }
  
  //set the y2
  public void setY2(int y2){
    this.y2 = y2;
  }
  
  //set the color
  public void setColor( Color color){
    this.color = color;
  }
  
  //this is abreact method
  public abstract void draw( Graphics g );
}
