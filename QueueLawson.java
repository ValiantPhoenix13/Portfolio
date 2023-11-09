/*
Name: Andrew Lawson
date: 18 November 2022
Description: The following code is a custom Queue class and focuses on the ideas of scanning, and reversing the queue while
retaining its form 
self grade: My grade is 100 sense I have proper naming throughout, comments and block comments for each method, proper indentation,
the program compiles and runs, finally it matches the expected output with format and contains this self grading portion
*/
import java.util.*;
public class  QueueLawson
{
  // no code goes here
}
class Queue
{
   private ArrayList<String> q; 
   public Queue( )
   {
      q = new ArrayList<String>();
    
   }
   public void enqueue(String num)
   {
      q.add(num);
   }
   public String dequeue()
   {
      return q.remove(0);
   }
   
   /*This method goes through the quque and finds the longest name in the q
   The queue must be restored in its original state after finding the longest name*/
   public String getLongestName()
   {
      Stack s = new Stack();
      String longest = q.get(0);
     // q.remove(0);
      boolean b = false;
      while(!b)
      {
         try
         {
            String front = q.get(0);//get the first element
           
            q.remove(0);//remove it from the q
            s.push(front);// push it to the stack
            if (front.length() > longest.length() )
               longest = front;
              
              
         }
         catch(Exception e)
         {
            
            b = true;
         }
      
      }
      restore(s); // restoring the queue
      return longest;
   
   }
   /*
   Traverse through the queue and creates a string containing all the names.
   must restore the quque to its original state*/
   public String toString()
   {
      Stack c = new Stack();
      String s = "";
      boolean b = false;
      while(!b)
      {
         try
         {
            s = s + q.get(0)+ " ";
            c.push(q.remove(0));
         }
         catch(Exception e)
         {
            b = true;
         }
      }
      restore(c);
      return s;
   }
   /*
   This method is called to restore the queue to its original state*/
   public void restore(Stack s)
   {
      boolean b = false;
      while(!b)
      {
         try
         {  
            if (s.isEmpty())
               throw new Exception();
            String a = (String)s.pop();
            q.add(0,a);
         }
         catch(Exception c)
         {
            b = true; 
         }
      }
   }
   /*this method goes through the queue finding the longest name
   The queue must be restored to its original state
   this method is similar to the longest name*/
   public String getShortestName()
   {
      Stack s = new Stack();
      String shortest = q.get(0);
      boolean b = false;
      while(!b){
         try{
            String front = q.get(0);
            q.remove(0);
            s.push(front);
            if (front.length() < shortest.length()){
               shortest = front;
            }
         }
         catch(Exception e){
            b = true;
         }
      }
      restore(s);
      return shortest;                     
   }
   
   /*This method reverses the order of the names in the queue */ 
      
   public void listReversed()
   {
      Stack s = new Stack();
      boolean b = false;
      while (!b){
         try{
            s.push(dequeue());
         }
         catch(Exception e){
            b = true;
         }
      }
      b = false;
      while(!b){
         try{
            enqueue((String)s.pop());
         }
         catch(Exception e){
            b = true;
         }
      }
   }
   
   /*This method finds the verage length of the length of all the names in the q
   queue must be restored to its original state*/
   public double getAverageLength()
   {
      double sum = 0;
      double average = 0;
      double count = 0;
      Stack s = new Stack();
      boolean b = false;
      while (!b){
         try{
            String curr = dequeue();
            s.push(curr);
            sum = sum + curr.length();
            count++;
         }
         catch (Exception e){
            b = true;
         }
      }
      restore(s);
      average = sum / count;
      return average;
       
   }
   
   /* 
   This method returns true if the q is sorted alphabetically
   Queue must be restored to its original state
   */
   public boolean ordered()
   {  
      Stack s = new Stack();
      boolean b = false;
      boolean sorted = true;
      while (!b){
         try{
            String first = dequeue();
            s.push(first);
            String second = dequeue();
            s.push(second);
            if (first.compareToIgnoreCase(second) > 0){
               sorted = false;
            }
         }
         catch(Exception e){
            b = true;
         }
      }
      restore(s);
      return sorted;                     
   }
   
   /*this method returns true if the queue is palindrom and returns false otherwise
   call the method copy in the palindrome method*/
   public boolean isPalindrome()
   {  
      boolean palindrome = false;
      ArrayList<String> copied = copy();
      Stack s = new Stack();
      boolean b = false;
      listReversed();  
      while (!b){
         try{
            String first = dequeue();
            s.push(first);
            String second = copied.remove(0);
            if (first.compareToIgnoreCase(second) == 0){
               palindrome = true;
            } 
            else{
               palindrome = false;
               break;
            }
         }
         catch (Exception e){
            b = true;
         }
      }
      restore(s);
      listReversed();
      return palindrome;
   }
   
   /*
   * The following method copies a queue into another arraylist
   */
   public ArrayList<String> copy()
   {
      ArrayList<String> replica = new ArrayList<String>();
      Stack<String> s = new Stack<String>();
      boolean b = false;
      while (!b){
         try{
            s.push(dequeue());
         }
         catch (Exception e){
            b = true;
         }
      }
      b = false;
      while (!b){
         try{
            String curr = s.pop();
            enqueue(curr);
            replica.add(curr);
         }
         catch (Exception e){
            b = true;
         }
      }
      return replica;   
   } 
           
    
}
class Driver
{
   public static void main(String[] args)
   {
      String[] names = {"Alexis", "Zoeehra","Maryam","Jose","Bill","Niksan", "BB"};
      //String[] names = {"a", "b", "c", "b","a"};
      Queue  people = new Queue();
      //enqueue the queue using the array called names
      for(int i = 0; i < names.length; i++)
      {
         people.enqueue(names[i]);
      }
      System.out.println("The q of the people at Bestbuy on black Friday : " + people);
      people.listReversed();
      System.out.println("The q of the people in the reverse order is: "+ people   );
      people.listReversed();
      System.out.println("List is back to its original state: "+ people);
      System.out.printf("Average length of all the Strings in the q is = %.2f\n", people.getAverageLength());
       
      System.out.println("The longest name in the q is = " + people.getLongestName());
      System.out.println(people+"******************");
      System.out.println("The shortest name in the q is = " + people.getShortestName());
      System.out.print("is of the list of the people is sorted? " ); 
      if(people.ordered())
         System.out.print("Yes\n");
      else
         System.out.print("No\n");
      if(people.isPalindrome())
         System.out.println("The list is palindrome");
      else
         System.out.println("The list is not palindrome"); 
      System.out.println(people.isPalindrome());         
      
    
   }
}
/* create your own driver(15 points)
In this driver must use an array q otherwise you will not get any points*/

class YourDriver
{
   public static void main (String[] args)
   {
      //1. declare an arrayq to store some names of your choice
      String q[] = new String[6];
      q[0] = "h";
      q[1] = "a";
      q[2] = "n";
      q[3] = "n";
      q[4] = "a";
      q[5] = "h";
      //2. declare a Queue and instantiate it
      Queue pending = new Queue();
      //3. copy the names from the arrayq to the queue that you declared(for loop is needed
      for (int i = 0; i < 6; i++){
         pending.enqueue(q[i]);
      }
      //4. call all the methods similar to the given driver.
      System.out.println("The original list: "); 
      System.out.println(pending.toString());
      System.out.println("Reversed, the list is: ");
      pending.listReversed();
      System.out.println(pending.toString());
      pending.listReversed();
      System.out.println("Is the list sorted?: " + pending.ordered());
      System.out.println("Is the list a palindrome?: " + pending.isPalindrome());
   }
}