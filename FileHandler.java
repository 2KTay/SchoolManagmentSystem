/*
FileHandler.java

the biggest of all the files
Every function to either create, delete, view or check is here

files with Create will usually create a file with the added contents

files with delete will usually either delete a file or delete a row

files with View will view a column

files with Check is a checker, trying to find it


 */



 import java.io.*;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Scanner;
 
 
 public class FileHandler {
     static Scanner scanner = new Scanner(System.in);
     static String courseChoice;
 
     public static String getCourseChoice() {
         return courseChoice;
     }
 
     //used in teacherAddStuToCou from TeacherCreate
     public static void createFileUnique(String fileName, String a, String first, String second, String third) {
 
         try {
             File f = new File(fileName);
             FileWriter myWriter = new FileWriter(fileName, true);
 
             if (f.length() == 0) {
 
                 myWriter.write(first + "," + second + "," + third + "\n");
                 myWriter.write(a + "\n");
                 myWriter.close();
             } else {
                 myWriter.write(a + "\n");
                 myWriter.close();
             }
 
         } catch (IOException e) {
             System.out.println("An error occurred.");
 
         }
 
     }
 
     //making teacherCourses.csv
     public static void createFile(String fileName, String a, String b, String first, String second) {
 
         try {
             File f = new File(fileName);
             FileWriter myWriter = new FileWriter(fileName, true);
 
             if (f.length() == 0) {
 
                 myWriter.write(first + "," + second + "\n");
                 myWriter.write(a + "," + b + "\n");
                 myWriter.close();
             } else {
                 myWriter.write(a + "," + b + "\n");
                 myWriter.close();
             }
 
         } catch (IOException e) {
             System.out.println("An error occurred.");
 
         }
 
     }
 
 
     //used in adminCreateCourse
     public static void createFile(String fileName, String a, String first) {
 
         try {
             File f = new File(fileName);
             FileWriter myWriter = new FileWriter(fileName, true);
 
             if (f.length() == 0) {
                 // Open file in append mode
                 myWriter.write(first + "\n");
             }
             myWriter.write(a + "\n");
             myWriter.close();
 
         } catch (IOException e) {
             System.out.println("An error occurred.");
 
         }
 
     }
 
 
     //special case for
     // A course cannot exist without a teacher being assigned to it, however, it can exist without any students
     public static void createFileSpecial(String fileName, String first, String second, String third) {
 
         try {
             File f = new File(fileName);
             FileWriter myWriter = new FileWriter(fileName, true);
 
             if (f.length() == 0) {
 
                 myWriter.write(first + "," + second + "," + third + "\n");
             }
 
             myWriter.close();
 
         } catch (IOException e) {
             System.out.println("An error occurred.");
 
         }
 
     }
 
     //overloaded createFileSpecial 
     //(part of the createFile family as I have to rename due to some having same number of same data type parameters)
     public static void createFileSpecial(String fileName, String first, String second) {
 
         try {
             File f = new File(fileName);
             FileWriter myWriter = new FileWriter(fileName, true);
 
             if (f.length() == 0) {
 
                 myWriter.write(first + "," + second + "\n");
             }
 
             myWriter.close();
 
         } catch (IOException e) {
             System.out.println("An error occurred.");
 
         }
 
     }
 
 
     //overloaded method, for creatingStudentAccount and for creatingTeacherAccount
     public static void createFile(String fileName, String a, String b, String c, String first, String second, String third, String message) {
 
         try {
             File f = new File(fileName);
             FileWriter myWriter = new FileWriter(fileName, true);
             Scanner scanner = new Scanner(f);
 
             if (f.length() == 0) {
 
                 myWriter.write(first + "," + second + "," + third + "\n");
                 myWriter.write(a + "," + b + "," + c + "\n");
                 myWriter.close();
             } else {
 
                 boolean bExists = false;
                 while (scanner.hasNextLine()) {
                     String line = scanner.nextLine();
                     String[] parts = line.split(",");
                     if (parts.length >= 2 && parts[1].equals(b)) {
                         bExists = true;
                         break;
                     }
                 }
                 scanner.close();
                 if (bExists) {
                     System.out.println("Username '" + b + "' already exists." + message);
                 } else {
                     myWriter.write(a + "," + b + "," + c + "\n");
                 }
                 myWriter.close();
             }
 
         } catch (IOException e) {
             System.out.println("An error occurred.");
         }
     }
 
 
     //used in teacherEnrollCourse from TeacherCreate
     public static boolean checkTeacherCourseExists(String newCourseName) throws IOException {
         File file = new File("teachersCourses.csv");
         if (file.exists()) {
             String[] teachersCoursesData = ReadCol(1, "teachersCourses.csv", ",");
             if (teachersCoursesData != null) {
                 for (String teacherCourse : teachersCoursesData) {
                     if (teacherCourse.equals(newCourseName)) {
                         return true;
                     }
                 }
             }
         }
         return false;
         }
 
 
     //overloaded method of ReadCol
     public static String[] ReadCol(int col, String filepath, String delimiter) {
         String data[];
         String currentLine;
         ArrayList<String> colData = new ArrayList<String>();
 
         try {
             FileReader fr = new FileReader(filepath);
             try (BufferedReader br = new BufferedReader(fr)) {
                 while ((currentLine = br.readLine()) != null) {
                     data = currentLine.split(delimiter);
                     colData.add(data[col]);
                 }
             }
         } catch (Exception e) {
             System.out.println(e);
             return null;
         }
         return colData.toArray(new String[0]);
 
     }
 
 
     //overloaded method of ReadCol
     public static String[] ReadCol(String username, String filepath, String delimiter) {
         ArrayList<String> colData = new ArrayList<>();
 
         try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
             String currentLine;
             while ((currentLine = br.readLine()) != null) {
                 String[] data = currentLine.split(delimiter);
                 if (data.length > 0 && data[0].equals(username)) {
                     if (data.length > 1) {
                         colData.add(data[1]);
                     } else {
 
                         colData.add("");
                     }
                 }
             }
         } catch (Exception e) {
             System.out.println(e);
             return null;
         }
         return colData.toArray(new String[0]);
     }
 
 
 
 
     //removeRecord used in AdminDelete, StudentDelete and TeacherDelete
     public static void removeRecord(String fileName, String nameToRemove, int columnNumber) {
         try {
             File inputFile = new File(fileName);
 
 
             ArrayList<String> lines = new ArrayList<>();
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             String currentLine;
             while ((currentLine = reader.readLine()) != null) {
                 lines.add(currentLine);
             }
             reader.close();
 
 
             BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
             for (String line : lines) {
                 String[] columns = line.split(",");
                 if (columns.length > columnNumber && columns[columnNumber].trim().equals(nameToRemove)) {
                     continue;
                 }
                 writer.write(line + System.lineSeparator());
             }
             writer.close();
         } catch (IOException e) {
             System.out.println("An error occurred: " + e.getMessage());
             e.printStackTrace();
         }
     }
 
     //for teacherdelete
     public static void removeRecordTeach(String fileName, String nameToRemove, String courseName) {
         try {
             File inputFile = new File(fileName);
 
             ArrayList<String> lines = new ArrayList<>();
             BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             String currentLine;
             while ((currentLine = reader.readLine()) != null) {
                 lines.add(currentLine);
             }
             reader.close();
 
 
             BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
             boolean removedOnce = false;
             for (String line : lines) {
                 String[] columns = line.split(",");
                 if (columns.length >= 2 && columns[1].trim().equals(courseName) && !removedOnce) {
                     if (columns.length > 0 && columns[0].trim().equals(nameToRemove)) {
                         removedOnce = true;
                         continue;
                     }
                 }
                 writer.write(line + System.lineSeparator());
             }
             writer.close();
         } catch (IOException e) {
             System.out.println("An error occurred: " + e.getMessage());
             e.printStackTrace();
         }
     }
 
 
     //located in AdminDelete
     public static void deleteFile(String fileName) {
         File file = new File(fileName);
         if (file.delete()) {
             System.out.println("Deleted the file: ");
         } else {
         }
     }
 
     //checks if the teacher must be enrolled in that course
     public static void checkTeacher(String name) {
             try {
 
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
 
 
                 if (teacherCourses.containsKey(name)) {
                     List<String> courses = teacherCourses.get(name);
                     System.out.println("Teacher " + name + "'s courses:" + courses);
 
 
                     System.out.println("Enter which course:");
 
                     String courseChoice = scanner.nextLine();
 
 
                     if (!courses.contains(courseChoice)) {
                         System.err.println("Error. Wrong course");
                         TeacherCentral.TeacherMenu(name);
                     } else {
 
                         FileHandler.courseChoice = courseChoice;
 
                     }
 
 
                 } else {
                     System.out.println("Teacher with username " + name + " not found.");
                     return;
                 }
             } catch (IOException e) {
                 e.printStackTrace();
                 return;
             }
         }
 
 
     //gets the studentName
     public static String getStudentName(String filePath, String usernameToFind) {
         try {
             
 
             //so a memory leak would not happen
             @SuppressWarnings("resource")
             Scanner scanner = new Scanner(new File(filePath));
 
 
             scanner.nextLine();
 
 
             while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
 
                 String[] parts = line.split(",");
 
 
                 if (parts.length == 3 && parts[1].trim().equals(usernameToFind)) {
 
                     return parts[0];
                 }
             }
 
             scanner.close();
 
         } catch (FileNotFoundException e) {
 
             System.out.println("File not found: " + filePath);
             e.printStackTrace();
         }
 
 
         return null;
     }
     }
 
 
 
 
 
 