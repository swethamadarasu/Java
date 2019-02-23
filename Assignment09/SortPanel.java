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
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.JApplet;


//inherits from JPanel
public class SortPanel extends JPanel {
   
  //declaring all the controls and flags
  public JButton populate;
  public JButton startSort;
  public JComboBox<String> sortSpeed;
  public String[] sortSpeedOptions = {"Select Speed","Fast","Medium","Slow"}; 
  public JComboBox<String> sortType;
  public String[] sortTypeOptions = {"Select","Bubble Sort","Selection Sort","Insertion Sort"}; 
  public JButton asc;
  public JButton desc;
  public JButton pause;
  public JButton resume;
  public JButton stop;
  public String inputFromCombo;
  
  Border border;
  GridBagLayout gridLayout = new GridBagLayout();          
  GridBagConstraints gridConstraints = new GridBagConstraints(); 
  public boolean flag = true;
  public boolean sortFlag = true;
  public boolean sortTypeFlag = false;
  
  //has SortAnimationPanel as one of its data members
  public SortAnimationPanel animPanelObj;
  
  
  public SortPanel() { 
    
    //creating all the controls
    animPanelObj = new SortAnimationPanel();
    populate = new JButton("Populate");                
    populate.setPreferredSize(new Dimension(110,25));
    startSort = new JButton("Sort");                          
    startSort.setPreferredSize(new Dimension(110,25));
    sortType = new JComboBox<String>(sortTypeOptions);
    sortType.setPreferredSize(new Dimension(110,25));
    sortSpeed = new JComboBox<String>(sortSpeedOptions);
    sortSpeed.setPreferredSize(new Dimension(110,25));
    asc = new JButton("Asc");                
    asc.setPreferredSize(new Dimension(110,25));
    desc = new JButton("Desc");                          
    desc.setPreferredSize(new Dimension(110,25));
    pause = new JButton("Pause");                
    pause.setPreferredSize(new Dimension(110,25));
    resume = new JButton("Resume");                          
    resume.setPreferredSize(new Dimension(110,25));
    stop = new JButton("Stop");                          
    stop.setPreferredSize(new Dimension(110,25));
    
    //setting visibility of controls on the initial load
    populate.setEnabled(true);
    startSort.setEnabled(false);
    resume.setEnabled(false);
    stop.setEnabled(false);
    pause.setEnabled(false);
    asc.setEnabled(false);
    desc.setEnabled(false);
    sortType.setEnabled(false);
    sortSpeed.setEnabled(false);
    
    border= BorderFactory.createRaisedBevelBorder();       
    this.setBorder(border);
    this.setLayout(gridLayout);                               
    this.setVisible(true);
    
    
    //setting the position of the controls using GridBagConstraints
    gridConstraints.fill = GridBagConstraints.BOTH;                    
    
    
    gridConstraints.gridx =0;
    gridConstraints.gridy =0 ;
    gridConstraints.gridheight = 4;
    gridConstraints.gridwidth = 4;
    this.add(animPanelObj, gridConstraints);
    
    
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 4;  
    gridConstraints.gridwidth = 1;
    this.add(populate,gridConstraints);  
    
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 4;
    gridConstraints.gridheight = 1;
    gridConstraints.gridwidth = 1;
    this.add(sortType, gridConstraints);
    
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 4;    
    gridConstraints.gridwidth = 1;
    this.add(asc, gridConstraints);   
    
    
    gridConstraints.gridx = 3;
    gridConstraints.gridy = 4;  
    gridConstraints.gridwidth = 1;
    this.add(desc,gridConstraints);
    
    gridConstraints.gridx = 0;
    gridConstraints.gridy = 8;  
    gridConstraints.gridwidth = 1;
    this.add(sortSpeed,gridConstraints);
    
    gridConstraints.gridx = 1;
    gridConstraints.gridy = 8;  
    gridConstraints.gridwidth = 1;
    this.add(startSort,gridConstraints); 
    
    gridConstraints.gridx = 2;
    gridConstraints.gridy = 8;  
    gridConstraints.gridwidth = 1;
    this.add(pause,gridConstraints);     
    
    
    gridConstraints.gridx = 3 ;
    gridConstraints.gridy = 8;  
    gridConstraints.gridwidth = 1;
    this.add(resume,gridConstraints); 
    
    gridConstraints.gridx = 0 ;
    gridConstraints.gridy = 12;  
    gridConstraints.gridwidth = 1;
    this.add(stop,gridConstraints);
    
    //creating the class that implements ActionListener to handle the button cicks
    ButtonHandlerClass obj = new ButtonHandlerClass();
    populate.addActionListener(obj); 
    startSort.addActionListener(obj);
    asc.addActionListener(obj);
    desc.addActionListener(obj);
    pause.addActionListener(obj);
    resume.addActionListener(obj);
    stop.addActionListener(obj);
    
    //Creating a class that impements ItemListener to handle the JComboBox selection
    ComboBoxHandlerClass obj1 = new ComboBoxHandlerClass();
    sortType.addItemListener(obj1);
    sortSpeed.addItemListener(obj1);
    
  }
  
  
  //class that implements ActionListener to handle button Clicks by overriding teh actionPerformed method
  public class ButtonHandlerClass implements ActionListener
  {
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
      if(event.getSource() == populate)                
      {
        //setting control visibility and populating the animationpanel with random spikes that need to be sorted
        populate.setEnabled(false);
        sortType.setEnabled(true);
        animPanelObj.populatePanel(); 
        desc.setEnabled(false);              
        asc.setEnabled(false);
        sortSpeed.setEnabled(false);
        pause.setEnabled(false);
        stop.setEnabled(false);
        startSort.setEnabled(false);
        sortSpeed.setSelectedIndex(0);
        sortTypeFlag = false;
      }
      
      else if(event.getSource() == startSort)               
      {
        
        //setting the sleep time depending on the speed selection 
        String x = String.valueOf(sortSpeed.getSelectedItem());
        if(x == "Slow")
        {
          SortAnimationPanel.speedVariable = 1000;
        }
        else if(x == "Medium")
        {
          SortAnimationPanel.speedVariable = 500;
        }
        else if(x == "Fast")
        {
          SortAnimationPanel.speedVariable = 50;
        }
        
        desc.setEnabled(false);              
        asc.setEnabled(false);
        sortSpeed.setEnabled(false);
        pause.setEnabled(true);
        stop.setEnabled(true);         
        //getting the sort type and passing it to the method startThread
        inputFromCombo = sortType.getSelectedItem().toString();    
        animPanelObj.startThread(inputFromCombo);             
        populate.setEnabled(true);         
        revalidate();
        repaint();
        sortTypeFlag = true;
        sortType.setSelectedIndex(0);
      }
      //if asc button is clicked, the sortFlag is set to true
      else if(event.getSource() == asc)         
      {
        asc.setEnabled(false);
        desc.setEnabled(false);
        sortSpeed.setEnabled(false);
        startSort.setEnabled(true);
        sortFlag = true;
        animPanelObj.sortFlag = true;           
      }
      //if desc is clicked, the sortFlag remains false
      else if(event.getSource() == desc)     
      {
        asc.setEnabled(false);
        desc.setEnabled(false);              
        sortSpeed.setEnabled(false);
        startSort.setEnabled(true);
        animPanelObj.sortFlag = false;
      }
      //flag is checked and animation is paused
      else if(event.getSource() == pause)                
      {
        
        animPanelObj.pauseFlags();               
        pause.setEnabled(false);                 
        resume.setEnabled(true);
        animPanelObj.flag1 = true;
        
      }
      
      //condition is checked and animation is resumed
      else if(event.getSource() == resume)         
      {
        resume.setEnabled(false);
        pause.setEnabled(true);
        animPanelObj.resumeThread();           
      }
      //Empties the animation pane and sets the controls to initial state
      else if(event.getSource() == stop)         
      {
        animPanelObj.randomArray = null;           
        revalidate();
        repaint();
        resume.setEnabled(false);
        pause.setEnabled(false);
        startSort.setEnabled(false);
        sortType.setEnabled(false);
        pause.setEnabled(false);
        populate.setEnabled(true);
        stop.setEnabled(false);
      }       
      
    }
    
    
  }
  
  //class implements ItemListener and overrides logic for itemStateChanged
  public class ComboBoxHandlerClass implements ItemListener
  {
    //enables and disables certain controls on selection of sortType based on sort click or populate click
    public void itemStateChanged(ItemEvent event)
    {
      if(event.getSource() == sortType)                
      { 
        if(sortTypeFlag == true)
        {
        sortType.setEnabled(false);      
        desc.setEnabled(false);
        asc.setEnabled(false);
        sortSpeed.setEnabled(false);
        }
        else
        {
        sortType.setEnabled(false);      
        desc.setEnabled(true);
        asc.setEnabled(true);
        sortSpeed.setEnabled(true);
        }
      }
      
    }
  }
}




