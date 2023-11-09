/******************************************************************************************************************
Andrew Lawson
22 November 2020
This program is a small trivia game with five questions of varying difficulties
******************************************************************************************************************/

import java.util.*;

public class TriviaGameAL{
   
   final int SIZE = 4;
   
   public static void main(String[] args){
      System.out.println("Before starting the trivia game, all answers are expected to be entered as text please no numbers.");
      System.out.println("Let the game begin, best of luck!");
      run();
   
   }
   
   public static void initialize(String[] questions, String[] answers, int[] points){
      questions[0]="A show on ABC that explores common childhood fairytales";
      answers[0]="once upon a time";
      points[0]=2;
      
      questions[1]="A game that is an RPG and focuses on combining worlds of Disney and anime together in a fight between light and darkness";
      answers[1]="kingdom hearts";
      points[1]=5;
      
      questions[2]="A form of entertainment that people play on a table top, CLUE is an example";
      answers[2]="board game";
      points[2]=3;
      
      questions[3]="How many years pass between each leap year?";
      answers[3]="four";
      points[3]=3;
      
      questions[4]="A hat placed on the heads of monarchs";
      answers[4]="crown";
      points[4]=1;
   
   }
   
   public static void run(){
      Scanner user = new Scanner(System.in);
      String[] questions = new String[5];
      String[] answers = new String[5];
      int[] points = new int[5];
      initialize(questions, answers, points);
      boolean more = true;
      while(more){
         int results = play(questions, answers, points);
         System.out.println("You've scored " + results + " points.");
         System.out.print("Would you or someone else like to play again? y/n: ");
         System.out.println("");
         String response = user.next();
         if(response.equalsIgnoreCase("n")){
            more = false;
            System.out.println("Thank you for playing!");
         }
         
      
      }
   
   }
   
   public static int play(String[] questions, String[] answers, int[] points){
      int score = 0;
      for(int i = 0; i <= 4; i++){
         Scanner user = new Scanner(System.in);
         System.out.println(questions[i]);
         System.out.println("answer: ");
         String userAnswer = user.nextLine();
         userAnswer = userAnswer.toLowerCase();
         if(userAnswer.equals(answers[i])){
            System.out.println("");
            System.out.println("Correct!");
            System.out.println("");
            score = score + points[i];
         
         } else {
            System.out.println("");
            System.out.println("Incorrect. The right answer is " + answers[i]);
            System.out.println("");
         
         }
         
      }
      
      return score;
   
   }
   
   

}