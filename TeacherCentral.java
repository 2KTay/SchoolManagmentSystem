/*
TeacherCentral.java file

Inheriting from abstract class of User for welcomeMessage

Having the menu with the option to choose any of the functions

 */
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class TeacherCentral extends User{


    static Scanner scanner = new Scanner(System.in);

    //constructor
    public TeacherCentral(String name) {
        super(name);
    }

    //welcomeMessage function
    @Override
    public void welcomeMessage() {
        System.out.println("\nWelcome, " + getName() + "!");
        Date date = new Date();
        System.out.println(date);
        System.out.println("\n"+getName()+"'s Menu\n");


    }

    //Having the menu with the option to choose any of the functions
    public static void TeacherMenu(String teacherLogUN) throws IOException {

        int i = 0;
        while (i<=0){
            System.out.println("Enter a choice\n" +
                            "1. Enroll in a course\n" +
                            "2. Drop a course\n" +
                            "3. Add students\n" +
                            "4. Assign Grades to students in a course\n" +
                            "5. Remove students from a course\n" +
                            "6. View all students in a course\n" +
                            "7. View all courses the teacher is enrolled in\n" +
                            "8. Log out"
                    );
            int adminChoice = scanner.nextInt();

            if (adminChoice == 1) {
                i=i+1;
                TeacherCreate.teacherEnrollCourse(teacherLogUN);

            } else if (adminChoice == 2) {
                i=i+1;
                TeacherDelete.dropCourse(teacherLogUN);


            } else if (adminChoice == 3) {
                i=i+1;
                TeacherCreate.teacherAddStuToCour(teacherLogUN);
            }else if(adminChoice==4){
                i=i+1;
                TeacherCreate.stuAddGrade(teacherLogUN);

            } else if (adminChoice == 5) {
                i = i + 1;
                TeacherDelete.removeStudentCour(teacherLogUN);


            }else if(adminChoice==6) {
                i = i + 1;
                TeacherView.viewAllStudents();

            }else if(adminChoice==7){
                i=i+1;
                TeacherView.viewAllCourses();

            }else if (adminChoice == 8) {
                i = i + 1;
                System.out.println("Teacher Logged out. Have a nice day!");
                Main.main(null);



            }else{
                System.out.println("Invalid Option. Try Again");
            }

        }
    }

}
