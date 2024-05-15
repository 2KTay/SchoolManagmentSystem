/*
StudentDelete.java
Drop a course

 */

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;
 
 public class StudentDelete extends Main{
     static Scanner scanner = new Scanner(System.in);
 
 
     //drops a course
     public static void stuDeleteCour() throws IOException {
 
         String[] data = ReadCol(0, "coursesInfo.csv", ",");
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
 
         System.out.println("What is the course you want to drop");
         String newCourseName = scanner.nextLine();
 
         String courseStuChoice=newCourseName+".csv";
 
         File studentsCoursesFile = new File(courseStuChoice);
 
         if (!studentsCoursesFile.exists()) {
             System.out.println("Error: You are not enrolled in that course or the course doesn't exist");
             StudentCentral.StudentMenu();
             return;
         }
 
         for (String datum : data) {
             if(datum.equals(newCourseName)) {
 
                 String studentName=getStudentName("studentsInfo.csv",getStuLogUN());
                 removeRecord(courseStuChoice,studentName,0);
                 
                 removeStudentCourseRecord("studentsCourses.csv", studentName, newCourseName);
                 StudentCentral.StudentMenu();
             }
         }
 
         System.out.println("Error. You are not enrolled in that course\nor course doesn't exist");
 
         StudentCentral.StudentMenu();
 
     }
 
     public static void removeStudentCourseRecord(String fileName, String studentName, String courseName) {
         try {
             File inputFile = new File(fileName);
             File tempFile = new File("temp.csv");
 
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
 
             String currentLine;
 
             while ((currentLine = reader.readLine()) != null) {
                 String[] parts = currentLine.split(",");
                 if (!(parts[0].equals(studentName) && parts[1].equals(courseName))) {
                     writer.write(currentLine + System.getProperty("line.separator"));
                 }
             }
 
             writer.close();
             reader.close();
 
             inputFile.delete();
             tempFile.renameTo(inputFile);
 
             System.out.println("Successfully removed student's course record from " + fileName);
         } catch (IOException e) {
             System.out.println("An error occurred while removing the student's course record from " + fileName + ": " + e.getMessage());
         }
     }
 
     
 
     
 }
 