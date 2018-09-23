/*
 * Author: Rick Chen
 * 
 * Date: 2017/04/ 26
 * 
 * Discription: This is the Fillableshape abstract class that extends from Shape class.This class is used for to set whether fill the color for the shape or not.
 * Also, this class returns the upper left x,y , width and length of the shape.
 * 
 */
package superpaint;
import java.awt.Color;

public abstract class FillableShape extends Shape{
  private boolean filled;
  
  //pass in x1,y1,x2,y2,color,and filled. Called the super class and set the filled 
  public FillableShape( int x1, int y1, int x2, int y2, Color color, boolean filled ){
    super(x1,y1,x2,y2,color);
    this.filled = filled;
  }
  
  //This method is for set the filled
  public void setFilled( boolean filled){
    this.filled = filled;
  }
  
  //to return the filled in Boolean
  public boolean getFilled(){
    return filled;  
  }
  
  //To return the upper left x of the shape
  public int getUpperLeftX(){
    return Math.min( getX1() , getX2() );
  }
  
  //To return the upper left y of the shape
  public int getUpperLeftY(){
    return Math.min( getY1() , getY2()  );
  }
  
  //To return the width of the shape
  public int getWidth(){
    return Math.abs( getX1() - getX2() );
  }
  
  //To return the length of the shape
  public int getHeigth(){
    return Math.abs( getY1() - getY2() );
  }
}