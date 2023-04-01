import java.sql.*;
import java.util.Scanner;

public class CommunityMember extends User {
 private String volunteerStatus;

 Scanner sc = new Scanner(System.in);
 DBConnect connect = new DBConnect();

 public  static Connection conn = null;
 Statement st = null;

 private static final String URL = "jdbc:mysql://localhost:3306/thehub";
 private static final String USER = "root";
 private static final String PASS = "TheHub";

 //constructor
 public CommunityMember() {
  System.out.print("Do you want to volunteer? Yes or No?");
  this.volunteerStatus = sc.nextLine().trim().toLowerCase();

  writeComProfile(); //TODO Fix this. I need to figure out how to get this to write to the same entry that was just created. OR We can just put all the same user profile creation stuff into this class to simplify things...
 }


 public void writeComProfile() {
  try {

   DBConnect.getInstance();
   conn = DriverManager.getConnection(URL, USER, PASS);
   st = conn.createStatement();
   System.out.println("Writing profile to database...");
   String sql = "INSERT INTO profiles (volunteer_status) " +
           "VALUES ('" + this.volunteerStatus + "');";
   st.executeUpdate(sql);
   System.out.println("Record inserted successfully");
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   if (conn != null) {
    try {
     conn.close();
    } catch (SQLException e) {
     e.printStackTrace();
    }
   }
  }
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
