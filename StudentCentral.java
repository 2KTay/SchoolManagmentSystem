/*
AdminCentral.java file

Inheriting from abstract class of User for welcomeMessage

Having the menu with the option to choose any of the functions

 */

 import java.io.IOException;
 import java.util.Scanner;
 import java.util.Date;
 
 public class StudentCentral extends User {
     static Scanner scanner = new Scanner(System.in);
 
 
     //constructor
     public StudentCentral(String name) {
         super(name);
     }
 
 
 
     //Inheriting from abstract class of User for welcomeMessage
     @Override
     public void welcomeMessage() {
         System.out.println("\nWelcome, " + getName() + "!");
         Date date = new Date();
         System.out.println(date);
         System.out.println("\n"+getName()+"'s Menu\n");
 
 
     }
 
     //Having the menu with the option to choose any of the functions
     public static void StudentMenu() throws IOException {
         int i = 0;
         while (i<=0){
             System.out.println("Enter a choice\n" +
                     "1. Enroll in a course \n" +
                     "2. Drop a course\n" +
                     "3. Check grades\n" +
                     "4. View all courses the student is enrolled in\n" +
                     "5. Log Out");
             int adminChoice = scanner.nextInt();
 
             if (adminChoice == 1) {
                 i=i+1;
                 StudentCreate.stuEnrollCourse();
 
             } else if (adminChoice == 2) {
                 i=i+1;
                 StudentDelete.stuDeleteCour();
 
 
             } else if (adminChoice == 3) {
                 i=i+1;
                 StudentView.stuCheckGrades();
 
             } else if (adminChoice == 4) {
                 i = i + 1;
                 StudentView.stuViewCour();
 
             }else if(adminChoice==5){
                 i=i+1;
                 System.out.println("Student Logged out. Have a nice day!");
                 Main.main(null);
 
             }else{
                 System.out.println("Invalid Option. Try Again");
             }
 
         }
     }
 
 }
 