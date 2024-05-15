/*
AdminCreate.java

creating the Student account by asking the name, username, password with one continuous question
creating the Teacher account by asking the name, username, password with one continuous question
creating the Course by asking the name with a question


 */

 import java.io.IOException;
 import java.util.Scanner;
 
 public class AdminCreate extends FileHandler {
 
     static Scanner scanner = new Scanner(System.in);
 
 
     //creating the Student account by asking the name, username, password with one continuous question
     public static void adminCreateStudentAcc() throws IOException {
         System.out.println("Choose\n" +
                 "1. Create Student account\n" +
                 "2. Exit");
         int makeStudentAccChoice = scanner.nextInt();
         scanner.nextLine();
 
         if (makeStudentAccChoice==1) {
 
 
             System.out.println("What is the new student's name, username, password?");
             String newStudentName=scanner.nextLine();
             String newStudentUN=scanner.nextLine();
             String newStudentPW=scanner.nextLine();
 
 
            createFile("studentsInfo.csv",newStudentName,newStudentUN,newStudentPW,
                     "Students' Names","Username","Password", "Cannot have the same username.");
 
             AdminCentral.AdminMenu();
         }else if(makeStudentAccChoice==2){
             System.out.println("Exited! ");
             AdminCentral.AdminMenu();
 
         }else{
             System.out.println("Invalid Option. Try Again");
             AdminCentral.AdminMenu();
         }
 
 
     }
 
     //creating the Teacher account by asking the name, username, password with one continuous question
     public static void adminCreateTeacherAcc() throws IOException {
         System.out.println("Choose\n" +
                 "1. Create Teacher account\n" +
                 "2. Exit");
         int makeTeachAccChoice = scanner.nextInt();
         scanner.nextLine();
 
         if (makeTeachAccChoice==1) {
 
             System.out.println("What is the new teacher's name, username, password?");
             String newTeacherName=scanner.nextLine();
             String newTeacherUN=scanner.nextLine();
             String newTeacherPW=scanner.nextLine();
 
 
             createFile("teachersInfo.csv",newTeacherName,newTeacherUN,newTeacherPW,
                     "teachers' Names","Username","Password", "Cannot have the same username.");
 
             AdminCentral.AdminMenu();
 
 
         }else if(makeTeachAccChoice==2){
             System.out.println("Exited! ");
             AdminCentral.AdminMenu();
 
         }else{
             System.out.println("Invalid Option. Try Again");
             AdminCentral.AdminMenu();
         }
 
     }
 
     //creating the Course by asking the name with a question
     public static void adminCreateCourse() throws IOException {
         System.out.println("Choose\n" +
                 "1. Create Course\n" +
                 "2. Exit");
         int makeCourseAccChoice = scanner.nextInt();
         scanner.nextLine();
 
         if (makeCourseAccChoice==1) {
 
             System.out.println("What is the new course's name?");
             String newCourseName=scanner.nextLine();
 
 
             createFile("coursesInfo.csv",newCourseName,
                     "Courses' Names");
 
 
             AdminCentral.AdminMenu();
 
 
         }else if(makeCourseAccChoice==2){
             System.out.println("Exited! ");
             AdminCentral.AdminMenu();
 
         }else{
             System.out.println("Invalid Option. Try Again");
             AdminCentral.AdminMenu();
         }
 
     }
 
 
 }
 