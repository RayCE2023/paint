/*
 * Author: Raymond Chen
 * 
 * Date: 2017/04/26
 * 
 * Discription: This is the Line class that extends from Shape class. This class is used for draw the lines. 
 */
package superpaint;
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
  
  //pass in x1,y1,x2,y2,and color and calls the super class.
  public Line( int x1, int y1, int x2, int y2, Color color ) {
    super( x1, y1, x2, y2, color);
  } 
  
  //to set the color and draw the line 
  public void draw( Graphics g ) {
    g.setColor( getColor() );
    g.drawLine( getX1(), getY1(), getX2(), getY2() );
  } 
} 
