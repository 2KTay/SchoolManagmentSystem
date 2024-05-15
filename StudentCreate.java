/*
StudentCreate.java
Enroll in a course


 */

 import java.io.*;
 import java.util.Scanner;
 
 public class StudentCreate extends Main {
     static Scanner scanner = new Scanner(System.in);
 
 
     //enrolls in a course
     public static void stuEnrollCourse() throws IOException {
         String[] data = ReadCol(0, "coursesInfo.csv", ",");
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
         System.out.println("What is the course you want to enroll in");
         String newCourseName = scanner.nextLine();
 
         String courseStuChoice = newCourseName + ".csv";
 
 
         File courseFile = new File(courseStuChoice);
 
         if (!courseFile.exists()) {
             System.out.println("Error: No teacher is in the course. Please try again later");
             StudentCentral.StudentMenu();
             return;
         }
 
         boolean courseExists = false;
         for (String datum : data) {
             if (datum.equals(newCourseName)) {
                 courseExists = true;
                 String studentName = getStudentName("studentsInfo.csv", getStuLogUN());
 
                 appendToFile(courseFile, studentName);
 
                 File courseStudentCourses = new File("studentsCourses.csv");
 
                 if (courseStudentCourses.exists()) {
                     if(courseStudentCourses.length()==0) {
                         createFile("studentsCourses.csv",studentName,newCourseName,"Students","Courses");
                     }else{
                         if(stringExistsInFile(courseStudentCourses,studentName + "," + newCourseName)) {
                             System.out.println("Already in the file");
                             StudentCentral.StudentMenu();
                         }else{
                             FileWriter myWriter = new FileWriter("studentsCourses.csv", true);
                             myWriter.write(studentName + "," + newCourseName + "\n");
                             myWriter.close();
                         }
 
                     }
                 }else{
                     createFile("studentsCourses.csv",studentName,newCourseName,"Students","Courses");
                 }
 
 
                 StudentCentral.StudentMenu();
                 return;
             }
         }
 
         if (!courseExists) {
             System.out.println("Error: Course doesn't exist");
         } else {
             System.out.println("Error: You are not enrolled in that course");
         }
 
         StudentCentral.StudentMenu();
     }
 
     //allows to append to the file, a small function
     public static void appendToFile(File fileName, String data) {
         try {
 
             if (stringExistsInFile(fileName,data)) {
                 System.out.println("Student already exists in the file.");
                 return;
             }
 
             
             FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(data + "\n"); 
             bw.close();
             fw.close();
             System.out.println("Student added to the file.");
         } catch (IOException e) {
             e.printStackTrace();
             System.out.println("Error occurred while writing to file: " + fileName);
         }
     }
 
     //see if the string exists or not
     public static boolean stringExistsInFile(File file, String searchString) throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader(file));
         String line;
         while ((line = reader.readLine()) != null) {
             if (line.contains(searchString)) {
                 reader.close();
                 return true;
             }
         }
         reader.close();
         return false;
     }
 
 
 
 }
 
 
 
 
 
 