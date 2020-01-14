/*
 * Arthur: Raymond Chen
 * 
 * Date: 2017/04/26
 * 
 * Desciption: This is the main class called SuperPaint.
 * 
 */

package superpaint;

import javax.swing.JFrame;

class SuperPaint{
  public static void main(String[] args){
    //calls the DrawFrame class.
    DrawFrame application = new DrawFrame();
    
    application.setSize(600,600);   //set the size to 600 x 600
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    application.setVisible( true );
  
  }
}
