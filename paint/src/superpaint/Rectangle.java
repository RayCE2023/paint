/*
 * Author: Raymond Chen
 * 
 * Date: 2017/04/26
 * 
 * Discription: This is the Rectangle class that extends from FillableShape class. This class is used for draw the rectangles. 
 */
package superpaint;
import java.awt.Color;
import java.awt.Graphics;

class Rectangle extends FillableShape{
  
  //pass in x1,y1,x2,y2,color,and filled and calls the super class
  public Rectangle( int x1, int y1, int x2, int y2, Color color, boolean filled ){
    super( x1, y1, x2, y2, color, filled);
  }
  
  //For draw the rectangle and if the getFilled is true, it will draw the filled rectangle.
  public void draw(Graphics g){
    g.setColor( getColor() );
    if( getFilled() == true){
      g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeigth());
    }
    else{
      g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeigth());
    }
  }
}
