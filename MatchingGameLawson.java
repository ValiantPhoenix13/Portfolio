
/*
name: Andrew Lawson
date: 11 September 2022

descrition: The following program is a small game that randomly generates 3 numbers within a provided maximum;
afterwards those three randomly generated numbers are compared to each other. If two of the numbers match 200 dollars will be awarded, and if
all three numbers match 500 dollars will be awarded.

self-grade: My grade is 100 sense I have proper naming throughout, comments and block comments for each method, proper indentation,
the program compiles and runs, finally it matches the expected output with format and contains this self grading portion
Testimony: I have written this program all by myself and have not copied any code 
from any resources: Andrew Lawson
*/
import java.util.*;
public class MatchingGameLawson
{
   public static void main(String[] args)
   {
      //fill in the code for each line of the provided comment
      Scanner kb = new Scanner(System.in);
      String answer = "";                   
      
      while (!answer.equalsIgnoreCase("q"))
      {
         description();
        
         System.out.print("What is your name?: ");
         String player = kb.nextLine();
         System.out.println("");
         System.out.println("Hello " + player + " let's get started!");
         
         Random rand = new Random();
         play(rand); 
         
         System.out.print("If another player wants to play some rounds press enter or type Q/q to exit the game: ");
         answer = kb.nextLine();
         
     }
     System.out.println("Thanks for playing, come play again anytime!");
      
   }
  
   /*
   This method will generate a random number between 1 and the maximum value, inclusive.
  
   */
   public static int getRand(Random rand, int max)
   {
      return rand.nextInt(max) + 1;
   }
  
   /*
   The following method initializes and sets up the settings for this player's game. It will ask the user for a max value greater than 3.
   It will then call on another method, getRand() three times, to generate three random numbers based on the provided maximum.
  
   */
   public static void play(Random rand)
   {
      
      Scanner kb = new Scanner(System.in);
      int total = 0;
      String answer = "";
      int n1= 0, n2 = 0, n3 = 0;
      int max = 0;
      System.out.print("Please provide a maximum value to start generating three random numbers: ");
      max = kb.nextInt();
      kb.nextLine();
      System.out.println("");
      while(max <= 3)
      {
         System.out.print("Please provide a maximum value greater than 3: ");
         max = kb.nextInt();
         kb.nextLine();
         System.out.println("");
         
      }
      while(!answer.equalsIgnoreCase("q"))
      {

         n1 = getRand(rand, max);
         n2 = getRand(rand, max);
         n3 = getRand(rand, max);
         System.out.println("The generated numbers were: " + n1 + " " + n2 + " " + n3);
              
         int match = match(n1,n2,n3);
         if (match == 2)
         {
            total = total + 200;
            System.out.println("You got two matches, you won 200 dollars");
         }   
         else if( match == 3)
         {
            total = total + 500;
            System.out.println("You got three matches, you won 500 dollars");
            
         }    
         else
            System.out.println("There aren't any matches.");
     
         System.out.print("\nHit enter to continue or press q/Q to quit  ");
         answer = kb.nextLine(); 
       
             
      }
      System.out.println("\nTotal amount you won: " + total);
      System.out.println("\n");
     
   }
  
   /*
   This method will compare the three generated numbers to each other. If two of the number match 2 will be returned, and if three match a 3 will be returned.
   Otherwise the method will return a 0.
  
   */
   public static int match(int n1, int n2, int n3)
   {
      int matching = 0;
      if (n1 == n2 && n2 == n3)
      {
         matching = 3;
      } 
      else if (n1 == n2 || n1 == n3 || n2 == n3)
      {
         matching = 2;
      }
      
      return matching;
   }
  
   /*
   This is the welcome message that is displayed each time a new player first starts playing
  
   */
   public static void description()
   {
      System.out.println("Welcome to the number matching game. Three numbers will be generated from of a provided maximum that must be greater than 3.\n" +
      "If two of the random numbers match each other, 200 dollars will be awarded.\n" +
      "If all three match 500 dollars will be awarded! When you're done playing your total winning will be displayed and you'll be asked if another player would like to play.");
   }
}