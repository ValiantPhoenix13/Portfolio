/*
name: Andrew Lawson
date: 2 October 2022

descrition: The following applies parent classes, child classes, and implementations in order to replicate the data of an Airline and its passengers 

self-grade: My grade is 80 sense I have proper naming throughout, comments and block comments for each method, proper indentation,
the program compiles and runs, finally I did not complete the "YourDriver" section and contains this self grading portion
Testimony: I have written this program all by myself and have not copied any code 
from any resources: Andrew Lawson
*/



import java.util.*;
public class AirplaneLawson
{
  //no code goes here
}
class Person{
	 private String first;
    private String last;
    private String phone;
    public Person(String first, String last, String phone){
         this.first = first;
         this.last = last;
         this.phone = phone;
    }
    
    //Setter methods
    public void setFirst(String first){
         this.first = first;
    }
    public void setLast(String last){
         this.last = last;
    }
    public void setPhone(String phone){
         this.phone = phone;
    }
    
    //Getter methods
    public String getFirst(){
         return first;
    }
    public String getLast(){
         return last;
    }
    public String getPhone(){
         return phone;
    }
    
    //To String method
    public String toString(){
         String information = first + " " + last + "\n " + phone + "\n";
         return information;
    }
    
    //Compare the first and last name
    public boolean equals(Object o){
         if (o instanceof Person){
            Person p = (Person) o;
            return this.first == p.first && this.last == p.last;
         }
            return false;  
    }
    
    
    
}

class Passenger extends Person{
	private int seatNumber;
   private String classType;
   private String ticketID;
   public Passenger(String first, String last, String ticketID, int seatNumber, String classType, String phone){
      super(first, last, phone);
      this.ticketID = ticketID;
      this.seatNumber = seatNumber;
      this.classType = classType;
   }
   
   //Setter methods
   public void setClass(String classType){
      this.classType = classType;
   }
   public void setTicketID(String ticketID){
      this.ticketID = ticketID;
   }
   public void chnageSeatNumber(int seatNumber){
      this.seatNumber = seatNumber;
   }
   
   //Getter methods
   public String getClassType(){
      return classType;
   }
   public int getSeat(){
      return seatNumber;
   }
   public String getTicketID(){
      return ticketID;
   }
   
   //To String method
   public String toString(){
      String information = super.toString() + classType + ": " + seatNumber + "\n";
      return information;
   }
}

interface list {   
   public boolean add(Object o);
   public Object search(Object o);
   public boolean delete(Object o);
   public void printLast();
   public void takeOff();
}

class Airplane implements list{
    //declare the instance variable
    public static int count = 0;
    private Passenger[] plane;
    private boolean takeOff;
    private int planeNum;
      
   //implement the constructor
   public Airplane(int planeNum){
      this.planeNum = planeNum;
      this.takeOff = false;
      this.plane = new Passenger[10];
   }
   
   //Getter methods
   public int getPlaneNumber(){
      return planeNum;
   }
   public static int getCount(){
      return count;
   }
   
   //Setter methods
   public void setPlaneNumber(int planeNum){
      this.planeNum = planeNum;
   }
   
   //To string method
   public String toString(){
      String information="";
      for(int i = 0; i<plane.length; i++){
         if(plane[i]!=null){
            information = information + plane[i].toString();
         }
      }
      return information;
   }
   
   
   public boolean add(Object o) {
   	//complete this method
      if((o instanceof Passenger) == true && takeOff == false){
         Passenger n = (Passenger) o;
         if (takeOff == false){
            plane[count]=n;
            count++;
            return true;
         }
      }
      return false;
   }

   public Object search(Object o) {
   	//complete this method
      if(o instanceof String == true){
         String name = (String) o;
         for(int i = 0; i < plane.length; i++){
            if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name)){
               return plane[i];
            }
         }
      } 
      return null;
   }

   public boolean delete(Object o) {
   	//complete this method
      if((o instanceof String) == true){
         String name = (String) o;
         for(int i = 0; i < plane.length; i++){
            if(plane[i]!= null && plane[i].getLast().equalsIgnoreCase(name)){
               plane[i] = null;
               count--;
               return true;
            }
         }
      } 
      return false;
   }

   public void printLast() {
   	//complete this method
      for(int i = 0; i < plane.length; i++){
         if(plane[i]!=null){
            System.out.println(plane[i].getLast());
         }
      }
   }

   public void takeOff() {
   	//complete this method
      takeOff = true;
   }
	
}
/* Do not delete the given driver , The class Driver must be in your code when you submit it
Once you complete all the classes uncommnet the given driver to test your code.*/
	
class Driver {
   public static void main(String[]args) {
      Scanner in = new Scanner(System.in);
   	
      Scanner kb = new Scanner(System.in);
      Airplane plane = new Airplane(817345);
      Passenger p1 = new Passenger("Bobbys", "Smith", "123456789", 1, "First class", "916-222-3333");
      Passenger p2 = new Passenger("Johnny", "Apples", "987654321", 8, "Business class", "818-000-1234");
      Passenger p3 = new Passenger("Tommy", "Jerrys", "567123489", 32, "Economy class","202-222-3333");
      Passenger p4 = new Passenger("Candy", "Cruze", "982134567", 15, "Premium Economy class","707-444-5555");
      
      //this passenger will be added after take off
      Passenger p5 = new Passenger("Kalotiii", "Aaronn", "762134589", 5, "Economy plus","817-222-6666");
      
      plane.add(p1);
      plane.add(p2);
      plane.add(p3);
      plane.add(p4);
      System.out.println("The palne is about to take off");
      plane.takeOff();
      System.out.println("adding a passenger after take off");
      plane.add(p5);
      String repeat = "";
      while(plane.getCount() > 0) 
      {
      
         System.out.println("Here is the list of the passengers in this plane");
         System.out.println("There are " + plane.getCount() + " Passengers on this plane"); 
         System.out.println(plane + "\n");
      
         System.out.println("Testing the printLast method to display the last names");
         plane.printLast();  
         System.out.println();
         
         System.out.println("Testing the static method getCount");
         System.out.println("This train has " + plane.getCount() + " Passengers\n");
         
         System.out.print("Enter the last name of the passenger to search for: ");
         String lastName = in.nextLine();
         System.out.println(plane.search(lastName));
         System.out.println();
         
         System.out.println("Testing the delete method");
         System.out.print("Enter the last name of the passenger to be deleted: ");
         String last = in.nextLine();
         plane.delete(last);
         System.out.println("Passenger " + last + " has been removed from the list\n");
         
         System.out.println("Here is the updated list");
         System.out.println(plane);
         System.out.println("*********************");
         System.out.print("Press any key to continue : ");
         repeat = kb.nextLine();
      }
      System.out.println("No passenger left on this airplane");
   	
   }
}
/*Complete the following driver to include the required code.*/
/*20 points is allocated for this driver*/
class yourDriver
{

}
 		    