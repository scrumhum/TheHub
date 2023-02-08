import java.util.Scanner;

public class User implements UserInterface {
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public int userID; //Will be created automatically after sign up
    public String gender;
    public String email;
    public String bio;

    public String location;
    public int phoneNumber;
    public Object profileImg;

    //public boolean adminStatus; //to authenticate. Not sure if this is entirely necessary
    

    private static int count = 0; // number of objects in memory, keeps track of all users

    public User() {
        
    }

    public void profileCreate() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your First name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter your Last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("Enter a Username: ");
        this.username = scanner.nextLine();
        System.out.println("Enter a Password:  ");
        this.password = scanner.nextLine();
        System.out.println("Enter a User ID: "); //test of concept, won't be user generated
        this.userID = scanner.nextInt();
        System.out.println("Enter your gender:  ");
        this.gender = scanner.nextLine();
        System.out.println("Enter your email address:  ");
        this.email = scanner.nextLine();
        System.out.println("Enter a short bio:  ");
        this.bio = scanner.nextLine();
        System.out.println("Where are you located?");
        this.location = scanner.nextLine();
        System.out.println("Whats your Phone number?");
        this.phoneNumber = scanner.nextInt();

        User person = new User();
        User.profileCreate(person);
        System.out.println(person.getEmail());

    }

    // get username
     public String getUserName() {
        return username;
     }

     // get password
     public String getPassword() {
        return password;
     }

    // get first name
     public String getFirstName() {
        return firstName;
     }

     // get last name
     public String getLastName() {
        return lastName;
     }
     
     // get user id
     public int getUserID() {
        return userID;
     }

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
     
     // get profile image
     public Object getImage() {
        return this.profileImg;
     }

     // static method to get static count value
     public static int getMemberCount() {
        return count;                          
     }

    @Override
    public String setFirstName() {
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
