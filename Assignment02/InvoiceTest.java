/************************************************************
  *                                                          *
  *  CSCI 470/502          Assignment 2           Fall 2018  *                                             
  *                                                          *
  *  Programmer: Lakshmi Swetha Madarasu                     *  
  *                                                          *
  *  Date Due:   09/14/2018                                  *                          
  *                                                          *
  *  Purpose:    understanding classes, objects, methods and *
  *              strings.(3.12)                              *
  *                                                          * 
  ***********************************************************/ 

public class InvoiceTest {
  
  
  
  public static void main(String[] args) { 
    
    Invoice object = new Invoice("123","bolt",-4,4.5);//creating objects of class invoice and sending values to the constructor
    Invoice object1 = new Invoice("132","axe", 4,4.5);
    
   
    double val = object.getInvoiceAmount();//calling method to calculate invoice amount
    double val2 = object1.getInvoiceAmount();
    System.out.println(val + " : first result");//printing the invoice amount
    System.out.println(val2 + " : second result");
    
    
  }
  
  
  
  
}
