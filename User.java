import java.util.Scanner;

public class User
{
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

    public User()
    {
        
    }

    public static void profileCreate(User person) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter a Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter a Password:  ");
        String password = scanner.nextLine();
        System.out.println("Enter a User ID: "); //test of concept, won't be user generated
        String userID = scanner.nextLine();
        System.out.println("Enter your gender:  ");
        String gender = scanner.nextLine();
        System.out.println("Enter your email address:  ");
        String email = scanner.nextLine();
        System.out.println("Enter a short bio:  ");
        String bio = scanner.nextLine();
        System.out.println("Where are you located?");
        String location = scanner.nextLine();
        System.out.println("Whats your Phone number?");
        String phoneNumber = scanner.nextLine();

    }

   // set first name
     public void setFirstName(String firstName)
     {
        this.firstName = firstName;
     }

     // set last name
     public void setLastName(String lastName)
     {
        this.lastName = lastName;
     }

    // set user name
     public void setUserName(String name)
     {
        this.username = name;
     }

     // set password
     public void setPassword(String password)
     {
        this.password = password;
     }

     // set gender
     public void setGender(String gender)
     {
        this.gender = gender;
     }
     
    // set email
     public void setEmail(String email)
     {
        this.email = email;
     }
     
     // set bio
     public void setBio(String bio)
     {
        this.bio = bio;
     }
     
     //set phone number
     public void setPhone(int phone)
     {
        this.phoneNumber = phone;
     }
     
     //set profile image
     public void setImage(String img)
     {
        this.profileImg = img;
     }



    // get username
     public String getUserName()
     {
        return username;
     }

     // get password
     public String getPassword()
     {
        return password;
     }

    // get first name
     public String getFirstName()
     {
        return firstName;
     }

     // get last name
     public String getLastName()
     {
        return lastName;
     }
     
     // get user id
     public int getUserID()
     {
        return userID;
     }

     // get gender
     public String getGender()
     {
        return this.gender;
     }
     
     // get email
     public String getEmail()
     {
        return this.email;
     }
     
     // get bio
     public String getBio()
     {
        return this.bio;
     }
     
     // get phone number
     public int getPhone()
     {
        return this.phoneNumber;
     }
     
     // get profile image
     public Object getImage()
     {
        return this.profileImg;
     }

     // static method to get static count value
     public static int getMemberCount()              
     {                                         
        return count;                          
     }

}
