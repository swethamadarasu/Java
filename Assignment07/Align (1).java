/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 7           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Lakshmi Swetha Madarasu                     *  
 *                                                          *
 *  Date Due:   11/07/2018                                  *                          
 *                                                          *
 *  Purpose:    GUI Introduction 12.8 Align                 *
 *              Understanding control placements and        *
 *              handling actions on them.                   *                                                                                                                    * 
 ***********************************************************/ 


import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

public class Align extends JFrame implements ActionListener {
  //Declaring variables for controls
  JPanel checkBoxPanel, labelTextBoxPanel1,labelTextBoxPanel2, combinedPanel3, buttonPanel;
  JCheckBox snapToCB,showCB;
  JLabel xLabel, yLabel;
  JTextField xTextField, yTextField;
  JButton okButton, cancelButton, helpButton;
  boolean val = true;
  boolean val1 = true;
  
  public Align()
  {
    //instantiation and initialisation for a few controls
    super("Align");
    snapToCB = new JCheckBox("Snap to Grid");
    showCB = new JCheckBox("Show Grid");
    xLabel = new JLabel("X: ");
    yLabel = new JLabel("Y: ");
    xTextField = new JTextField("0", 4);
    yTextField = new JTextField("0", 4);
    okButton = new JButton("Ok");
    cancelButton = new JButton("Cancel");
    helpButton = new JButton("Help");
    Container hold = getContentPane();
    checkBoxPanel = new JPanel();
    labelTextBoxPanel1 = new JPanel();
    labelTextBoxPanel2 = new JPanel();
    combinedPanel3 = new JPanel();
    buttonPanel = new JPanel();
    
    //gridlayout to hold 2 checkboxes in one row and adding it to a panel
    checkBoxPanel.setLayout( new GridLayout(2,1 ));
    checkBoxPanel.add(snapToCB);
    checkBoxPanel.add(showCB);
    //adding a label and textfield to a panel with flowlayout
    labelTextBoxPanel1.setLayout( new FlowLayout());
    labelTextBoxPanel1.add(xLabel);
    labelTextBoxPanel1.add(xTextField);
    //adding another set of label and textfield to a panel with flowlayout
    labelTextBoxPanel2.setLayout( new FlowLayout());
    labelTextBoxPanel2.add(yLabel);
    labelTextBoxPanel2.add(yTextField);
    //adding the above 2 panels to another panel with Border layout palcing them on North and sounth respectively.
    combinedPanel3.setLayout(new BorderLayout());
    combinedPanel3.add(labelTextBoxPanel1, BorderLayout.NORTH);
    combinedPanel3.add(labelTextBoxPanel2, BorderLayout.SOUTH);
    //adding 3 buttons in one row using panel with grid layout and setting their size uniformally
    buttonPanel.setLayout(new GridLayout(3,1,9,4));
    buttonPanel.add(okButton);
    buttonPanel.add(cancelButton);
    buttonPanel.add(helpButton);
    
    //adding all the panels to a container
    hold.setLayout(new FlowLayout( FlowLayout.CENTER, 10,4));
    hold.add(checkBoxPanel);
    hold.add(combinedPanel3);
    hold.add(buttonPanel);
    
    setSize(300, 150);
    setVisible(true);
    
    //adding action listeners to all the controls
    okButton.addActionListener(this);
    cancelButton.addActionListener(this);
    helpButton.addActionListener(this);
    snapToCB.addActionListener(this);
    showCB.addActionListener(this);
    xTextField.addActionListener(this);
    yTextField.addActionListener(this);
    
    
  }
  //method called when an action performed on one of the controls
  public void actionPerformed(ActionEvent e)
  {
    //identifying the control using its name and displaying a message with the control details using showMessageDialog
    //buttons
    if(e.getSource() == okButton)
    {
      JOptionPane.showMessageDialog(null, "Ok button was clicked");
    }
    else if(e.getSource() == cancelButton)
    {
      JOptionPane.showMessageDialog(null,"Cancel button was clicked");
    }
    else if(e.getSource() == helpButton)
    {
      JOptionPane.showMessageDialog(null,"Help button was clicked");
    }
    //checkboxes
    else if(e.getSource() == snapToCB)
    {
      if(val == false)
      {
        JOptionPane.showMessageDialog(null, "Snap to grid Check Box unSelected");
        val = true;
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Snap to grid Check Box selected");
        val = false;
      }
    }
    else if(e.getSource() == showCB)
    {
      if(val1 == false)
      {
        JOptionPane.showMessageDialog(null, "Show grid Check Box unSelected");
        val1 = true;
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Show grid Check Box selected");
        val1 = false;
      }
    }
    //textfields
    else if(e.getSource() == xTextField)
    {
      JOptionPane.showMessageDialog(null,"X text field is entered : "+ xTextField.getText());
    }
    else if(e.getSource() == yTextField)
    {
      JOptionPane.showMessageDialog(null, "Y text field is entered : "+yTextField.getText());
    }
  }
}



