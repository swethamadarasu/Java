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


//Imported all the required files
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Test extends JFrame{
  
  
  private static String[] City = null;
  
  //declaring all textFields
  JTextField textBox1, textBox2, textBox3, textBox4, milesLeft = new JTextField("", 10);
  
  //creating an object of type Destination
  Destination destination = null;
  
  //to concatenate the result strings to be displayed to customer
  private static String displayTicket = "";
  
  //labels to be displayed to the user depending on result i.e. if a result set is present
  final JLabel displayText = new JLabel("\nYour Frequent Flyer Miles can be used for the following Tickets:");
  
  //to display the clients remaining miles
  final JLabel milesLeftLabel = new JLabel("Remaining Miles");
  JTextArea resultArea = new JTextArea(100,50);
  
  //creating a static object i.e a common object for every destination selected 
  private static MileRedeemer mileObj = new MileRedeemer();
  Test()
  {
    
    //creating a left and right panel
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    this.add(leftPanel);
    this.add(rightPanel);
    
    //setting colors for the panel
    final Color VERY_DARK_GREEN = new Color(0,153,76);
    final Color VERY_LIGHT_PURPLE = new Color(113,103,127);
    
    // Setting the background of the panels to the respective colors
    leftPanel.setBackground(VERY_DARK_GREEN);
    rightPanel.setBackground(VERY_LIGHT_PURPLE);
    
    //seperating the left pane into 2 parts using gridlayout
    leftPanel.setLayout(new GridLayout(2, 0, 20, 20));
    rightPanel.setLayout(new GridLayout(1, 0, 40, 0));
    
    //creating titles for the left and right panel
    leftPanel.setBorder(BorderFactory.createTitledBorder("Destinations"));
    rightPanel.setBorder(BorderFactory.createTitledBorder("Redeem Miles"));
    
    //setting the layout and color of the left top panel and adding it to the left panel
    final JPanel leftTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    leftPanel.add(leftTopPanel);
    leftTopPanel.setBackground(VERY_DARK_GREEN);
    
    //setting the layout and color of the left bottom panel and adding it to the left panel
    final JPanel leftBottomPanel = new JPanel(new GridLayout(0, 2));
    leftPanel.add(leftBottomPanel);
    leftBottomPanel.setBackground(VERY_DARK_GREEN);
    
    //setting the layout and color of the only panel on right and adding it to the right panel
    final JPanel rightOnlyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    rightPanel.add(rightOnlyPanel);
    rightOnlyPanel.setBackground(VERY_LIGHT_PURPLE);
    
       
    
    // adding a list box to hold the cities
    final JList cityContainer = new JList(City);
    cityContainer.setFixedCellWidth(330);
    leftTopPanel.add(cityContainer);
    
    // creating a panel to hold labels and to hold text fields
    JPanel labelHolder = new JPanel(new FlowLayout(FlowLayout.LEFT));
    leftBottomPanel.add(labelHolder);
    labelHolder.setBackground(VERY_DARK_GREEN);
    
    JPanel textBoxHolder = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    leftBottomPanel.add(textBoxHolder);
    textBoxHolder.setBackground(VERY_DARK_GREEN);
    
    
    
    // creating the labels and textfileds and setting them to read only
    JLabel label1 = new JLabel("Normal Miles");
    textBox1 = new JTextField("", 14);
    textBox1.setEditable(false); 
    JLabel label2 = new JLabel("Supersaver miles");
    textBox2 = new JTextField("", 14);
    textBox2.setEditable(false);
    JLabel label3 = new JLabel("upgrade cost");
    textBox3 = new JTextField("", 14);
    textBox3.setEditable(false);
    JLabel label4 = new JLabel("Supersaver Dates");
    textBox4 = new JTextField("", 14);
    textBox4.setEditable(false);
    
    
    // Adding  the above labels and textfields to the labels and textfield panels
    labelHolder.add(label1);
    textBoxHolder.add(textBox1);
    labelHolder.add(label2);
    textBoxHolder.add(textBox2);
    labelHolder.add(label3);
    textBoxHolder.add(textBox3);
    labelHolder.add(label4);
    textBoxHolder.add(textBox4);
    
    //handling event when an item is selected in the listBox
    cityContainer.addListSelectionListener(new ListSelectionListener() {
      
      public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting())
          return;
        
        // fetching all details based on the city and saving it in destination
        destination = mileObj.getMileDetails(cityContainer.getSelectedValue().toString());
        
        // setting the values depending on the destination object that is the city
        textBox1.setText(String.valueOf(destination.normalMiles()));
        textBox2.setText(String.valueOf(destination.frequentFlyerMiles()));
        textBox3.setText(String.valueOf(destination.additionalMileage()));
        textBox4.setText(mileObj.getMonths(destination.startMonth())+ " - " + mileObj.getMonths(destination.endMonth()));
      }
    });
    
    //Fetching the month list to populate the spinner object
    String[] monthList = mileObj.getMonList();
    //label and textfield for client to enter frequent flyer miles
    JLabel freFlyMiles = new JLabel("Enter number of Miles         ");
    final JTextField freFlyMilesText = new JTextField("", 14);
    
    //spinner to display the monthList
    JLabel travelMonth = new JLabel("select month of departure  ");
    SpinnerListModel monSpinner = new SpinnerListModel(monthList);
    final JSpinner spinner = new JSpinner(monSpinner);
    spinner.setPreferredSize(new Dimension(130, 20));
    
    //Button to display result
    JButton button = new JButton("                                    Redeem Miles                                          ");
    
    
    //Adding all the above components to the right panel
    rightOnlyPanel.add(freFlyMiles);
    rightOnlyPanel.add(freFlyMilesText);
    rightOnlyPanel.add(travelMonth);
    rightOnlyPanel.add(spinner);
    rightOnlyPanel.add(button);  
    displayText.setVisible(false);
    resultArea.setVisible(true);
    rightOnlyPanel.add(milesLeftLabel);
    rightOnlyPanel.add(milesLeft);
    rightOnlyPanel.add(displayText);
    rightOnlyPanel.add(resultArea);
    
    //Event handler for button Click
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        
        
        displayTicket = "";
        //getting month from spinner i.e. user input
        int month = mileObj.getMonValue((String)spinner.getValue());
        //and user input for accumulated frequent flyer miles
        String milesValue1 = freFlyMilesText.getText();
        
        //Flag to check if input frequent flyer miles are all digits
        boolean flag = milesValue1.matches("[0-9]*");
        
        
        //if the input is all numbers, then it fetches the result
        if (flag) {
          Integer milesValue = Integer.valueOf(milesValue1);
          
          //Fetching teh cities to which tickets can be purchased 
          String[] result = mileObj.redeemMiles(milesValue,month);
          //if there is a result, prints the cities for which frequent flyer Miles can be used
          if(result.length != 0)
          {
            displayText.setVisible(true);
            for(String displayTicket1 : result)
              
              displayTicket = displayTicket.concat(displayTicket1+ "\n");
            resultArea.setText(displayTicket);
            milesLeftLabel.setVisible(true);
            milesLeft.setText("" + mileObj.getRemainingMiles());
            milesLeft.setEditable(false);
            milesLeft.setVisible(true);
            
          }
          else
          {
            //if not, displays a message saying you need to accumulate more Frequent Flyer Miles
            displayText.setVisible(false);
            resultArea.setText("*Your client has not accumulated enough Frequent Flyer Miles*");
            milesLeftLabel.setVisible(true);
            milesLeft.setText("" + mileObj.getRemainingMiles());
            milesLeft.setEditable(false);
            milesLeft.setVisible(true);
            
          }
          
          
          
          
          
        }}});
    
    
  }
  
  //method to get file name. If nothing is entered, prompts for filename again. 
  public static String getFileName()
  {
    String input = JOptionPane.showInputDialog("Please enter file name in example.txt format : ");
      if(input.length() > 0)
      {
        return input;
      }
      else
      {
        getFileName();
      }
      return input;
  }
  public static void main(String[] args) throws FileNotFoundException { 
    
    
   //calling method that gets file input from user   
   String input =  getFileName();



    //Taking an input file
    File file = new File(input); 
    Scanner sc = new Scanner(file);
    
    //reading the file contents
    mileObj.readDestinations(sc);
    
    //Fetching teh cities
    City = mileObj.getCityNames();
    
    //Creating a test object and its Constructor is activated
    Test obj = new Test();
    
    //setting the frame details
    obj.setVisible(true);
    obj.setSize(750,530);
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    obj.setLayout(new GridLayout(0, 2));
    obj.setBackground(Color.red);
    obj.setResizable(false);
    
    
    
  }
  
  
}
