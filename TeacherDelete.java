/*
TeacherDelete.java

Drop a course

Remove students from a course, the teacher must be enrolled in that course
 */

 import java.io.File;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.Scanner;
 
 public class TeacherDelete extends FileHandler {
     static Scanner scanner = new Scanner(System.in);
 
     //Drop a course
     public static void dropCourse(String teacherLogUN) throws IOException {
         File fileTeach = new File("teachersCourses.csv");
         if (!fileTeach.exists()) {
             System.err.println("Error: File teachersCourses.csv does not exist.");
             TeacherCentral.TeacherMenu(teacherLogUN);
         } else {
             checkTeacher(teacherLogUN);
             removeRecordTeach("teachersCourses.csv", teacherLogUN, getCourseChoice());
 
             String filePath = getCourseChoice() + ".csv";
 
 
             File file = new File(filePath);
 
 
             if (file.exists()) {
                 try {
 
                     Files.deleteIfExists(Paths.get(filePath));
                     System.out.println("File deleted successfully.");
                 } catch (IOException e) {
                     System.out.println("An error occurred while deleting the file: " + e.getMessage());
                 }
             } else {
                 TeacherCentral.TeacherMenu(teacherLogUN);
             }
         }
 
 
         TeacherCentral.TeacherMenu(teacherLogUN);
 
 
     }
 
 
     //Remove students from a course, the teacher must be enrolled in that course
     public static void removeStudentCour(String teacherLogUN) throws IOException {
         File file = new File("teachersCourses.csv");
         if (!file.exists()) {
             System.err.println("Error: File teachersCourses.csv does not exist.");
             TeacherCentral.TeacherMenu(teacherLogUN);
         } else {
             checkTeacher(teacherLogUN);
 
             String classFileName = getCourseChoice() + ".csv";
             String[] data = ReadCol(0, classFileName, ",");
             assert data != null;
             for (String datum : data) {
                 System.out.println(datum);
 
 
             }
 
             System.out.println("Enter which student(enter no if you want no students deleted)");
             String studentRemove = scanner.nextLine();
 
             if (!studentRemove.equals("no")) {
                 boolean n = false;
                 for (String datum : data) {
                     if (studentRemove.equals(datum)) {
                         n = true;
                         break;
                     }
                 }
                 if (!n) {
                     System.err.println("Error. Wrong student");
                     TeacherCentral.TeacherMenu(teacherLogUN);
 
                 } else {
 
 
                     removeRecord(classFileName, studentRemove, 0);
                     TeacherCentral.TeacherMenu(teacherLogUN);
 
                 }
             } else {
                 TeacherCentral.TeacherMenu(teacherLogUN);
             }
         }
 
 
     }
 }
 