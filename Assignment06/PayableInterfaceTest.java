/************************************************************
  *                                                          *
  *  CSCI 470/502          Assignment 6           Fall 2018  *                                             
  *                                                          *
  *  Programmer: Lakshmi Swetha Madarasu                     *  
  *                                                          *
  *  Date Due:   10/19/2018                                  *                          
  *                                                          *
  *  Purpose:    Accounts Payable System                     *
  *              Implementing Interfaces and processing      *
  *              Invoices and employees polimorphically      *
  *                                                          * 
  ***********************************************************/  
// Payable interface test program processing Invoices and 
// Employees polymorphically.
public class PayableInterfaceTest 
{
   public static void main(String[] args)
   {
      // create six-element Payable array
      Payable[] payableObjects = new Payable[6];
      
      // populate array with objects that implement Payable
      payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
      payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
      payableObjects[2] = 
         new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
      payableObjects[3] = 
         new HourlyEmployee("Lisa", "Barnes", "888-88-8888", 1200.00, 2.0);
      payableObjects[4] = 
         new CommissionEmployee("joe", "Darne", "888-86-8888", 1300.00, 0.5);
      payableObjects[5] = 
         new BasePlusCommissionEmployee("Joey", "Blah", "888-87-8888",24.0,0.5, 1400.00);

      System.out.println(
         "Invoices and Employees processed polymorphically:"); 

      
      // generically process each element in array payableObjects
      for (Payable currentPayable : payableObjects)
      {         
         System.out.println(currentPayable);
         if (currentPayable instanceof BasePlusCommissionEmployee) 
         {
           
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               (BasePlusCommissionEmployee) currentPayable;
            
            //sets salary to 10% more
            employee.setBaseSalary(1.10 * employee.getBaseSalary());
            
            //prints the increased salary
            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f%n",
               employee.getBaseSalary());
                    } 
         //prints the amount
                System.out.printf(
            "earned $%,.2f%n%n", currentPayable.getPaymentAmount());
    
    } 
       
   } // end main
} // end class PayableInterfaceTest

