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
import java.util.Random;



public class SortAnimationPanel extends JPanel implements Runnable{
  
  //decaring instance variables
  public int randomArray[];
  private Thread thread;
  private String comboBoxInput;
  private final Object pauseObj = new Object();
  public volatile boolean flag1 = false;
  public volatile boolean flag2 = false;
  public boolean sortFlag = true;
  
  //declaring class variable 
  public static int speedVariable = 100;
  
  
  public SortAnimationPanel() { 
    
    //calling super class constructor and setting the panel dimensions and visibility
    super();                                                        
    super.setPreferredSize(new Dimension(400,400));
    super.setBackground(Color.WHITE);
    super.setVisible(true);
    
    
  }
  
  //overriding the paintComponent method painting the random array lines with the below properties and conditions
  @Override
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g);                               
    g.setColor(Color.WHITE);
    g.clearRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    g.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    
    this.repaint();   
    if(randomArray==null) 
      return;                              
    for(int i = 0;i <this.getWidth();i++)                 
    {
      g.setColor(Color.BLUE);
      g.drawLine(i,randomArray[i],i,this.getHeight() );
    }
  }
  
  
  
  //populating the panel with initial array that needs to be sorted and calling the paint method.
  public void populatePanel()
  {  
    Random obj = new Random();                                   
    randomArray = new int[this.getWidth()];                           
    obj.setSeed(System.currentTimeMillis());
    for(int i = 0; i < this.getWidth();i++)                       
    {
      randomArray[i] = obj.nextInt(this.getHeight() -1) + 1;
    }
    this.repaint();                                               
  }
  
  //creating a new thread and calling setState that sets the state after the sort is completed
  public void startThread(String input)
  {
    thread = new Thread(this);                                   
    thread.start();                                              
    this.comboBoxInput = input;
    this.setState();                                       
  }
  
  //sets the state after the sort is completed
  public void setState()
  {
    synchronized(pauseObj)
    {
      try
      {
        while(flag1)
        {
          pauseObj.wait();     
        }
        if(flag2)             
          pauseObj.wait();     
      } 
      catch(InterruptedException e)
      {
        System.out.println("Exception : " + e);
      }
    }
    
  }
  
  //pauses the thread by setting flag1 to true.
  public void pauseFlags()
  {
    flag1 = true;
  }
  
  //signals thread to resume execution
  public void resumeThread()
  {
    synchronized(pauseObj)
    {
      try
      {
        flag1 = false;
        pauseObj.notifyAll();                 
      }
      catch(Exception e)
      {
        System.out.println("Exception : " + e);
      }
    }
    
  }
  
  //checking for the correct sorting algorithm and thread to be execute
  public void run()
  { 
    
    if(comboBoxInput.equals("Bubble Sort"))
    {
      this.bubbleSort(randomArray);
    }
    
    if(comboBoxInput.equals("Selection Sort"))
    {
      this.selectionSort(randomArray);
    }
    
    if(comboBoxInput.equals("Insertion Sort"))
    {
      this.insertionSort(randomArray);
    }
    
    
    
  }
  
  
  //bubble sort 
  public void bubbleSort(int [] intArray)
  {
    int len = intArray.length;
    int temp = 0;
    try
    {
      for(int i=0; i < len; i++)
      {
        //time it makes teh thread sleep 
        thread.sleep(speedVariable);                              
        this.setState();
        
        for(int j=1; j < (len-i); j++)
        { //checks for ascending order
          if(sortFlag)                            
          {
            
            if(intArray[j-1] < intArray[j])         
            {
              temp = intArray[j-1];                                      
              intArray[j-1] = intArray[j];
              intArray[j] = temp;
              repaint();
              
            }
            
          }//checks for descending order
          else if(intArray[j-1] > intArray[j])
          {
            
            temp = intArray[j-1];
            intArray[j-1] = intArray[j];
            intArray[j] = temp;
            repaint();
            
            
          }
          
        }
      }
    }
    catch(Exception e)
    {
      System.out.println("Exception : " + e);
    }
  }
  
  //selection sort
  public int[] selectionSort(int[] ssArray)
  {
    try
    {
      for (int i = 0; i < ssArray.length - 1; i++)                    
      {
        int indx = i;
        for (int j = i + 1; j < ssArray.length; j++)
          if(sortFlag)                                         
        {//ascending
          if (ssArray[j] > ssArray[indx])                                
            indx = j;
        }
        else
        {//descending
          
          if (ssArray[j] < ssArray[indx])
            indx = j;
        }
        
        
        int smallNum = ssArray[indx]; 
        ssArray[indx] = ssArray[i];
        ssArray[i] = smallNum; 
        //setting thread sleep parameter
        thread.sleep(speedVariable);
        repaint();
        this.setState();
      }
    }
    catch(Exception e)
    {
      System.out.println("Exception : " + e);
    }
    return ssArray;
  }
  
 
  //insetion sort
  public void insertionSort(int[] iSort) 
  {
    int i, j;
    int val;
    try
    { 
      
      for (i = 1; i < iSort.length; i++) 
      {
        //setting thread sleep
        thread.sleep(speedVariable);
        val = iSort[i];
        j = i;
        if(sortFlag)                                    
        {
          //condition for ascending order
          while (j > 0 && iSort[j - 1] < val) 
          {
            //swapping elements and painting 
            iSort[j] = iSort[j - 1];
            repaint();                                   
            this.setState();
            j--;
          }
        }
        else                                             
        {
          //condition for descending order
          while (j > 0 && iSort[j - 1] > val) 
          {
            iSort[j] = iSort[j - 1];                                 
            repaint();                                      
            this.setState();
            j--;
          }
        }
        iSort[j] = val;
        
      }
    }
    catch(Exception e)
    {
      System.out.println("Exception : " + e); 
    }
    
    
  }
  
  
}

