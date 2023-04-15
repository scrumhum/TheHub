
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
        //private ArrayList<User> users;
        //private ArrayList<Event> events;
        //private ArrayList<ForumPost> posts;
        public String firstName, lastName, username, password, email;

        public long phoneNumber;
        public Object profileImg;
        public int authorizationLevel;
        Scanner sc = new Scanner(System.in);
        DBConnect connect = new DBConnect();

        public  static Connection conn = null;
        Statement st = null;

        static final String URL = "jdbc:mysql://192.168.72.21:3306/";

        //User log in for DB
        static final String USER = "TheHub";
        static final String PASS = "$TheHub2023$";

        public Admin() {
            this.authorizationLevel = 0;
            System.out.print("Enter your First Name: ");
            this.firstName = sc.nextLine().trim().toLowerCase();
            System.out.print("Enter your Last Name: ");
            this.lastName = sc.nextLine().trim().toLowerCase();
            System.out.print("Enter your Username: ");
            // TODO need to check for duplicate names in DB before entering.
            this.username = sc.nextLine().trim().toLowerCase();
            System.out.print("Enter your Password: ");
            // TODO need to hash passwords before storing
            this.password = sc.nextLine().trim().toLowerCase();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine().trim().toLowerCase();

            //validates email formatting
            if (isValidEmail(email)) {
                System.out.println("Valid email");
            }

            //validates email formatting
            if (!isValidEmail(email)) {
                System.out.println("Invalid email. Please enter a valid email:");
                this.email = sc.nextLine().trim().toLowerCase();
            }


            System.out.print("Enter your Phone Number(only digits): ");
            while (true) {
                long input;
                try {
                    input = sc.nextLong();
                    this.phoneNumber = input;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer.");
                }
            }
            sc.nextLine();

            //Write to DB
            writeProfile();

        }

    public void writeProfile() {
        try {
            System.out.println("Trying to connect");
            DBConnect connect = DBConnect.getInstance();
            connect.dbConnect();
            conn = DriverManager.getConnection(URL, USER, PASS);
            st = conn.createStatement();
            String sql = "USE thehub;";
            st.executeUpdate(sql);
            System.out.println("Connection Successful!");
            System.out.println("Writing profile to database...");
            String sql2 = "INSERT INTO profiles (firstname, lastname, username, password, email, phone_number, auth_level) " +
                    "VALUES ('" + this.firstName + "', '" + this.lastName + "', '" + this.username + "', '" + this.password + "', '" + this.email + "','" + this.phoneNumber + "', '" + this.authorizationLevel + "');";
            st.executeUpdate(sql2);
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


    public boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

        public boolean login(String username, String password) {
            if (this.username.equals(username) && this.password.equals(password)) {
                return true;
            }
            return false;
        }

        public void approveUser(User user) {
            //user.setApproved(true);
            System.out.println("User " + user.getUserName() + " has been approved.");
        }


        /*
        // TODO Need to create "setApproved" method
        public void approveEvent(Event event) {
            event.setApproved(true);
            System.out.println("Event " + event.getName() + " has been approved.");
        }*/

        // have to import event from database
        //TODO Plug in DB connection
        /*
        public void approvePost(ForumPost post) {
            post.setApproved(true);
            System.out.println("Post " + post.getTitle() + " has been approved.");
        }*/

        /*
        //TODO Plug in DB Connection
        public void deleteUser(User user) {
            users.remove(user);
            System.out.println("User " + user.getUserName() + " has been deleted.");
        }*/
    }