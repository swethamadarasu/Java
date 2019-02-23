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
public class Invoice {
  
  String partNumber;
  String partDescription;
  int quantity;
  double price;
  
  //initialising values
  public Invoice(String pn, String desc , int qty, double pe )
  { 
    
    this.partNumber = pn;
    this.partDescription = desc;
    this.quantity = qty;
    this.price = pe;
    
  }
  
  //setting properties
  public String getpartNumber()
  {
    return partNumber;
  }
  
  public void setpartNumber(String partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public String getpartDescription()
  {
    return partDescription;
  }
  
  public void setpartDescription(String partDescription)
  {
    this.partDescription = partDescription;
  }
  
  public int getquantity()
  {
    return quantity;
  }
  
  public void setquantity(int quantity)
  {
    if(quantity < 0)
    {
      this.quantity = 0;
    }
    else
    {
      this.quantity = quantity;
    }
  }
  
  public double getprice()
  {
    return price;
  }
  
  public void setprice(double price)
  { 
    if(price < 0.0)
    {
      this.price = 0.0;
    }
    else
    {
      this.price = price;
    }
  }
  
  //method to calculate invoice amount.
  double getInvoiceAmount()
  {
    if(getprice() < 0.0)
    {
      setprice(0.0);
    }
    
    if(getquantity() < 0)
    {
      setquantity(0);
    }
    return quantity * price;
  }
  
 
}
