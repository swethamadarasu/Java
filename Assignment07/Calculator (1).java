/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 7           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Lakshmi Swetha Madarasu                     *  
 *                                                          *
 *  Date Due:   11/07/2018                                  *                          
 *                                                          *
 *  Purpose:    GUI Introduction 12.9 Calculator            *
 *              Understanding control placements and        *
 *              handling actions on them.                   *                                                                                                                    * 
 ***********************************************************/ 
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Calculator extends JFrame implements ActionListener {
  
  //declaring variables for controls
  JButton buttons[];
  JTextField displayTextField;
  JPanel buttonBoard;
  public Calculator()
  {
    super("Calculator");
    //instantiation
    displayTextField = new JTextField(20);
    displayTextField.setEditable(true);
    displayTextField.addActionListener(this);
    //setting size of buttons array as 16 buttons are required 
    buttons = new JButton[16];
    
    //setting the text on the new button from 1 to 9 depending on button no
    for(int i = 0; i<= 9 ;i++)
    {
      buttons[i] = new JButton(String.valueOf(i));
      buttons[i].addActionListener(this);
      
    }
    //adding text (operator symbold on the buttons)
    buttons[10] = new JButton("/");
    buttons[10].addActionListener(this);
    buttons[11] = new JButton("*");
    buttons[11].addActionListener(this);
    buttons[12] = new JButton("-");
    buttons[12].addActionListener(this);
    buttons[13] = new JButton("+");
    buttons[13].addActionListener(this);
    buttons[14] = new JButton("=");
    buttons[14].addActionListener(this);
    buttons[15] = new JButton(".");
    buttons[15].addActionListener(this);
    //creating a panel with grid layout of 4 by 4
    buttonBoard = new JPanel();
    buttonBoard.setLayout(new GridLayout( 4, 4));
    //adding buttons to panel -7 to 10
    for(int i = 7 ;i<= 10;i++)
    {
      buttonBoard.add(buttons[i]);
      
    }
    //adding 4 to 6
    for(int i = 4;i<= 6;i++)
    {
      buttonBoard.add(buttons[i]);
    }
    //adding *
    buttonBoard.add(buttons[11]);
    //adding 1 to 3
    for(int i =1 ;i <= 3;i++)
    {
      buttonBoard.add(buttons[i]);
      
    }
    //adding -
    buttonBoard.add(buttons[12]);
    //adding 0
    buttonBoard.add(buttons[0]);
    //adding .,=,+
    for(int i = 15; i>= 13;i--)
    {
      buttonBoard.add(buttons[i]);
    }
    //adding the text field and all the buttons in panel in grid layout to the container
    Container hold = getContentPane();
    hold.add(buttonBoard, BorderLayout.CENTER);
    hold.add(displayTextField,BorderLayout.NORTH);
    setSize(200,200);
    setVisible(true);
    
    
    
    
  }
  public void actionPerformed(ActionEvent e)
  {
    //if 1 to 9 buttons are selected the messag edialog with the clicked button no will be displayed
    for(int i = 0; i<= 9 ;i++)
    {
      if(e.getSource() == buttons[i])
      {
        JOptionPane.showMessageDialog(null, i+" was clicked");
      }
    }
    //if the opertaors are clicked will display the operators
    if(e.getSource() == buttons[10])
    {
      JOptionPane.showMessageDialog(null, "/ was clicked");
    }
    else if(e.getSource() == buttons[11])
    {
      JOptionPane.showMessageDialog(null, "* was clicked");
    }
    else if(e.getSource() == buttons[12])
    {
      JOptionPane.showMessageDialog(null, "- was clicked");
    }
    else if(e.getSource() == buttons[13])
    {
      JOptionPane.showMessageDialog(null, "+ was clicked");
    }
    else if(e.getSource() == buttons[14])
    {
      JOptionPane.showMessageDialog(null, "= was clicked");
    }
    else if(e.getSource() == buttons[15])
    {
      JOptionPane.showMessageDialog(null, ". was clicked");
    }
    //if the text field is selected, display the text
    else if(e.getSource() == displayTextField)
    {
      JOptionPane.showMessageDialog(null, "The Text Field was entered with value " + displayTextField.getText());
    }
  }
}
