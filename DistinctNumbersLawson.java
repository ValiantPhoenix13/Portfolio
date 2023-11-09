/*
Name: Andrew Lawson
Date: 4 September 2022
description: The following program will request the user to enter numbers until they've entered 10 unique numbers and will then display them back to the user
self grade: My grade is 100 sense I have proper naming throughout, comments and block comments for each method, proper indentation,
the program compiles and runs, finally it matches the expected output with format and contains this self grading portion
Testimony: I have written this program all by myself and have not copied any code 
from any resourses: Andrew Lawson 
*/
import java.util.*;
public class DistinctNumbersLawson
{
  // int[] num = new int[10];
   public static void main(String[] args)
   {
      System.out.println("Welcome to the distinct numbers. \n I will remove the " + 
         "repeated numbers and display the numbers you just enetered");
      int[] num = new int[10];
      int counter = getInput(num);
      display(num, counter);
   }
   
   //The following method will loop, asking for numbers until 10 unique numbers have been entered
   public static int  getInput(int[] numbers)
   {
      Scanner kb = new Scanner(System.in);
      int holder;
      int counter = 0;
      /*
      *Had to switch the loop to be less than OR equal to. Kept taking 0
      * as the 10th value otherwise.
      */
      for (int i = 0; i <= numbers.length - 1; i++)
      {
         System.out.print("Please enter a number: ");
         holder = kb.nextInt();
         counter++;
         boolean distinct;
         distinct = isDistinct(numbers, holder);
         if (distinct == true){
            i--;
         } else {
            numbers[i] = holder;
         }
         
         
      }
      return counter;
   }
   
   //Will display the list of 10 unique numbers, and the number of values entered to get those 10 unique values
   
   public static void display(int[] num, int counter)
   {
      System.out.println("Andrew Lawson");
      System.out.println("You entered " + counter + " numbers total,\n" +
         "I filtered out all the repeated numbers. Here is the list of distinct numbers\n" +
         "you entered.");
      System.out.print("{");
      for (int i = 0; i < num.length - 1; i++){
         System.out.print(num[i] + ", ");     
      }
      System.out.println(num[num.length - 1] + "}");
     
   }
    
    /* Checks to see if the number entered is unique, if it is unique returns false;
    * however will return true if the number is found in the array
    */
   public static boolean isDistinct(int[] num, int n)
   {
      for (int i = 0; i < num.length; i++){ //Cycle through the array
         if (n == num[i]){
            return true;
         }
      }
      return false;
   }
}