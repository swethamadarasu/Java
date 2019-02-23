/************************************************************
  *                                                          *
  *  CSCI 470/502          Assignment 5           Fall 2018  *                                             
  *                                                          *
  *  Programmer: Lakshmi Swetha Madarasu                     *  
  *                                                          *
  *  Date Due:   10/15/2018                                  *                          
  *                                                          *
  *  Purpose:    Enhancing Application                       *
  *              Address Book Application                    *
  *                                                          * 
  ***********************************************************/ 
import java.util.Scanner;

public class AddressBookEntryApp1 {
  
  
  public static void main(String[] args) { 
    //printing the welcome message 
    System.out.println("Welcome to the Address Book Application\n");
    
    // calling method to print menu options
    menuOption();
    
    
  }
  public static void menuOption()
  {
    Scanner s = new Scanner(System.in);
    //printing menu options
    System.out.println();
    System.out.println("1 - List Entries");
    System.out.println("2 - Add Entry");
    System.out.println("3 - Exit\n");
    
    //Taking menu input
    System.out.println("Enter Menu Number: ");
    int inputVal = s.nextInt();
    s.nextLine();
    System.out.println();
    if( inputVal == 1 || inputVal == 2 || inputVal == 3)
    {
      //if input is one, lists the entries by calling getEntriesString() method
      if(inputVal == 1)
      {
        String result = AddressBookIO.getEntriesString();
        System.out.println(result);
        menuOption();
        
      }
      //if input is 2, takes the name, email address and phone no to be saved and calls the validation methods in class validator.
      //if data is valid, calls the saveEntry method to save the data
      else if(inputVal == 2)
      {
        int count = 0;
        System.out.print("Enter Name: ");
        String name = s.nextLine();
        System.out.println("Enter email Address: ");
        String address = s.nextLine();
        System.out.println("Enter Phone Number: ");
        String number = s.nextLine();
        
        //calling method to validate name
        int a = Validator.validateName(name);
        //if name is valid, increments the count, else prints error msg
        if(a == 0)
        {
          count ++;
        }
        else
        {
          System.out.println("Name not in proper format");
        }
        
        //calling method to validate email address
        int b = Validator.validateEmail(address);
        //if email address is valid, increments the count, else prints error msg
        if(b == 0)
        {
          count ++;
        }
        else
        {
          System.out.println("Email not in proper format");
        }
        
        //calling method to validate phone no
        int c = Validator.validateNumber(number);
        //if phone no is valid, increments the count, else prints error msg
        if(c == 0)
        {
          count++;
        }
        else
        {
          System.out.println("Phone no not in proper format");
        }
        
        //if all three inputs are valid i.e. if the count = 3, saves the entry 
        if(count == 3)
        {
          AddressBookEntry obj = new AddressBookEntry(name,address,number);
          boolean val = AddressBookIO.saveEntry(obj);
          if(val == true)
          {
            System.out.println("This entry has been saved.");
          }
          menuOption();
        }
        else
        {
          menuOption();
        }
        
        
        
      }
      //if input value is 3, exits the application
      else if(inputVal == 3)
      {
        System.out.println("Goodbye.");
        s.close();
      }
    }
    else
    {
      System.out.println("Entered Invalid Menu option\n");
      menuOption();
      
      
    }
    
    
    
  }
}
