/*
TeacherView.java

View all courses the teacher is enrolled in
View all students in a course

 */

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 
 public class TeacherView extends Main {
 
 
 
     //View all courses the teacher is enrolled in
     public static void viewAllCourses() throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader("teachersCourses.csv"));
         String line;
         HashMap<String, List<String>> teacherCourses = new HashMap<>();
 
 
         reader.readLine();
 
 
         while ((line = reader.readLine()) != null) {
 
             if (line.trim().isEmpty()) {
                 continue;
             }
             String[] parts = line.split(",");
             if (parts.length >= 2) {
                 String teacher = parts[0].trim();
                 String course = parts[1].trim();
 
                 if (teacherCourses.containsKey(teacher)) {
                     teacherCourses.get(teacher).add(course);
                 } else {
 
                     List<String> courses = new ArrayList<>();
                     courses.add(course);
                     teacherCourses.put(teacher, courses);
                 }
             } else {
                 System.err.println("Invalid line format in CSV file: " + line);
             }
         }
 
         reader.close();
 
 
         if (teacherCourses.containsKey(getTeacherLogUN())) {
             List<String> courses = teacherCourses.get(getTeacherLogUN());
             System.out.println("Teacher " + getTeacherLogUN() + "'s courses:" + courses);
             TeacherCentral.TeacherMenu(getTeacherLogUN());
 
         }
         TeacherCentral.TeacherMenu(getTeacherLogUN());
 
     }
 
     //View all students in a course
     public static void viewAllStudents() throws IOException {
         FileHandler.checkTeacher(getTeacherLogUN());
         String className=getCourseChoice()+".csv";
 
         String [] data= FileHandler.ReadCol(0,className,",");
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
 
         TeacherCentral.TeacherMenu(getTeacherLogUN());
     }
 }