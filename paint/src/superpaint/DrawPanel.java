/*
 * Author: Rick Chen
 * 
 * Date: 2017/ 04/ 26
 * 
 * Discription: This is DrawPanel class that extend from Jpanel, this class is used for to draw the shapes and also tracks the mouse 
 * and displays the position of the mouse.  
 * 
 */
package superpaint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DrawPanel extends JPanel {
  private JLabel pText; 
  private Shape currentShape = null;
  private Shape temp;
  private Color color = Color.RED;
  private int shapeType;
  private LinkedList<Shape> linkedList = new LinkedList<>();
  private boolean filled;
  
  // Constructor instantiates an array of 10 Random Line objects
  public DrawPanel(JLabel pText , LinkedList<Shape> linkedList) {
    this.pText = pText;
    this.linkedList = linkedList;
    setBackground( Color.WHITE ); 
    
    // Create and register listener for mouse and mouse motion events
    MouseEventListener drawPanelListener = new MouseEventListener(); 
    addMouseListener( drawPanelListener ); 
    addMouseMotionListener( drawPanelListener );       
  } 
  
  // Inner class to handle mouse events
  class MouseEventListener extends MouseAdapter {
    // Mouse press indicates a new shape has been started
    public void mousePressed( MouseEvent event ) {
      if (!event.isMetaDown()){       
        if (shapeType == 0){
          currentShape = new Oval( event.getX(), event.getY(), event.getX(), event.getY(), color, filled);
        }
        else if (shapeType == 1){
          currentShape = new Rectangle( event.getX(), event.getY(), event.getX(), event.getY(), color, filled);
        }
        else{
          currentShape = new Line(event.getX(), event.getY(), event.getX(), event.getY(), color);           
        }         
        // Tell JVM to call paintComponent( g )
        repaint();
      } 
    }
    
    // Mouse release indicates the new shape is finished
    public void mouseReleased( MouseEvent event ) {
      
      // Update ending coordinates
      if (!event.isMetaDown()){       
        currentShape.setX2( event.getX() );
        currentShape.setY2( event.getY() );
        currentShape.setColor( color );
        
        // add the new shape to linkedList
        linkedList.addFirst(currentShape); 
      } 
      // Get ready for the next line to be drawn
      currentShape = null;
      repaint();            
    }
    
    // As mouse is dragged, update ending coordinates of currentLine and statusBar
    public void mouseDragged( MouseEvent event ) {
      if (!event.isMetaDown()){       
        currentShape.setX2( event.getX() );
        currentShape.setY2( event.getY() );
        pText.setText( String.format( "Mouse at (%d, %d)", 
                                     event.getX(), event.getY() ) );
        repaint();
      } 
    }
    public void mouseMoved( MouseEvent event ) {
      pText.setText( String.format( "Mouse at (%d, %d)", 
                                   event.getX(), event.getY() ) );
    } 
  } 
  
  // This method is called automatically by the JVM when the window needs to be (re)drawn.
  @Override
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    if (linkedList.isEmpty() == false){
      for (int i = 0; i < linkedList.size() ; i++){
        temp = linkedList.removeLast();
        temp.draw(g);
        linkedList.addFirst(temp);
      }
    }
    // If a shape is in progress, draw it on top of all others
    if ( currentShape != null )
      currentShape.draw( g );
  } 
  
  //This is the colorSelected method, this method is used for to pass the color from the DrawFrame to DrawPanel.
  public void colorSelected(Color color){
    this.color = color;
  }

  //This is the shapeSelected method, this method is used for to pass the shapeType(int) from the DrawFrame to DrawPanel.
  public void shapeSelected(int shapeType){
    this.shapeType = shapeType;
  }
  
  //This is the filledBox method, this method is used for to pass the fille(Boolean) from the DrawFrame to DrawPanel.
  public void filledBox(Boolean filled){
    this.filled = filled;
  }
} 