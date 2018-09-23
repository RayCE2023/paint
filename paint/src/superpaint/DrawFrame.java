/*
 * Author : Rick Chen
 * 
 * Date : 2017/4/21
 * 
 * Discription: This is DrawFrame class, this class is extends of JFrame. This class has 4 inner class, such as; shapeComboBoxEventListener
 * CheckBoxEventListener, colorComboBoxEventListener, and ButtonEventListener. 
 * 
 */
package superpaint;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class DrawFrame extends JFrame {
  // Create the colorsChooser and colors for user to select the color
  private JComboBox<String> colorChooser;
  private String[] colorTypes = { "Red" , "Blue" , "Yellow" , "Green" , "White" , "Black"};
  private Color[] colors = { Color.RED , Color.BLUE , Color.YELLOW , Color.GREEN , Color.WHITE , Color.BLACK };
  
  // Create the shapeChooser and shapeTypes for user to select the shape
  private JComboBox<String> shapeChooser;
  private String[] shapeTypes = { "Oval" , "Rectangle" , "Line" };
  
  //create a lockBox called filledBox for filled option
  private JCheckBox filledBox;
  
  //create three 3 buttons for undo, redo and clear
  private JButton[] buttons = new JButton[3];
  private String[] buttonType = {"Undo" , "Redo" ,  "Clear" };
  
  //Create a object for DrawPanel,a JLabel and the LinkedLists 
  private DrawPanel drawPanel;
  private LinkedList<Shape> linkedList = new LinkedList<>();
  private LinkedList<Shape> linkedList2 = new LinkedList<>();
  private JLabel pText = new JLabel();
  
  //Create a panel called top for north layer of the border
  JPanel top;
  
  public DrawFrame() {
    
	 super ("Nested Layout Manager Demo");
    //steps for create the panel on the top
    top = new JPanel();
    
    //steps for set the color
    colorChooser = new JComboBox<String>( colorTypes );
    colorChooser.setMaximumRowCount(4);
    colorChooser.addItemListener(new colorComboBoxEventListener());
    
    //steps for the shape
    shapeChooser = new JComboBox<String>( shapeTypes );
    shapeChooser.setMaximumRowCount(3);
    shapeChooser.addItemListener(new shapeComboBoxEventListener());
    
    //steps about the Filled box
    filledBox = new JCheckBox("Filled");
    filledBox.addItemListener( new CheckBoxEventListener());
    
    //steps for create a undo button
    for (int i = 0; i <3 ; i++){
       buttons[i] = new JButton(buttonType[i]);
       buttons[i].addActionListener(new ButtonEventListener());
       top.add(buttons[i]);
    }

    drawPanel = new DrawPanel(  pText, linkedList);
    
    add( top , BorderLayout.NORTH );
    top.add( shapeChooser);
    top.add( colorChooser);
    top.add( filledBox );
    add( drawPanel, BorderLayout.CENTER);
    add(pText , BorderLayout.SOUTH);

  } 
  
  
  //This is CheckBoxEventListener
  class CheckBoxEventListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e){
      if ( filledBox.isSelected() ){
        drawPanel.filledBox(true);
      }
      else{
        drawPanel.filledBox(false);
      }
    }
  }
  
  //This is colorComboBoxEventListener class
  class colorComboBoxEventListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e){
      drawPanel.colorSelected(colors[colorChooser.getSelectedIndex()]);
    }    
  }
  
   //This is shapeComboBoxEventListener class
  class shapeComboBoxEventListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e){
      drawPanel.shapeSelected(shapeChooser.getSelectedIndex());
    }    
  }
  
  //This is ButtonEventListener class
  class ButtonEventListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == buttons[2]){
        linkedList.clear();
        repaint();
      }
      else if( e.getSource() == buttons[0]){
        linkedList2.addFirst(linkedList.removeFirst());
        repaint();
      }
      else if(e.getSource() == buttons[1]){
        if (linkedList2.isEmpty() == false){
          linkedList.addFirst(linkedList2.removeFirst());
          repaint();
        }
      }
    }
  }
}
  