/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 3           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Lakshmi Swetha Madarasu                     *  
 *                                                          *
 *  Date Due:   09/21/2018                                  *                          
 *                                                          *
 *  Purpose:    Understanding Classes, Objects and Methods  *
 *                                                          *
 *                                                          * 
 ***********************************************************/ 
public class USMoneyDemo {
  
  
  public static void main(String[] args) { 
    //objects being created and values of dollars and cents sent for initialisation
    USMoney x = new USMoney(200, -60);
    USMoney y = new USMoney(180, -100);
    USMoney z = new USMoney(170, 90);
    USMoney a = new USMoney(800,120);
    
    USMoney obj =  x.Plus(y);//adding objects x and y and storing it in object obj
    USMoney obj1 = z.Plus(a);//adding objects z and a and storing it in object obj1;
    //using these objects to display their sum by calling display() method.
    obj.display();
    obj1.display();
  }
  
  
  
}
