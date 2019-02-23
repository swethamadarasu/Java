/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 4           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Lakshmi Swetha Madarasu                     *  
 *                                                          *
 *  Date Due:   10/05/2018                                  *                          
 *                                                          *
 *  Purpose:    Java Console Program                        *
 *              Travel agents present travel options to     *
 *              clients                                     * 
 ***********************************************************/ 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 
public class MileRedemptionApp {
  
  
  
  public static void main(String[] args)throws FileNotFoundException  { 
    
    Scanner inFile = new Scanner(System.in);
    System.out.println("Enter the name of the text file");
    //reading the file
    File file = new File(inFile.nextLine()); 
    Scanner sc = new Scanner(file); 
    
    MileRedeemer obj = new MileRedeemer();
    //calls method to read destinations from file in MileRedeemer class
    obj.readDestinations(sc);
    // string variable to hold City names
    String[] a = obj.getCityNames();
    System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
    System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("-----------------------------------------------------------------------------------------------------------------\n");
    System.out.println("List of destination cities your client can travel to:\n");
    //prints the city names
    for(int i = 0; i< a.length;i++)
    {
      System.out.println(a[i]);
    }
    //calls a method to print the cities teh user is eligible for and the remaining frequent flyer miles
    outputMethod();
     
    
    inFile.close();
    sc.close();
    
  }
  public static void outputMethod()
  {
    MileRedeemer obj = new MileRedeemer();
    Scanner in = new Scanner(System.in);
     System.out.println("\n-----------------------------------------------------------------------------------------------------------------\n");
    System.out.println("Please enter your client's accumulated Frequent Flyer Miles:");
    int miles = in.nextInt();
    System.out.println("Please enter your client's month of departure (1-12):");
    int month = in.nextInt();
    //calls the redeemMiles method in MileRedeemer
    String[] result = obj.redeemMiles(miles,month);
    //if there is a result, prints the cities
    if(result.length != 0)
    {
      System.out.println("Your client's Frequent Flyer Miles can be used to redeem the following tickets:\n");
    for(int i = 0 ; i< result.length; i++)
    {
      System.out.println(result[i]);
    }
    
    int s = obj.getRemainingMiles();
    System.out.println("\nYour client's remaining Frequent Flyer Miles: " +s);
     System.out.println("\n-----------------------------------------------------------------------------------------------------------------\n");
  }
    else 
    {
     //if there isn't a result, prints that the frequent flyer miles aren't enough
      System.out.println("*** Your client has not accumulated enough Frequent Flyer Miles ***");
       int s = obj.getRemainingMiles();
      System.out.println("\nYour client's remaining Frequent Flyer Miles: " +s);
      System.out.println("\n-----------------------------------------------------------------------------------------------------------------\n");
    }
    
    //message to continue or discontinue 
    System.out.println("Do you want to continue (y/n)?");
    
    char c = in.next().charAt(0);
    if(c == 'y')
    {
      outputMethod();
    }
    else if(c == 'n')
    {
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("-------------------------------------------------------------------------");
    }
   

    in.close();
    }
  
  }
 
  

  

