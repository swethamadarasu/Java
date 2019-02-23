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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MileRedeemer {
  

  
   //declared static ArrayList and array to hold all the destination objects throughout the code.
   public static ArrayList<Destination> destinationList = new ArrayList<Destination>();
   public static Destination[] destinationArray;
   
   //remaining miles to remain of commom value throughout the program
  public static int remainingMiles;
  
  //to create the destination objects from the input file and sort them in descending order of normal mileage
  public void readDestinations(Scanner fileScanner)
  {
    String str;
        
    while(fileScanner.hasNext())
    { 
      //splitting the text file line into individual values
      str = fileScanner.nextLine();
      String[] arrOfStr = str.split(";");
      String[] arrOfStr1 = arrOfStr[4].split("-");
      //creating destination objects with the seperated values that will be used for initialisation in the constructor.
      Destination obj = new Destination(arrOfStr[0],Integer.parseInt(arrOfStr[1]),Integer.parseInt(arrOfStr[2]),Integer.parseInt(arrOfStr[3]),Integer.parseInt(arrOfStr1[0]),Integer.parseInt(arrOfStr1[1])); 
      //adding objects to destinationList 
      destinationList.add(obj);
    }
    //converting list to an array
    destinationArray = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);
    
    //sorting the static array
    Arrays.sort(destinationArray, new MileageComparator());
    
    
  }
  
  public String[] getCityNames()
  {
    //arraylist and array to hold cities from destinationArray
    ArrayList<String> cities = new ArrayList<String>();
    String[] cityArray;
    
    //adding the cities
    for(int i= 0; i< destinationArray.length; i++)
    {
      cities.add(destinationArray[i].destinationCity);
    }
    //converting list to an array
    cityArray = (String[]) cities.toArray(new String[cities.size()]);
    
    //sorting an array
    Arrays.sort(cityArray);
    
    //returning the sorted array
    return cityArray; 
   }
  
  public String[] redeemMiles(int miles, int month)
  {
    
    ArrayList<String> cityNames = new ArrayList<String>();
    ArrayList<String> firstClassCityNames = new ArrayList<String>();
    String[] cityArray1;
    String[] firstClassCityNamesArray;
    ArrayList<String> lastSet = new ArrayList<String>();
    String[] lastSetArray;
    
     //looping through the destination array of destination objects
     for(int i = 0; i< destinationArray.length;i++)
     {
       //cheking for matching month
       if(destinationArray[i].startMonth == month || destinationArray[i].endMonth == month)
       {
         //checking if the input miles are less than frequentflyer miles
         if(destinationArray[i].frequentFlyerMiles < miles)
         {
           //subtracting miles from the frequent flyer miles and adding the respective cities to the list
           miles = miles - destinationArray[i].frequentFlyerMiles;
           cityNames.add(destinationArray[i].destinationCity);
         }
         
       }
       else
       {
         //if month isn't matching, checks if the miles is less than the normal mileage
        if(destinationArray[i].normalMiles < miles)
        {
          //if it is, deducts the normal miles from the input miles and adds the respective cities to the list
          miles = miles - destinationArray[i].normalMiles;
          cityNames.add(destinationArray[i].destinationCity);
        }
       }
       //sets the remaining miles to the miles left 
       remainingMiles = miles;
     }
     
     //converting list city names to the array.
     cityArray1 = (String[]) cityNames.toArray(new String[cityNames.size()]);
     
     for(int i = 0; i< destinationArray.length;i++)
     {
       for(int j = 0; j<cityArray1.length; j++)
       {
         //checking for the shortlisted list in the object list
         if(cityArray1[j] == destinationArray[i].destinationCity)
         {
           //checking if the remaining miles is greater than the additional mileage.If true, deducts the remaining miles and adds to a new list 
           //eligible for first class
           if(destinationArray[i].additionalMileage < remainingMiles)
           {
             remainingMiles -= destinationArray[i].additionalMileage;
             firstClassCityNames.add(destinationArray[i].destinationCity);
             
           }
         }
       }
      }
     //converts the list to an array
     firstClassCityNamesArray = (String[]) firstClassCityNames.toArray(new String[firstClassCityNames.size()]);
     
     
     //compares the Economy list to the First class list and adds to the lastSet list with the respective economy and first class message.
     for(int h = 0; h < cityArray1.length; h++)
     {
       if(firstClassCityNamesArray.length == 0)
       {
         lastSet.add(" * A trip to " + cityArray1[h] + " in Economy Class");
       }
       else
       {
       for(int g = 0; g < firstClassCityNamesArray.length; g++)
       {
         
         if(cityArray1[h] == firstClassCityNamesArray[g])
         {
           lastSet.add(" * A trip to " + cityArray1[h] + " in First Class");
          
           
         }
         else
         {
           lastSet.add(" * A trip to " + cityArray1[h] + " in Economy Class");
           
         }
       }
       }
     }
     //converts the list to an array
     lastSetArray = (String[])lastSet.toArray(new String[lastSet.size()]);
     //returns the array
     return lastSetArray;
  }
  
  //returns the remaining miles
  public int getRemainingMiles()
  {
   return remainingMiles; 
  }
  
  public Destination getMileDetails(String selectedCity) {

  Destination destination = null;

  // Storing the destination city to the destinationObjects array
  for (Destination destn : destinationList)
   if (selectedCity.equals(destn.destinationCity()))
    destination = destn;

  return destination;
 }
  
  //reurn the month in the string format. the received argument is in teh integer format
  public String getMonths(int month) {
 
  // Switch case to do the same
  String monthString;
  switch (month) {
  case 1:
   monthString = "January";
   break;
  case 2:
   monthString = "February";
   break;
  case 3:
   monthString = "March";
   break;
  case 4:
   monthString = "April";
   break;
  case 5:
   monthString = "May";
   break;
  case 6:
   monthString = "June";
   break;
  case 7:
   monthString = "July";
   break;
  case 8:
   monthString = "August";
   break;
  case 9:
   monthString = "September";
   break;
  case 10:
   monthString = "October";
   break;
  case 11:
   monthString = "November";
   break;
  case 12:
   monthString = "December";
   break;
  default:
   monthString = "Invalid month";
   break;
  }

  return monthString;
 }
  //Fetches the month lIst that is used to populate the spinner
  public String[] getMonList() {

  String[] mons = new java.text.DateFormatSymbols().getMonths();
  
  int lIndex = mons.length - 1;
  
  if (mons[lIndex] == null || mons[lIndex].length() <= 0)  
  { 
    String[] monthlist = new String[lIndex];
    System.arraycopy(mons, 0, monthlist, 0, lIndex);
    return monthlist;
  }
  else 
  { 
    return mons;
  }

 }
  
  //this is used to return the month number when the month is passed in the string format. Used to convert to fetch details when user selects from the spinner.
  public int getMonValue(String month) {
  Date date = null;
  try {
   date = new SimpleDateFormat("MMM", Locale.ENGLISH)
     .parse(month);
  } catch (ParseException e) {
   System.out.println(e.getMessage());
  }

  Calendar obj = Calendar.getInstance();
  obj.setTime(date);
  int month1 = obj.get(Calendar.MONTH) + 1;

  return month1;
 }
}

