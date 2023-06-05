# 📚 COMP1020_Group5_MedCare
MedCare is a robust and user-friendly medical booking management application implemented using object-oriented programming (OOP) concepts in Java. The graphical user interface (GUI) is designed using Java Swing, and SQLite is used as the database. MedCare aims to provide a comprehensive solution that effectively tackles obstacles faced by patients, medical professionals, and healthcare systems. This project was developed during the course "COMP1020: Object-Oriented Programming and Data Structure." 

## System Users/Actors:
The actors include the following: 
* Patients
* Doctors
* Administrator

## Use Cases:

### Patients:
* ❏ Book appointment based on desired department, date, time, and declare symptoms
* ❏ Receive notification about successful booking and appointment information.
* ❏ Cancel upcoming appointments if necessary
* ❏ Provide feedback for past appointment
* ❏ Access medical records, review the appointment result

### Doctors:
* ❏ View upcoming and past appointment
* ❏ Update medical records for patients
* ❏ View all feedback and ratings received for their appointments 

### Administrator:
* ❏ Add and Delete doctors' daily available timeslots
* ❏ Manage past and upcoming appointments for all doctors
* ❏ Cancel upcoming appointment
* ❏ View all appointment feedback and ratings


## How to Run
1- Install these:
 * [Java SE Development Kit 20 (JDK 20)](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
 * After installing JDK 20, install [NetBeans IDE](https://netbeans.apache.org/download/index.html)
 * Library: [AbsoluteLayout-RELEASE170](https://jar-download.com/maven-repository-class-search.php?search_box=+absolute+layout)
 * Library: [jcalendar-1.4](https://toedter.com/jcalendar/)
 * Library: [sqlite-jdbc-3.7.2](http://www.java2s.com/Code/Jar/s/Downloadsqlitejdbc372jar.htm)
 * (Optional) [SQLiteStudio](https://sqlitestudio.pl/). This allow viewing and managing the sqlite database file.
 
2- Open NetBeans IDE. Click on File -> Open Project and browse to the downloaded MedCare project. 

3- To use the database, please download our database for MedCare at this link [Database](https://github.com/chiphan1110/COMP1020_Group5_MedCare/tree/main/src/data) and insert its directory everytime there is a 'DiverManage.getConnection()' method calling in the code. Our default directory is '"jdbc:sqlite:C:\\sqlite\\db\\test.sqlite"'.

4- Now the project are ready to run! You can try all MedCare features by firstly choose the Register package and run the 'Login.java' file. 
Note that as patients, users can signup and create their own username and password. As Admin and Doctor, please refer to the assigned username and password in the database. 

