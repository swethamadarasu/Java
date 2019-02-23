/************************************************************
  *                                                          *
  *  CSCI 470/502          Assignment 2           Fall 2018  *                                             
  *                                                          *
  *  Programmer: Lakshmi Swetha Madarasu                     *  
  *                                                          *
  *  Date Due:   09/14/2018                                  *                          
  *                                                          *
  *  Purpose:    understanding classes, objects, methods and *
  *              strings.(3.14)                              *
  *                                                          * 
  ***********************************************************/ 
public class Date {
  
int month;
int day;
int year;
Date(int month, int day, int year)//initialising constructor
{
 this.month = month;
 this.day = day;
 this.year = year;
}

//setting up properties
public int getmonth()
  {
    return month;
  }

public int getyear()
  {
    return year;
  }
  
  public void setmonth(int month)
  {
    this.month = month;
  }
  
  public int getday()
  {
    return day;
  }
  
  public void setday(int day)
  {
    this.day = day;
  }
  
  public void setyear(int year)
  {
    this.year = year;
  }
  //method to display date.
  public void displayDate()
  {
    System.out.println("The date is : " +getmonth()+'/' +getday() +'/'+ getyear()); 
  }}