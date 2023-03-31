import java.sql.*;
import java.util.Scanner;

public class CommunityMember extends User {
 private String volunteerStatus;

 //constructor
 public CommunityMember() {
  System.out.print("Are you SURE you want to volunteer?");
  this.volunteerStatus = sc.nextLine().trim().toLowerCase();
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
