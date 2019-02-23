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
public class USMoney {
  
  
  //private integer instance variables
  int dollars;
  int cents;
  int convertedDollars;
  int convertedCents;
  int addCentsDollars;
  //properties
  //setters for dollars and cents 
  public void setDollars(int dol)
  {
    dollars = dol;
  }
  
  public void setCents(int cen)
  {
    cents = cen;
  }
  //getters for dollars and cents
  public int getDollars()
  {
    return dollars;
  }
  
  public int getCents()
  {
    return cents;
  }
  
  public USMoney(int dol, int cen){
    
    if(cen < 0)//condition for when cents is a -ve value
    {
      addCentsDollars = (dol*100) + cen; //dollars converted to cents and the -ve cents value subtracted from the dollar value.
      convertedDollars = (addCentsDollars/100); //the remaining amount's dollar value calculated
      convertedCents = (addCentsDollars%100);//the remaining amount's cent value calculated
      dollars = convertedDollars;//dollars initialised to the dollar value
      cents = convertedCents;//cents initialised to the cent value
      
    }
    else if(cen > 99)//condition for when cents is a positive value
    {
      convertedDollars = cen/100;//calculating dollars from the cents
      convertedCents = cen%100;//calculating cents 
      dollars = dol + convertedDollars;//adding the calculated dollard to the dollar value and initialising the dollar variable
      cents = convertedCents;//initialising the cents value after calculating the no of cents.
    }
    else//just initialising the value directly if cents between between 0 and 99
    {
      dollars = dol;
      cents = cen;
    }
    
  }
  
  //returning a newly created USMoney object with the sum of dollars and cents.
  public USMoney Plus(USMoney obj)
  {
    return new USMoney(this.getDollars() + obj.getDollars(), this.getCents() + obj.getCents());
  }
  
  //the display method used by the newly created object to print the sum. 
  public void display()
  {
    System.out.println("The sum is " +getDollars()+ " dollars and  "+getCents()+ " cents"); 
  }
  
}
