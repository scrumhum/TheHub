
import java.sql.*;
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

        public static Connection conn = null;
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

    public boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
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


    //TODO Not quite sure how this is going to work, needs refactoring
    public void approveUser(String adminName, String adminPass, String username) {
            boolean isAuthenticated = authenticate(adminName, adminPass);
            if (isAuthenticated) {
                System.out.println("Valid log in!");
                //user.setApproved(true);
                System.out.println("User " + user.getUserName() + " has been approved.");
            } else {
                System.out.println("Nice try! Give me a valid login...");
            }
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

    public boolean authenticate(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean foundMatch = false;

        try {
            System.out.println("Trying to connect");
            DBConnect connect = DBConnect.getInstance();
            connect.dbConnect();
            conn = DriverManager.getConnection(URL, USER, PASS);
            st = conn.createStatement();
            String sql = "USE thehub;";
            st.executeUpdate(sql);
            System.out.println("Connection Successful!");
            // Prepare the statement
            String sql2 = "SELECT * FROM profiles WHERE username = ? AND password = ? AND auth_level = '0';";
            stmt = conn.prepareStatement(sql2);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Check if the query returned a match
            if (rs.next()) {
                foundMatch = true;
            }

            // Clean up
            /*rs.close();
            stmt.close();
            conn.close();*/
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Result is:" + foundMatch);
        return foundMatch;
    }

        //TODO Plug in DB Connection
        public String deleteUser() {
            String loserUser = username;
                try {
                    connect.dbConnect();
                    System.out.print("Enter your Username");
                    this.username = sc.nextLine();
                    System.out.print("Enter your password");
                    this.password = sc.nextLine();

                    String sql = "SELECT * FROM profiles WHERE username = '" +
                            this.firstName + "' WHERE password ='" + this.password + "';";

                    st.executeUpdate(sql);
                    System.out.println("Admin Approved");
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
                System.out.println("User " + loserUser + " has been deleted.");
                return null;
        }
    }