import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class User implements UserInterface {
    public String firstName, lastName, username, password, gender, email, bio, location;

    //DON'T CHANGE THIS TO AN INT, IT WILL CAUSES A BUG IN THE SCANNER
    public String phoneNumber;
    public Object profileImg;
    public int authorizationLevel;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/thehub";
    private static final String USER = "root";
    private static final String PASS = "TheHub";

    public User() {
        Scanner sc = new Scanner(System.in);

        //This is only a placeholder, as I think that it might be better to create an enum that handles role assignment.
        //Also it glitches out if you select 2 for Gathering Manager. :(
        /*System.out.print("Joining as Community Member? Press 1.\nJoining as a Gathering Manager? Press 2.");
        if (sc.nextInt() == 1) {
            this.authorizationLevel = 0;
        } else if (sc.nextInt() == 2) {
            this.authorizationLevel = 1;
        } else {
            System.out.println("LIKE I SAID, enter either a 1 or a 2. NO FUNNY STUFF");
        }
        sc.nextLine();*/

        // TODO all of this needs to be cleaned before being processed. No special characters (periods are OK) and all lowercase. no trailing or leading deadspace.

        System.out.print("Enter your First Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter your Last Name: ");
        this.lastName = sc.nextLine();
        System.out.print("Enter your Username: ");
        // TODO need to check for duplicate names in DB before entering.
        this.username = sc.nextLine();
        System.out.print("Enter your Password: ");
        // TODO need to hash passwords before storing
        this.password = sc.nextLine();
        System.out.print("Enter your Gender: ");
        this.gender = sc.nextLine();
        System.out.print("Enter your Email: ");
        // TODO Need to require proper formatting and also check for duplicates in the DB
        this.email = sc.nextLine();
        System.out.print("Enter a short Biography: ");
        this.bio = sc.nextLine();
        System.out.print("Enter your location: ");
        this.location = sc.nextLine();
        System.out.print("Enter your Phone Number: ");
        this.phoneNumber = sc.nextLine();
        sc.close();

        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASS);
            st = conn.createStatement();
            Class.forName(DRIVER);
            System.out.println("Connecting to database...");

            //TODO need to write commands to get to database
            String sql = "USE thehub;";
            st.executeUpdate(sql);

            System.out.println("Writing profile to database...");
            String sql2 = "INSERT INTO profiles (firstname, lastname, username, password, gender, email, bio, location, phone_number) " +
                    "VALUES ('" + this.firstName + "', '" + this.lastName + "', '" + this.username + "', '" + this.password + "', '" + this.gender + "', '" + this.email + "', '" + this.bio + "', '" + this.location + "', '" + this.phoneNumber + "');";
            st.executeUpdate(sql2);
            System.out.println("Record inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    // get username
     public String getUserName() {
        return this.username;
     }

     // get password
     public String getPassword() {
        return this.password;
     }

    // get first name
     public String getFirstName() {
        return this.firstName;
     }

     // get last name
     public String getLastName() {
        return this.lastName;
     }
     
     // get user id
     /*public int getUserID() {
        return userID;
     }  //Should be changed to have it return the primary key.*/

     // get gender
     public String getGender() {
        return this.gender;
     }
     
     // get email
     public String getEmail() {
        return this.email;
     }
     
     // get bio
     public String getBio() {
        return this.bio;
     }
     
     // get phone number
     public String getPhone() {
        return this.phoneNumber;
     }

    public int getAuthorizationLevel() {
        return this.authorizationLevel;
    }

     // get profile image
     public Object getImage() {
        return this.profileImg;
     }

     //AT THIS POINT, NONE OF MY SETTERS WORK!!!

    @Override
    public String setFirstName() {
        this.firstName = firstName;
        return null;
    }

    @Override
    public String setLastName() {
        return null;
    }

    @Override
    public String setUserName() {
        return null;
    }

    @Override
    public String setPassword() {
        return null;
    }

    @Override
    public String setGender() {
        return null;
    }

    @Override
    public String setEmail() {
        return null;
    }

    @Override
    public String setBio() {
        return null;
    }

    @Override
    public int setPhone() {
        return 0;
    }

    @Override
    public Object setImage() {
        return null;
    }
    }