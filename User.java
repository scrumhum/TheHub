import java.sql.*;
import java.util.Scanner;

public class User implements UserInterface {
    public String firstName, lastName, username, password, gender, email, bio, location;

    public int phoneNumber;
    public Object profileImg;
    public int authorizationLevel;
    Scanner sc = new Scanner(System.in);
    DBConnect connect = new DBConnect();

    public  static Connection conn = null;
    Statement st = null;

    private static final String URL = "jdbc:mysql://localhost:3306/thehub";
    private static final String USER = "root";
    private static final String PASS = "TheHub";


    //TODO update this class to correctly obtain auth level from user and see if I need to add new code for adding volunteer status to DB.
    public User() {

        //Auth level
        System.out.print("Joining as Gathering Manager? Press 1.\nJoining as a Community Member? Press 2.");
        if (sc.nextInt() == 2) {
            this.authorizationLevel = 1;
            System.out.println("Welcome Community Member!");
        } else if (sc.nextInt() == 1) {
            this.authorizationLevel = 0;
            System.out.println("Welcome Gathering Manager!");
        } else {
            System.out.println("LIKE I SAID, enter either a 1 or a 2. NO FUNNY STUFF");
        }
        sc.nextLine(); //Don't delete this.


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
        System.out.print("Enter your Gender: ");
        this.gender = sc.nextLine().trim().toLowerCase();
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

        System.out.print("Enter a short Biography: ");
        this.bio = sc.nextLine().trim().toLowerCase();
        System.out.print("Enter your location: ");
        this.location = sc.nextLine().trim().toLowerCase();
        System.out.print("Enter your Phone Number(only digits): ");
        try {
            this.phoneNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        writeProfile();


    }


    //validates email formatting
    public boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void writeProfile() {
        try {

            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            st = conn.createStatement();
            System.out.println("Writing profile to database...");
            String sql = "INSERT INTO profiles (firstname, lastname, username, password, gender, email, bio, location, phone_number, auth_level) " +
                    "VALUES ('" + this.firstName + "', '" + this.lastName + "', '" + this.username + "', '" + this.password + "', '" + this.gender + "', '" + this.email + "', '" + this.bio + "', '" + this.location + "', '" + this.phoneNumber + "', '" + this.authorizationLevel + "');";
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

    // get username

    public static String getUserName(String phoneNumber) {
        String username = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT username FROM profiles WHERE phone_number=?");
            st.setString(1, phoneNumber);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                username = rs.getString(1);
                System.out.println("Record retrieved successfully: " + username);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return username;

    }

    // get password

    public static String getPassword(String username) {
        String password = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT password FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                password = rs.getString(1);
                System.out.println("Record retrieved successfully: " + password);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return password;
    }

    // get first name

    public static String getFirstName(String username) {
        String firstName = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT firstname FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                firstName = rs.getString(1);
                System.out.println("Record retrieved successfully: " + firstName);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return firstName;
    }

    // get last name

    public static String getLastName(String username) {
        String lastName = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT lastname FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                lastName = rs.getString(1);
                System.out.println("Record retrieved successfully: " + lastName);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return lastName;
    }

    // get user id

    public static int getUserID(String username) {
        int userID = 0;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT id FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                userID = rs.getInt(1);
                System.out.println("Record retrieved successfully: " + userID);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return userID;
    }

    // get gender

    public static String getGender(String username) {
        String gender = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT gender FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                gender = rs.getString(1);
                System.out.println("Record retrieved successfully: " + gender);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return gender;
    }

    // get email

    public static String getEmail(String username) {
        String email = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT email FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                email = rs.getString(1);
                System.out.println("Record retrieved successfully: " + email);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return email;
    }

    // get bio

    public static String getBio(String username) {
        String bio = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT bio FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                bio = rs.getString(1);
                System.out.println("Record retrieved successfully: " + bio);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return bio;
    }

    // get phone number

    public static String getPhone(String username) {
        String phoneNumber = null;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT phone_number FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                phoneNumber = rs.getString(1);
                System.out.println("Record retrieved successfully: " + phoneNumber);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return phoneNumber;
    }

    //STILL DOES NOT FUNCTION
    public int getAuthorizationLevel(String username) {
        int authorization = 0;
        try {
            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement st = conn.prepareStatement("SELECT authorization FROM profiles WHERE username=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                authorization = rs.getInt(1);
                System.out.println("Record retrieved successfully: " + authorization);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
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
        return authorization;
    }

    // get profile image

    public Object getImage(String username) {
        return this.profileImg;
    }


    public String setFirstName() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your updated First Name: ");
            this.firstName = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET firstname='" +
                    this.firstName + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public String setLastName() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your updated Last Name: ");
            this.lastName = sc.nextLine();



            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET lastname='" +
                    this.lastName + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public String setUserName() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your new Username: ");
            this.username = sc.nextLine();



            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET username='" +
                    this.username + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public String setPassword() {
        try {

            connect.dbConnect();


            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your updated Password: ");
            this.password = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET password='" +
                    this.password + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public String setGender() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your Gender: ");
            this.gender = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET gender='" +
                    this.gender + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public String setEmail() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Username: ");
            this.username = sc.nextLine();
            System.out.print("Enter your updated Email: ");
            this.email = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET email='" +
                    this.email + "' WHERE username='" + this.username + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public String setBio() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your updated Biography: ");
            this.bio = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET bio='" +
                    this.bio + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return null;
    }


    public int setPhone() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your updated Phone Number: ");
            try {
                this.phoneNumber = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql = "UPDATE profiles SET phone_number='" +
                    this.phoneNumber + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql);
            System.out.println("Record adjusted successfully");
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
        return 0;
    }


    public String getFirstName() {
        return null;
    }


    public String getLastName() {
        return null;
    }


    public String getUserName() {
        return null;
    }


    public String getPassword() {
        return null;
    }


    public static int getUserID() {
        return 0;
    }


    public String getGender() {
        return null;
    }


    public String getEmail() {
        return null;
    }


    public String getBio() {
        return null;
    }


    public int getAuthorizationLevel() {
        return 0;
    }


    public String getPhone() {
        return null;
    }

    //Images not utilized yet

    public Object setImage() {
        return null;
    }
}