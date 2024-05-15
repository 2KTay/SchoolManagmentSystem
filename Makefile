# Makefile
# Within terminal, to create the class files required to run, please type make 
# Within terminal, to run it, please type make run

# Variables
JAVAC = javac
JAVA = java

# Targets of makeFile
all: Main.class StudentCentral.class StudentCreate.class StudentDelete.class \
     StudentView.class TeacherCentral.class TeacherCreate.class TeacherDelete.class \
     TeacherView.class AdminCentral.class AdminCreate.class AdminDelete.class \
     AdminView.class User.class FileHandler.class

Main.class: Main.java
	$(JAVAC) Main.java

StudentCentral.class: StudentCentral.java
	$(JAVAC) StudentCentral.java

StudentCreate.class: StudentCreate.java
	$(JAVAC) StudentCreate.java

StudentDelete.class: StudentDelete.java
	$(JAVAC) StudentDelete.java

StudentView.class: StudentView.java
	$(JAVAC) StudentView.java

TeacherCentral.class: TeacherCentral.java
	$(JAVAC) TeacherCentral.java

TeacherCreate.class: TeacherCreate.java
	$(JAVAC) TeacherCreate.java

TeacherDelete.class: TeacherDelete.java
	$(JAVAC) TeacherDelete.java

TeacherView.class: TeacherView.java
	$(JAVAC) TeacherView.java

AdminCentral.class: AdminCentral.java
	$(JAVAC) AdminCentral.java

AdminCreate.class: AdminCreate.java
	$(JAVAC) AdminCreate.java

AdminDelete.class: AdminDelete.java
	$(JAVAC) AdminDelete.java

AdminView.class: AdminView.java
	$(JAVAC) AdminView.java

User.class: User.java
	$(JAVAC) User.java

FileHandler.class: FileHandler.java
	$(JAVAC) FileHandler.java

clean:
	del *.class

run:
	@$(JAVA) -cp . Main
