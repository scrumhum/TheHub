import java.sql.*;
import java.util.Scanner;

public class CommunityMember extends User {

 private String volunteerStatus;

 Scanner sc = new Scanner(System.in);
 DBConnect connect = new DBConnect();

 public  static Connection conn = null;
 Statement st = null;

 static final String URL = "jdbc:mysql://192.168.72.21:3306/";

 //User log in for DB
 static final String USER = "TheHub";
 static final String PASS = "$TheHub2023$";

 //constructor
 public CommunityMember() {

 }


 // Used to create private events
 public void createPrivateEvent(String EventName){
  //possibly importing some functionality from the Event Class
 }

 public void checkCalendar() {
  //this will be code to see the calendar, unsure of how to implement this. Waiting to see how events class is put together.
 }

/*
     //set volunteer status
     public void setVolunteerStatus(boolean volunteer) {
        this.volunteerStatus = volunteer;
     }


    // get volunteer status
    public boolean getVolunteerStatus() {
       return this.volunteerStatus;
     }


     // static method to get static count value
    /* public static int getComMemberCount() {
        return comMemberCount;
     }*/



}
