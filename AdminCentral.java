/*
AdminCentral.java file

Inheriting from abstract class of User for welcomeMessage

Having the menu with the option to choose any of the functions

 */



 import java.io.IOException;
 import java.util.Scanner;
 import java.util.Date;
 
 public class AdminCentral extends User {
     static Scanner scanner = new Scanner(System.in);
 
 
     //constructor
     public AdminCentral(String name) {
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
     public static void AdminMenu() throws IOException {
         int i = 0;
         while (i<=0){
             System.out.println("Enter a choice\n" +
                     "1. Create a student account\n" +
                     "2. Delete a student account\n" +
                     "\n" +
                     "3. Create teacher account\n" +
                     "4. Delete a teacher account\n" +
                     "\n" +
                     "5. Create a course\n" +
                     "6. Delete a course\n" +
                     "\n" +
                     "7. View all students\n" +
                     "8. View all teachers\n" +
                     "9. View all courses\n" +
                     "\n"+
                     "10. Log Out");
             int adminChoice = scanner.nextInt();
 
             if (adminChoice == 1) {
                 i=i+1;
                 AdminCreate.adminCreateStudentAcc();
 
             } else if (adminChoice == 2) {
                 i=i+1;
                 AdminDelete.adminDeleteStu();
 
 
             } else if (adminChoice == 3) {
                 i=i+1;
                 AdminCreate.adminCreateTeacherAcc();
 
             } else if (adminChoice == 4) {
                 i = i + 1;
                 AdminDelete.adminDeleteTeach();
 
 
             }else if(adminChoice==5) {
                 i = i + 1;
                 AdminCreate.adminCreateCourse();
             }else if(adminChoice==6){
                 i=i+1;
                 AdminDelete.adminDeleteCourse();
 
 
             }else if (adminChoice == 7) {
                 i = i + 1;
                 AdminView.adminViewStudents();
 
             }else if(adminChoice==8) {
                 i = i + 1;
                 AdminView.adminViewTeachers();
 
             }else if(adminChoice==9) {
                 i = i + 1;
                 AdminView.adminViewCourses();
 
 
             }else if(adminChoice==10){
                 i=i+1;
                 System.out.println("Admin Logged out. Have a nice day!");
                 Main.main(null);
 
             }else{
                 System.out.println("Invalid Option. Try Again");
             }
 
         }
     }
 
 }
 