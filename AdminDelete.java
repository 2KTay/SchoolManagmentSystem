/*
AdminDelete.java

deleting a student account based on reading the file
deleting a teacher account based on reading the file
deleting a course based on reading the file

 */

 import java.io.File;
 import java.io.IOException;
 import java.util.Scanner;
 
 public class AdminDelete extends FileHandler {
     static Scanner scanner = new Scanner(System.in);
 
     //deleting a student account based on reading the file
     public static void adminDeleteStu() throws IOException {
         System.out.println("What student do you want to delete");
         String deleteName=scanner.nextLine();
         removeRecord("studentsInfo.csv",deleteName,0);
 
         AdminCentral.AdminMenu();
     }
 
     //deleting a teacher account based on reading the file
     public static void adminDeleteTeach() throws IOException {
         System.out.println("What teacher do you want to delete");
         String deleteName=scanner.nextLine();
         removeRecord("teachersInfo.csv",deleteName,0);
 
         AdminCentral.AdminMenu();
     }
     
     public static void adminDeleteCourse() throws IOException {
         System.out.println("What course do you want to delete");
         String deleteName=scanner.nextLine();
 
 
         String fileName=deleteName+".csv";
 
 
 
         removeRecord("coursesInfo.csv",deleteName,0);
         
 
         File file = new File("teachersCourses.csv");
         
         if (file.exists()) {
             removeRecord("teachersCourses.csv",deleteName,1);
         } 
 
         File fileStudentCourse = new File("studentsCourses.csv");
         
         if (fileStudentCourse.exists()) {
             removeRecord("studentsCourses.csv",deleteName,1);
         } 
     
 
         deleteFile(fileName);
         
 
 
 
         AdminCentral.AdminMenu();
     }
 }
 