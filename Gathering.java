import javax.xml.stream.Location;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gathering {

    public String hostName, eventName, eventType, description, allAges, volunteersWanted, location;

    public int date;
    public int entryFee;

    Scanner sc = new Scanner(System.in);
    DBConnect connect = new DBConnect();

    public  static Connection conn = null;
    Statement st = null;

    static final String URL = "jdbc:mysql://192.168.72.21:3306/thehub";

    //User log in for DB
    static final String USER = "TheHub";
    static final String PASS = "$TheHub2023$";

    public Gathering() {
        System.out.print("When is the event? Enter in DDMMYYYY Format..");
        try {
            this.date = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.print("Enter your Name: ");
        this.hostName = sc.nextLine().trim().toLowerCase();
        System.out.print("What do you want to call this event?");
        this.eventName = sc.nextLine().trim().toLowerCase();
        System.out.print("What type of event is this?");
        this.eventType = sc.nextLine().trim().toLowerCase();
        System.out.print("Where is the event?");
        this.location = sc.nextLine().trim().toLowerCase();
        System.out.print("Enter a brief description of your event:");
        this.description = sc.nextLine().trim().toLowerCase();
        System.out.print("What is the entry fee? (Enter dollar amount only)");
        try {
            this.entryFee = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.print("Is this event all ages?");
        this.allAges = sc.nextLine().trim().toLowerCase();
        System.out.print("Do you want volunteers?");
        this.volunteersWanted = sc.nextLine().trim().toLowerCase();

        writeEvent();
    }

    //TODO figure out how to get these to work or just remove them.
    public void readDate() throws Exception{
        String dateFormat = "MM/DD/YYYY";
        Scanner scanner = new Scanner(System.in);
        //setDate((Date) new SimpleDateFormat(dateFormat).parse(scanner.nextLine()));
    }

    public void setDate(int date){
        System.out.print("When is the event?");
        try {
            this.date = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void writeEvent() {
        try {

            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            st = conn.createStatement();
            System.out.println("Writing event to database...");
            String sql = "INSERT INTO events (date, host, event_name, location, event_type, description, all_ages, entry_fee, volunteers) " +
                    "VALUES ('" + this.date + "', '" + this.hostName + "', '" + this.eventName + "', '" + this.location + "', '" + this.eventType + "', '" + this.description + "', '" + this.allAges + "', '" + this.entryFee + "', '" + this.volunteersWanted + "');";
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


    Location gatheringLocation = new Location() {
        @Override
        public int getLineNumber() {
            return 0;
        }

        @Override
        public int getColumnNumber() {
            return 0;
        }

        @Override
        public int getCharacterOffset() {
            return 0;
        }

        @Override
        public String getPublicId() {
            return null;
        }

        @Override
        public String getSystemId() {
            return null;
        }
    };
}
