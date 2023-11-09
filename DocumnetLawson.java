/*
name: Andrew Lawson
date: 25 September 2022

descrition: The following code applies inheritance of a document using a email as the specialized object. 

self-grade: My grade is 100 sense I have proper naming throughout, comments and block comments for each method, proper indentation,
the program compiles and runs, finally it matches the expected output with format and contains this self grading portion
Testimony: I have written this program all by myself and have not copied any code 
from any resources: Andrew Lawson
*/

import java.util.*;
public class DocumnetLawson //<-------add your last name here
{
   //no code goes here. Must leave empty
}
class Document
{
 // your code, read the provided document before implementing
   //Instance variables
   private String content;
   
   
   //Document constructor
   public Document(String text){
      content = text;
   }
   
   //Document getter methods
   public String getContent(){
      return content;
   }
   public int getContentLength(){
      int length = content.length();
      return length;
   }
   
   //Document setter method
   public void setContent(String text){
      content = text;
   }
   
   //Document setup for printing
   public String toString(){
      String text = "Content: " + content;
      return text;
   }
   
   
   //Document boolean test
   public boolean contains(String keyword){
      boolean search = content.contains(keyword);
      return search;
   }
   public boolean equals(Document other){
      boolean copy = this.content.equalsIgnoreCase(other.content);
      return copy;
   }
 
 
}
class Email extends Document
{                        
     //your code, read the provided documnet before implementing
     //Instance varibales
     private String sender;
     private String recipient;
     private Date date;
     private String subject;
     private String cc;
     private boolean isSent;
     
     //Email constructor
     public Email(String text, String sender, String recipient, String subject, String cc){
         super(text);
         this.sender = sender;
         this.recipient = recipient;
         this.subject = subject;
         this.cc = cc;
         date = new Date();
     }
     
     //Email delivered boolean
     public void send(){
         isSent = true;
     }
     public boolean getSent(){
         return isSent;
     }
     
     //Email getter methods
     public String getSender(){
         return sender;
     }
     public String getRecipient(){
         return recipient;
     }
     public String getSubject(){
         return subject;
     }
     public String getCC(){
         return cc;
     }
     public Date Date(){
         return date;
     }
     
     //Email setter methods
     public void setSender(String s){
         if (isSent == false){
            sender = s;
         }
         else{
            System.out.println("This email has been sent and cannot be modified");
         }
     }
     public void setRecipient(String r){
         if (isSent == false){
            recipient = r;
         }
         else{
            System.out.println("This email has been sent and cannot be modified");
         }
     }
     public void setSubject(String s){
         if (isSent == false){
            subject = s;
         }
         else{
            System.out.println("This email has been sent and cannot be modified");
         }
     }
     public void setCC(String c){
         if (isSent == false){
            cc = c;
         }
         else{
            System.out.println("This email has been sent and cannot be modified");
         }
     }
     
     //Email setup for printing
     public String toString(){
         String email = "";
         email = "Sender: " + sender;
         email = email + "\nRecipient: " + recipient;
         email = email + "\nCC: " + cc;
         email = email + "\nSubject: " + subject;
         email = email + "\nDate: " + date;
         email = email + "\n" + super.toString();
         return email;
     }
     
     //Email modify message or contents of the document
     public void modifyContent(String s){
         if (isSent == false){
            super.setContent(s);
         }
         else{
            System.out.println("This email has been sent and cannot be modified");
         }
     }
     
     //Email forwarding that copies an existing email and sends it to other recipients
     public Email forward (String rec, String sender, String cc){
         Email f = new Email (this.getContent(), sender, rec, this.subject, cc);
         f.date = new Date();
         f.isSent = true;
         return f; 
     }
     
     
     
     
} 

//****************************************************************************************

//uncommnet this driver class once you have implemented the Documnet class and the Email class  

//Driver class used to test the functions and methods of document and email objects    
class EmailDriver
{
    // public Email(String text, String sender,String recipiant, String subject, String cc)
    public static void main(String[] args)
    {
      //creating an Email object
       Email e1 = new Email("Hello everyone, we will have a meeting tomorrow at 10", "Gita Faroughi","Alex","Meeting","");
      
       //sending the email
       e1.send();
       
       //disply the details about the email
       System.out.println(e1);
       System.out.println("\n\n");
       
       //searching the email for the email for the word tomorrow
       boolean b = e1.contains("tomorrow");
       if(b)
         System.out.println("The word tomorrow was  found in the email");
       else
          System.out.println("The word tomorrow wasnt found in the email"); 
           
      
       //displaying just the content(text) of the email
       System.out.println("\nThe content of this email is: " + e1.getContent());
       System.out.println();
       //modifying the content of the email
       e1.modifyContent("bye");
       
       //changing the recipient of the e1 email
       e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
       System.out.println();
       
       //forwarding the email
       Email forward = e1.forward("Alex", "Gita" ,"Maria");
       System.out.println();
       
       //printing the forwarded email 
       System.out.println("forwarded message\n"+ forward);
       System.out.println();
       
       //display the length of the text in the email
       System.out.println("The number of the letters in the email is: " + e1.getContentLength());
       
       //***********************************************************************
       //your turn, refer to the provided documnet on the codes you need to write
       
       //creating two email objects
       e1 = new Email("This is a testing message", "Andrew", "Casandra", "Testing", "");
       Email e2 = new Email("Test message recieved", "Casandra", "Andrew", "Test Response", "");
       
       //sending out the first email object
       System.out.println("Sending the email now\n\n");
       e1.send();
       
       //testing that the sent email wouldn't allow any edits to the attributes of the emial object
       System.out.println("Calling the setter methods\n");
       e1.setSender("Andrew");
       e1.setRecipient("Casandra");
       e1.setSubject("Test");
       e1.setCC("");
       
       //Testing forward email for the first email object
       System.out.println("\n\nForwarding the first email");
       forward = e1.forward("Vanessa", "Casandra", "Mike");
       
       //Showing the original sender and recipients for the first email
       System.out.println("\n\nThe email contains the following info\n" + e1);
       //Showing the forwarded email sender and recipients
       System.out.println("\nIt has been forwarded\n" + forward);
       
       //Forwarding the first email a second time
       System.out.println("\n\nForwarding the first email");
       forward = e1.forward("Irene", "Vanessa", "mark");
       
       //Testing the setter methods on the second email that hasnt been sent yet
       System.out.println("\n\nCallings setters for the second email\n");
       
       e2.setSender("Casandra");
       e2.setRecipient("Andrew");
       e2.setSubject("Results");
       e2.setCC("Vanessa");
       e2.modifyContent("All test were successful and everything seemed to work.");
       
       //Testing the getLength method on the second email
       System.out.println("\n\nThe length of the second email: " + e2.getContentLength());
       
       //Testing the search method to find a word in an email
       System.out.println("\nSearching the email for the word success");
       b = e2.contains("success");
       if (b){
         System.out.println("The word success is in the email");
       }
       else{
         System.out.println("The word success is not in the email");
       }
       
       //Sending and siplaying the contents of the new and improved second email
       System.out.println("\nSending the second email\n");
       e2.send();
       
       System.out.println("The second email contains the following info\n" + e2);
       
    }
}
