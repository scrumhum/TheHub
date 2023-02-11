import java.util.Scanner;

public class User implements UserInterface {
    public String firstName;
    public String lastName;
    public String username;
    public String password;


    //public int userID = 0; //This is actually not necessary and will be created when the users get added to the DB.
    //UserID will basically just be the primary key.


    public String gender;
    public String email;
    public String bio;

    public String location;
    public int phoneNumber;
    public Object profileImg;

    public int authorizationLevel;

    public User() {
        Scanner sc = new Scanner(System.in);


        //This is only a placeholder, as I think that it might be better to create an enum that handles role assignment.
        //Also it glitches out if you select 2 for Gathering Manager. :(
        System.out.print("Joining as Community Member? Press 1.\nJoining as a Gathering Manager? Press 2.");
        if (sc.nextInt() == 1) {
            this.authorizationLevel = 0;
        } else if (sc.nextInt() == 2) {
            this.authorizationLevel = 1;
        } else {
            System.out.println("LIKE I SAID, enter either a 1 or a 2. NO FUNNY STUFF");
        }
        sc.nextLine();

        System.out.print("Enter your First Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter your Last Name: ");
        this.lastName = sc.nextLine();
        System.out.print("Enter your Username: ");
        this.username = sc.nextLine();
        System.out.print("Enter your Password: ");
        this.password = sc.nextLine();

        //System.out.print("Enter your User ID: ");
        //this.userID = sc.nextInt();  // When this is left to be created by the user, it causes the program to skip over the gender section.

        System.out.print("Enter your Gender: ");
        this.gender = sc.nextLine();
        System.out.print("Enter your Email: ");
        this.email = sc.nextLine();
        System.out.print("Enter a short Biography: ");
        this.bio = sc.nextLine();
        System.out.print("Enter your location: ");
        this.location = sc.nextLine();
        System.out.print("Enter your Phone Number: ");
        this.phoneNumber = sc.nextInt();
        //sc.close(); //I believe this is necessary, but it causes a runtime error when it isn't commented out.

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
     }*/  //Should be changed to have it return the primary key.

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
     public int getPhone() {
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
