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
public class Validator {
  
  //method to validate name
  static int validateName(String name)
  {
    int count = 0;
    
    
    //checking if input for name is empty
    if(name.length() == 0)
    {
      
      return 1;
    }
    else
    {
      //looping through all the characters of the name string 
      for(int i = 0; i< name.length(); i++)
      {
        //checking if the characters are valid characters that are allowed 
        char c = name.charAt(i);
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ' || c == '.' || c== '-')
        {
          //incrementing count to capture more than two periods in the name
          if(c == '.')
          {
            count ++;
          }
          
        }
        // returning an fault no 3 if the conditions are not met for name
        else
        {
          
          return 3;
        }
      }
    }
    //if the count for the no of periods exceeds 2,returns a fault no 2
    if(count > 2)
    {
      
      return 2;
    }
    
    
    //returns 0 if name is valid
    return 0;
    
    
  }
  
  static int validateEmail(String email)
  {
    //checking if email input is empty
    if(email.length() == 0)
    {
      
      return 1;
    }
    
    //checking for a valid email by matching the string with the regular expression
    String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Boolean b = email.matches(emailregex);
    //returns an error no 1 if it does not match
    if(b == false)
    {
      return 1;
    }
    //if it does, checks if the email id ends only with .com by retrieving the substring
    else
    {
      int s = email.length();
      String a = email.substring(s-4).toLowerCase();
      
      
      
      //comparing the last 4 characters of the email address to check if it ends with .com
      if(a.equals(".com"))
      {
        
        return 0;
      }
      else
      {
        return 1;
      }
    }
    
    
  }
  
  
  static int validateNumber(String num)
  {
    //checking if the phone no input id empty
    if(num.length() == 0)
    {
      
      return 1;
    }
    
    //initialising variables for count and character index
   
    int count = 0;
    int count1 = 0;
    int count3 = 0;
    int count4 = 0;
    int one= 180,two= 180,three= 180,four= 180,five= 180,six = 180;
    int seven = 0;
    
    //checking for the length of three possible phone no inputs
    if(num.length() == 10 || num.length() == 14 || num.length() == 12)
    {
      
      //if the length is 10, checks if the string consists of digits only
      if(num.length() == 10)
      {
        if(num.matches("[0-9]+"))
        {
          return 0;
        }
        else
        {
          return 1;
        }
      }
      
      //if the length is 14
      else if(num.length() == 14)
      {
        //loops through the string
        for(int i = 0; i< num.length(); i++)
        {
          char c = num.charAt(i);
          //checks if the character is a digit or the possible characters
          if((Character.isDigit(c) || c == '(' || c == ')' || c== '-' || c== ' '))
          {
            //if it is a character and not a digit, takes the index value of the respective character
            if(c == '(')
            {
              one = i;
            }
            if(c == ')')
            {
              two = i;
            }
            if(c == ' ')
            {
              three = i;
            }
            if(c == '-')
            {
              four = i;
            }
            //takes the count of all the characters
            count ++;
            if(Character.isDigit(c))
            {
              //takes the count of the digits in the string
              count1++;
            }
            
          }
          
        }
        
        
      }
      
      //checks for length 12
      else if(num.length() == 12)
      {
        //loops through the string
        for(int i = 0; i< num.length(); i++)
        {
          char c = num.charAt(i);
          //checks for digits and possible characters
          if((Character.isDigit(c)) || c == '-')
          {
            //if it is the first hyphen, sets the index of first hyphen
            if(c == '-' && seven == 0)
            {
              five = i;
              //increments count after encountering first hyphen
              seven++;
            }
            
            //sets teh index value after encountering the second hyphen
            if(c == '-' && seven == 1)
            {
              six = i;
            }
            //total charcter count 
            count3 ++;
            //digits in the string count
            if(Character.isDigit(c))
            {
              count4++;
            }
            
          }
        }
      }
    }
    else
    {
      return 1;
      
    }
    //if the count of the digits and total charcters is correct, checks if the characters are placed in the correct index positions
    if(count == 14 && count1 == 10)
    {
      if(one == 0 && two == 4 && three == 5 && four == 9 )
      {
        return 0;
      }
      else
      {
        return 1;
      }
      
    }
    
    //if the count of the digits and total charcters is correct, checks if the characters are placed in the correct index positions
    if(count3 == 12 && count4 == 10)
    {
      if(five == 3 && six == 7 )
      {
        return 0;
      }
      else
      {
        return 1;
      }
    }
    
    //if not valid, returns an error no 6
    return 6;
  }
}
