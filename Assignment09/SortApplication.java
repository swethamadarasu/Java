/************************************************************
  *                                                          *
  *  CSCI 470/502          Assignment 9           Fall 2018  *                                             
  *                                                          *
  *  Programmer: Lakshmi Swetha Madarasu                     *  
  *                                                          *
  *  Date Due:   12/10/2018                                  *                          
  *                                                          *
  *  Purpose:    Concurrency and Animation using             *
  *              Mutithreading to display various sorting    *
  *              algorithms                                  * 
  ***********************************************************/

import java.awt.*;
import javax.swing.*;


//The sorting animation application inherits from JFrame
public class SortApplication extends JFrame {
  
  //SortPanel objects as data members
  SortPanel panel1;
  SortPanel panel2;
  public SortApplication() { 
    
    // constructor that passes a title bar string to the superclass constructor 
    super("Sort Animation");
    
    panel1 = new SortPanel();
    panel2 = new SortPanel();
    
    //adds the two SortPanel objects to the application’s layout
    add(panel1,BorderLayout.EAST);
    add(panel2,BorderLayout.WEST);
    
  }
  
  public static void main(String[] args) { 
    
    //Creates an instance of the application
    SortApplication obj = new SortApplication();
    
    //sets the default close operation,size, sets it visible and pack sets the frame to the size of the controls in the layout
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    obj.setSize(750,550); 
    obj.setVisible(true);
    obj.pack(); 
  }
  
  
  
}
