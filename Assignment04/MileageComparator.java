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
import java.util.Comparator;
public class MileageComparator implements Comparator<Destination> 
{
   //rewriting logic for the compare method so the destination objects are sorted in descending order of normal mileage
   public int compare(Destination d1, Destination d2) 
   {
      return (d2.normalMiles() - d1.normalMiles());
   }
}
