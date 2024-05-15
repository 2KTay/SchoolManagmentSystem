/*
TeacherCreate.java

Enroll in a course
Add students a course, the teacher must be enrolled in that course
Assign grades to students in courses, the teacher must be enrolled in that course

 */

 import java.io.*;
 import java.util.Scanner;
 
 public class TeacherCreate extends Main {
     static Scanner scanner = new Scanner(System.in);
     private static String studentChoice;
 
     public static String getStudentChoice() {
         return studentChoice;
     }
 
 
     //Enroll in a course
     public static void teacherEnrollCourse(String teacherLogUN) {
         try {
             String[] data = ReadCol(0, "coursesInfo.csv", ",");
             assert data != null;
             for (String datum : data) {
                 System.out.println(datum);
             }
 
             System.out.println("What is the course you want to enroll in");
             String newCourseName = scanner.nextLine();
 
             boolean courseExists = false;
             for (String datum : data) {
                 if (datum.equals(newCourseName)) {
                     courseExists = true;
                     break;
                 }
             }
 
             if (!courseExists) {
                 System.out.println("The course does not exist.");
                 TeacherCentral.TeacherMenu(teacherLogUN);
                 return;
             }
 
 
             if (checkTeacherCourseExists(newCourseName)) {
                 System.out.println("Sorry, the course is already assigned to another teacher.");
                 TeacherCentral.TeacherMenu(teacherLogUN);
                 return;
             }
 
             String teacherFileName = "Teacher " + teacherLogUN;
             String courseChoiceFile = newCourseName + ".csv";
 
             
             createFileSpecial(courseChoiceFile, "Student", "Grade", teacherFileName);
 
             FileHandler.createFile("teachersCourses.csv", teacherLogUN, newCourseName, "Teachers'usernames", "courses");
 
             TeacherCentral.TeacherMenu(teacherLogUN);
         } catch (IOException e) {
             System.out.println("An error occurred while performing file operations: " + e.getMessage());
             e.printStackTrace();
         }
     }
 
 
 
     //Add students a course, the teacher must be enrolled in that course
     public static void teacherAddStuToCour(String teacherLogUN) throws IOException {
         File file = new File("teachersCourses.csv");
         if (!file.exists()) {
             System.err.println("Error: File teachersCourses.csv does not exist.");
             TeacherCentral.TeacherMenu(teacherLogUN);
         } else {
             checkTeacher(teacherLogUN);
             String[] data = ReadCol(0, "studentsInfo.csv", ",");
             assert data != null;
             for (String datum : data) {
                 System.out.println(datum);
 
             }
 
             System.out.println("\nEnter which student(enter no if you want no students added)");
             String studentChoice = scanner.nextLine();
 
             TeacherCreate.studentChoice = studentChoice;
 
 
             String teacherFileName = "Teacher " + teacherLogUN;
             String courseChoiceFile = getCourseChoice() + ".csv";
             if (studentChoice.equals("no")) {
                 createFileSpecial(courseChoiceFile, "Student", "Grade", teacherFileName);
                 TeacherCentral.TeacherMenu(teacherLogUN);
             }else{
                 createFileUnique(courseChoiceFile,studentChoice,"Student","Grade",teacherFileName);
                 createFile("studentsCourses.csv",studentChoice,getCourseChoice(),"Students","Courses");
                 TeacherCentral.TeacherMenu(teacherLogUN);
             }
 
         }
     }
 
     //Assign grades to students in courses, the teacher must be enrolled in that course
     public static void stuAddGrade(String teacherLogUN) throws IOException {
         File file = new File("teachersCourses.csv");
         if (!file.exists()) {
             System.err.println("Error: File teachersCourses.csv does not exist.");
             TeacherCentral.TeacherMenu(teacherLogUN);
         } else {
             checkTeacher(teacherLogUN);
             String[] data = ReadCol(0, "studentsInfo.csv", ",");
             assert data != null;
             for (String datum : data) {
                 System.out.println(datum);
             }
 
             System.out.println("\nEnter which student");
             String studentChoice = scanner.nextLine();
 
             TeacherCreate.studentChoice = studentChoice;
 
             String courseChoiceFile = getCourseChoice() + ".csv";
             File fileCourseChoice = new File(courseChoiceFile);
             if (!fileCourseChoice.exists()) {
                 System.err.println("Error: The file doesn't exist. Please wait until a teacher is added to a course.");
                 return;
             }
 
 
 
             System.out.println("Enter the grade");
             String gradeChoice = scanner.nextLine();
 
 
             if (updateGradeForStudent(studentChoice, gradeChoice, fileCourseChoice)) {
                 System.out.println("Grade added successfully for student: " + studentChoice);
             } else {
                 System.err.println("Error: Student not found in the file.");
             }
 
             TeacherCentral.TeacherMenu(teacherLogUN);
         }
     }
 
     //to update the grade for the student in the file
     public static boolean updateGradeForStudent(String studentName, String newGrade, File file) throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader(file));
         StringBuilder stringBuilder = new StringBuilder();
         String line;
         boolean found = false;
 
         while ((line = reader.readLine()) != null) {
             if (line.startsWith(studentName)) {
                 stringBuilder.append(studentName).append(",").append(newGrade).append("\n");
                 found = true;
             } else {
                 stringBuilder.append(line).append("\n");
             }
         }
 
         reader.close();
 
         if (found) {
             FileWriter writer = new FileWriter(file);
             writer.write(stringBuilder.toString());
             writer.close();
         }
 
         return found;
     }
 
 
 
 
 
 }
 
 