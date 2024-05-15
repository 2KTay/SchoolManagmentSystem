/*
User.java

Abstract Class
Welcoming the user once they are logged in

it is the parent class of TeacherCentral, StudentCentral, and AdminCentral
 */

 abstract class User {
    protected String name;


    //Constructor
    public User(String name){
        this.name=name;

    }

    //WelcomeMessageFunction
    public abstract void welcomeMessage();


    //gets the Name
    public String getName() {
        return name;
    }

    //sets the Name
    public void setName(String newName) {
        name = newName;
    }

}
