import java.sql.Statement;
import java.util.Scanner;

public class User implements UserInterface {
    public String firstName, lastName, username, password, gender, email, bio, location;

    //DON'T CHANGE THIS TO AN INT, IT WILL CAUSE A BUG IN THE SCANNER
    public String phoneNumber;
    public Object profileImg;
    public int authorizationLevel;
    Scanner sc = new Scanner(System.in);
    DBConnect connect = new DBConnect();
    Statement st = null;

    public User() {

        //This is only a placeholder, as I think that it might be better to create an enum that handles role assignment.
        //Also, it glitches out if you select 2 for Gathering Manager. :(
        /*System.out.print("Joining as Community Member? Press 1.\nJoining as a Gathering Manager? Press 2.");
        if (sc.nextInt() == 1) {
            this.authorizationLevel = 0;
        } else if (sc.nextInt() == 2) {
            this.authorizationLevel = 1;
        } else {
            System.out.println("LIKE I SAID, enter either a 1 or a 2. NO FUNNY STUFF");
        }
        sc.nextLine();*/

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
        // TODO Need to check for duplicates in the DB
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
        System.out.print("Enter your Phone Number: ");
        this.phoneNumber = sc.nextLine().trim().toLowerCase();

        writeProfile();


    }

    //validates email formatting
    public boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void writeProfile() {
        try {

            connect.dbConnect();


            System.out.println("Writing profile to database...");
            String sql = "INSERT INTO profiles (firstname, lastname, username, password, gender, email, bio, location, phone_number) " +
                    "VALUES ('" + this.firstName + "', '" + this.lastName + "', '" + this.username + "', '" + this.password + "', '" + this.gender + "', '" + this.email + "', '" + this.bio + "', '" + this.location + "', '" + this.phoneNumber + "');";
            st.executeUpdate(sql);
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

    @Override
    public String setFirstName() {
        try {

            connect.dbConnect();

            System.out.print("Enter your First Name: ");
            this.firstName = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET firstname='" +
                    this.firstName + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String setLastName() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Last Name: ");
            this.lastName = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET lastname='" +
                    this.lastName + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String setUserName() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Username: ");
            this.username = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();


            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET username='" +
                    this.username + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String setPassword() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Password: ");
            this.password = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET password='" +
                    this.password + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String setGender() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Gender: ");
            this.gender = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET gender='" +
                    this.gender + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String setEmail() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();
            System.out.print("Enter your Username: ");
            this.username = sc.nextLine();

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET email='" +
                    this.email + "' WHERE username='" + this.username + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String setBio() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Biography: ");
            this.bio = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET bio='" +
                    this.bio + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int setPhone() {
        try {

            connect.dbConnect();

            System.out.print("Enter your Phone Number: ");
            this.phoneNumber = sc.nextLine();
            System.out.print("Enter your Email: ");
            this.email = sc.nextLine();

            //TODO need to update clause to reflect user's current log in or something like that.
            String sql2 = "UPDATE profiles SET phone_number='" +
                    this.phoneNumber + "' WHERE email='" + this.email + "';";

            st.executeUpdate(sql2);
            System.out.println("Record adjusted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Images not utilized yet
    @Override
    public Object setImage() {
        return null;
    }
}