/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Lakshmi Swetha Madarasu                     *  
 *                                                          *
 *  Date Due:   11/30/2018                                  *                          
 *                                                          *
 *  Purpose:    Building a GUI for  Assignment 4            *
 *              Travel agents present travel options to     *
 *              clients                                     * 
 ***********************************************************/ 
public class Destination {
  //declaring required variables
  String destinationCity;
  int normalMiles;
  int frequentFlyerMiles;
  int additionalMileage;
  int startMonth;
  int endMonth;
  
  //Initialising values for destination object using constructor.
  public Destination(String destinationCity,int normalMiles, int frequentFlyerMiles,int additionalMileage, int startMonth,int endMonth)
  {
    this.destinationCity = destinationCity;
    this.normalMiles = normalMiles;
    this.frequentFlyerMiles = frequentFlyerMiles;
    this.additionalMileage = additionalMileage;
    this.startMonth = startMonth;
    this.endMonth = endMonth;
    
  }
  //getters for the variables
  public String destinationCity()
  {
    return this.destinationCity;
  }
  
  public int normalMiles()
  {
    return this.normalMiles;
  }
  
  public int frequentFlyerMiles()
  {
    return this.frequentFlyerMiles;
  }
  
  public int additionalMileage()
  {
    return this.additionalMileage;
  }
  
  public int startMonth()
  {
    return this.startMonth;
  }
  public int endMonth()
  {
    return this.endMonth;
  }
}
