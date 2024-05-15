/*
AdminView.java

viewing all student accounts
viewing all teacher accounts
viewing all courses

 */



 import java.io.IOException;

 public class AdminView extends FileHandler {
 
 
     //viewing all student accounts
     public static void adminViewStudents() throws IOException {
 
         String [] data= ReadCol(0,"studentsInfo.csv",",");
 
         //Dereference of 'data' may produce 'NullPointerException' so we make it not null
         // (IntelliJ Community Edition suggestion)
 
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
         AdminCentral.AdminMenu();
     }
 
     public static void adminViewTeachers() throws IOException {
         String [] data= ReadCol(0,"teachersInfo.csv",",");
 
         //Dereference of 'data' may produce 'NullPointerException' so we make it not null
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
         AdminCentral.AdminMenu();
     }
 
     public static void adminViewCourses() throws IOException {
         String [] data= ReadCol(0,"coursesInfo.csv",",");
 
         //Dereference of 'data' may produce 'NullPointerException' so we make it not null
         assert data != null;
         for (String datum : data) {
             System.out.println(datum);
         }
 
         AdminCentral.AdminMenu();
     }
 
 
 }
 