public class PayrollLawson {
   //no code here
}

/*
    name: Andrew Lawson
    
    Program description: This program will calculate a person's salary.
    Date: 18 September 2022
    Self grade: My grade is 100 sense I have proper naming throughout, comments and block comments for each method, proper indentation,
    the program compiles and runs, finally it matches the expected output with format and contains this self grading portion
    *IMPORTANT* error found on Ali Santos pay; which wont match sample output the salary should be 5,750
    *IMPORTANT* also in the requirements for toString Salary wasn't listed so the salary is being listed after each call of toString and the hours worked for Alex Martinex were changed not the rate
    Testimony: I have written this program all by myself and have not copied any code, aside from what was provided and two references for matching the expected outcome format
    https://stackoverflow.com/questions/2538787/how-to-print-a-float-with-2-decimal-places-in-java : reference of "String.format" to get my hours worked and rate to one decimal place for toSting
    https://www.baeldung.com/java-round-decimal-number : reference of "Math.round()" to get my salary rounded correctly 
    from any resources: Andrew Lawson
  */

class Payroll {
   // Instance Variables
   private String name;
   private String id;
   private double hourlyRate;
   private double hoursWorked;
   
   //Constructor 
   public Payroll(String name, String id, double hoursWorked, double hourlyRate) {
      this.name = name;
      this.id = id;
      this.hourlyRate = hourlyRate;
      this.hoursWorked = hoursWorked;
   }

   // get methods  
   public String getName() {
      return name;
   }

   public String getId() {
      return id;
   }

   public double getHourlyRate() {
      return hourlyRate;
   }

   public double getHoursWorked() {
      return hoursWorked;
   }
   //end of get methods

   // set methods
   public void setName(String name) {
      this.name = name;
   }

   public void setHourlyRate(double rate) {
      hourlyRate = rate;
   }

   public void setHoursWorked(double hours) {
      hoursWorked = hours;
   }
   // end of set methods

   // calculates the amount that the person is getting paid. pay = hourlyRate * hoursWorked
   public double getPay() {
      double pay = 0;
      if (hoursWorked <= 40)
      {
         pay = hourlyRate * hoursWorked;
      } else 
      {
         pay = (hourlyRate * 40) + ((hourlyRate + hourlyRate * .2) * (hoursWorked - 40));
      }
      pay = Math.round(pay * 10.0) / 10.0;
      return pay;
   }
   
   //calculates the amount of money earned from overtime
   public double getOverTime()
   {
      double overtimePay = 0;
      if (hoursWorked > 40)
      {
         overtimePay = (hourlyRate + hourlyRate * .2) * (hoursWorked - 40); 
      }
      overtimePay = Math.round(overtimePay * 10.0) / 10.0;
      return overtimePay;   
   }
   
   //will give the worker a raise based on a positive amount
   public void getRaise(int amount)
   {
      if (amount > 0)
      {
         hourlyRate = hourlyRate + amount;
      }
   }

   // returns a String representing the attributes for the given person.
   public String toString() {
      String worker = "Name: " + name + "\nID: " + id + "\nHours worked: " + String.format("%.1f", hoursWorked) + "\nHourly rate: " + String.format("%.1f", hourlyRate); 
      return worker;
   }





}
//once you implement the Payroll class, uncommnet the code in the main method and run your program. 
class PayrollDriver {
   public static void main(String[] args) {
   
      System.out.println("Cretaing payroll objects");
      Payroll p2 = new Payroll("Ali Santos", "986747", 45, 125);
      System.out.println("testing the toString method");
   
     
      System.out.println("\n*******************");
      System.out.println(p2);
      System.out.println("Salary is : " + p2.getPay());
      System.out.println("Overtimepay is : " + p2.getOverTime()); //calling the getPay method
      p2.getRaise(2); // calling the raise method
      System.out.println("Your salary after getting 2$ raise per hour");
      System.out.println("Salary is : " + p2.getPay()); //calling the getPay method
      System.out.println("Overtimepay is : " + p2.getOverTime()); //calling the getPay method
      
              
      System.out.println("\n*******************");
      System.out.println("\nTesting the setter methods");
      System.out.println("The hourly pay of " + p2.getName() + " is being chnaged");
      p2.setHoursWorked(80); // changing the hours worked for the object p1
      System.out.println(p2);
   
   }}




 //***********************************************************************************

 
 
 /*        Your turn , once you have implemment the class and all the methods, test your program 
      with the given driver.
      then implement your own driver given below
      Make sure to provide code for each comment
       
  */
class yourDriver
{
   public static void main(String[] args)
   {
      //1. create one object of the payroll class 
      Payroll worker1 = new Payroll("Andrew Lawson", "763826", 38.7, 15.25);
      
      //2. display the objects on the screen by calling the toString method
      worker1.toString();
   
      //2. display the salary ofthe person by calling the getPay method
      System.out.println("Salary: " + worker1.getPay());
      
      //3. display the overtime salary
      System.out.println("Overtime salary: " + worker1.getOverTime());
      
      //4. give a raise of 5 dollars to the person
      System.out.println("\nGiving worker 5 dollar raise.");
      worker1.getRaise(5);
      
      //5. display the new salary
      System.out.println("Salary: " + worker1.getPay());
      
      //6. display the overtime salary
      System.out.println("Overtime salary: " + worker1.getOverTime());
       
   
      //7. change the hourlyRate of the objects you created to 34
      System.out.println("\nSetting new hourly rate.");
      worker1.setHourlyRate(34);
      
      //8. display the objects again to see the changes you made by calling the toString method
      System.out.println("\nDisplaying new worker details\n" + worker1.toString() + "\n");
       
   
      //9. change the hoursworked for the objects you created by calling the setter methods
      System.out.println("\nSetting new worked hours.");
      worker1.setHoursWorked(56.2);
      
      //10. display your object again to see the changes you made
      System.out.println("\nDisplaying new worker details\n" + worker1.toString() + "\n");
       
   
      //11.add anyother code you want
      
      //Testing for the sample outputs
      System.out.println("Sample Outputs\n\n");
      
      System.out.println("Creating payroll objects\n");
      Payroll s1 = new Payroll("Alex Martinex", "123456", 20, 25);
      Payroll s2 = new Payroll("Ali Santos", "986747", 45, 125);
      Payroll s3 = new Payroll("Jose Busta", "45678", 30, 55);
      
      System.out.println("testing the toString method\n");
      
      //sample worker 1
      System.out.println(s1.toString() + "\nSalary is: " + s1.getPay() + "\n");
      
      //sample worker 2
      System.out.println("*******************");
      System.out.println(s2.toString() + "\nSalary is: " + s2.getPay() + "\n");
      
      //sample worker 3
      System.out.println("*******************");
      System.out.println(s3.toString() + "\nSalary is: " + s3.getPay() + "\n");
      System.out.println("*******************\n");
      
      System.out.println("Testing the setter methods");
      System.out.println("The hours worked of Alex Martinez is being changed");
      s1.setHoursWorked(80);
      System.out.println(s1.toString());
   
   }
}