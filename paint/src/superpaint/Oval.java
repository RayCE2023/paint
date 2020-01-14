/*
 * Author: Raymond Chen
 * 
 * Date: 2017/04/26
 * 
 * Discription: This is the Oval class that extends from FillableShape class. This class is used for draw the ovals. 
 */
package superpaint;
import java.awt.Color;
import java.awt.Graphics;

class Oval extends FillableShape{
  
  //pass in x1,y1,x2,y2,color,and filled and  calls the super class
  public Oval(int x1, int y1, int x2, int y2, Color color, boolean filled){
    super( x1, y1, x2, y2, color, filled);
  }
  
  //For draw the oval and if the getFilled is true, it will draw the filled oval.
  public void draw( Graphics g ){
    g.setColor( getColor() );
    if( getFilled() == true){
      g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeigth());
    }
    else{
      g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeigth());
    }
  }
}
