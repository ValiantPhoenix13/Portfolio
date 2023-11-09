/************************************************************************************************************************
Andrew Lawson
18 October 2020
The following program acts as a simple calculator that can perform a math operand between two numbers
***********************************************************************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class ALawsonSimpleCalculator{

   public static void main (String[] args){
      run();
   }
   
   public static void run(){
      menu();
      Scanner input = new Scanner(System.in);
      int times = input.nextInt();
      for(int i = 1; i <= times; i++){
         System.out.println("For calculation number " + i);
         System.out.print("What would you like the operation to be? ");
         System.out.println("");
         String op = input.next();
         System.out.print("Please enter a number between 0 and 9: ");
         System.out.println("");
         int a = input.nextInt();
         System.out.print("Please enter a second number between 0 and 9: ");
         System.out.println("");
         int b = input.nextInt();
         double answer;
         answer = calculate(a,b,op);
         String num1 = convertNumToWord(a);
         String num2 = convertNumToWord(b);
         String opConvert = convert(op);
         System.out.println("" + num1 + " " + opConvert + " " + num2 + " is equal to " + answer);
         System.out.println(""); 
      }
   
   }
   
   public static String convert(String op){
      String opConvert = "";
      if(op.equals("+")){
         opConvert = "plus";
      }
      if(op.equals("-")){
         opConvert = "minus";
      }
      if(op.equals("*")){
         opConvert = "times";
      }
      if(op.equals("/")){
         opConvert = "divided by";
      }
      if(op.equals("%")){
         opConvert = "modulus";
      }
      if(op.equals("^")){
         opConvert = "to the power of";
      }
      return opConvert;
   }
   
   public static String convertNumToWord(int a){
      String num = "";
      if(a==0){
         num = "zero";
      }
      if(a==1){
         num = "one";
      }
      if(a==2){
         num = "two";
      }
      if(a==3){
         num = "three";
      }
      if(a==4){
         num = "four";
      }
      if(a==5){
         num = "five";
      }
      if(a==6){
         num = "six";
      }
      if(a==7){
         num = "seven";
      }
      if(a==8){
         num = "eight";
      }
      if(a==9){
         num = "nine";
      }
      return num;
   }
   
   public static double calculate(int a, int b, String op){
      double answer = 0;
      switch (op){
         case "+": answer = a + b;
            break;
         case "-": answer = a - b;
            break;
         case "*": answer = a * b;
            break;
         case "/": answer = a / b;
            break;
         case "^": answer = Math.pow(a,b);
            break;
         case "%": answer = a % b;
            break;
      }
      return answer;
      
   }
   
   public static void menu(){
      System.out.println("Hello, I will help you perform simple math operations between two numbers.");
      System.out.println("These two number have to be greater than or equal to 0 and less than or equal to 9.");
      System.out.println("Addition: +");
      System.out.println("Subtraction: -");
      System.out.println("Multiplication: *");
      System.out.println("Division: /");
      System.out.println("Exponent: ^");
      System.out.println("Modulus: %");
      System.out.print("How many times would you like to use the calculator? ");
      System.out.println("");
   }
}