/*
StudentView.java

Check grades
View all courses the student is enrolled in

 */

 import java.io.IOException;

 public class StudentView extends Main {
 
 
     //student checks the grade
     public static void stuCheckGrades() throws IOException {
         String[] data = ReadCol(0, "coursesInfo.csv", ",");
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
 
         System.out.println("What is the course you want to view");
         String newCourseName = scanner.nextLine();
 
         String courseStuChoice = newCourseName + ".csv";
 
 
         boolean courseFound = false;
 
         for (String datum : data) {
 
             String trimmedDatum = datum.trim();
 
 
             if (trimmedDatum.equals(newCourseName)) {
                 courseFound = true;
                 String studentName = getStudentName("studentsInfo.csv", getStuLogUN());
                 String[] grades = ReadCol(studentName, courseStuChoice, ",");
 
                 if (grades != null) {
                     for (String grade : grades) {
                         System.out.println("Grade: " + grade);
                     }
                 } else {
                     System.out.println("An error occurred while reading the file.");
                 }
                 break;
             }
         }
 
         if (!courseFound) {
             System.out.println("Wrong name for course");
             StudentCentral.StudentMenu();
         }
 
 
         StudentCentral.StudentMenu();
 
     }
 
     //student views their courses
     public static void stuViewCour() throws IOException {
         String studentName = getStudentName("studentsInfo.csv", getStuLogUN());
         String[] data = ReadCol(studentName, "studentsCourses.csv", ",");
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
         StudentCentral.StudentMenu();
 
 
     }
 
 }