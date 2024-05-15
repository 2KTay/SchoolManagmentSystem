/*
filename: Main.java
 Purpose:
This assignment will introduce you to Object-Oriented programming concepts
(inheritance and abstraction) and file I/O in Java.

Create a school management system (like Canvas) that lets different types of users
perform certain tasks.
There are 3 types of users and each type has a certain set of tasks it can perform:

For more infomation, please read the README.txt

author: Taemoor Hasan
3/29/2024
 */

 import java.io.IOException;
 import java.util.Scanner;
 
 
 
 
 //asks user if they are admin, student, or teacher
 //Each user has a log in which checks if username and password is valid or not
 public class Main extends FileHandler {
 
 
     private static String teacherLogUN;
     private static String stuLogUN;
 
 
 
     //gets the teacherUsername
     public static String getTeacherLogUN() {
         return teacherLogUN;
     }
 
     //gets the studentUsername
     public static String getStuLogUN(){
         return stuLogUN;
     }
 
     public static void main(String[] args) throws IOException {
 
         Scanner scanner = new Scanner(System.in);
 
 
 
         int i = 0;
         while (i <= 0) {
             System.out.println("Welcome to the School Management System\n\nAre you a..." +
                     "\nStudent(s)\nTeacher(t)\nAdmin(a)\nEXIT(e)");
             String opt = scanner.nextLine();
             switch (opt) {
 
                 //checks the file to see if username and password matches
                 //if it matches, they go to the Menu
                 case "s" -> {
                     System.out.print("Please log in, Student\nUserName:");
                     String stuLogUN = scanner.nextLine();
                     Main.stuLogUN=stuLogUN;
 
 
                     System.out.print("Password:");
                     String stuLogPW = scanner.nextLine();
 
                     String[] data1 = ReadCol(1, "studentsInfo.csv", ",");
                     String[] data2 = ReadCol(2, "studentsInfo.csv", ",");
 
                     boolean loggedIn = false;
                     if (data1 != null && data2 != null && data1.length == data2.length) {
                         for (int j = 0; j < data1.length; j++) {
                             if (data1[j].equals(stuLogUN) && data2[j].equals(stuLogPW)) {
                                 loggedIn = true;
                                 break;
                             }
                         }
                     } else {
                         System.out.println("Error reading teacher data.");
                         return; // Exit program if unable to read data
                     }
 
                     if (loggedIn) {
                         StudentCentral student = new StudentCentral(getStuLogUN());
                         student.welcomeMessage();
 
                         StudentCentral.StudentMenu();
                     } else {
                         System.out.println("Invalid username or password. Please try again.");
                     }
 
 
                 }
                 //checks the file to see if username and password matches
                 //if it matches, they go to the Menu
                 case "t" -> {
                     System.out.print("Please log in, Teacher\nUserName:");
                     String teacherLogUN = scanner.nextLine();
                     Main.teacherLogUN=teacherLogUN;
 
                     System.out.print("Password:");
                     String teacherLogPW = scanner.nextLine();
 
                     String[] data1 = ReadCol(1, "teachersInfo.csv", ",");
                     String[] data2 = ReadCol(2, "teachersInfo.csv", ",");
                     boolean loggedIn = false;
                     if (data1 != null && data2 != null && data1.length == data2.length) {
                         for (int j = 0; j < data1.length; j++) {
                             if (data1[j].equals(teacherLogUN) && data2[j].equals(teacherLogPW)) {
                                 loggedIn = true;
                                 break;
                             }
                         }
                     } else {
                         System.out.println("Error reading teacher data.");
                         return; // Exit program if unable to read data
                     }
 
                     if (loggedIn) {
                         TeacherCentral teacher = new TeacherCentral(getTeacherLogUN());
                         teacher.welcomeMessage();
 
                         TeacherCentral.TeacherMenu(teacherLogUN);
                     } else {
                         System.out.println("Invalid username or password. Please try again.");
                     }
                 }
 
 
                 //checks the if statement to see if username and password matches
                 //if it matches, they go to the Menu
                 case "a" -> {
                     System.out.print("Please log in, Admin\nUserName:");
                     String adminLogUN = scanner.nextLine();
 
                     System.out.print("Password:");
                     String adminLogPW = scanner.nextLine();
 
                     if ((adminLogUN.equals("admin")) && (adminLogPW.equals("admin"))) {
                         i = i + 1;
 
                         AdminCentral admin = new AdminCentral("Admin");
                         admin.welcomeMessage();
                         AdminCentral.AdminMenu();
                     } else {
                         System.out.println("Invalid Admin Credentials: Please Try again");
 
                     }
                 }
 
                 //exits out program
                 case "e" -> {
                     i = i + 1;
                     System.out.println("Exited! Enjoy your day!");
                     System.exit(0);
                 }
                 default -> System.out.println("Invalid Option. Try Again");
             }
         }
 
     scanner.close();
     //add this, so no memory leak
     }
 }
 