    private class User
{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int userID; //Will be created automatically after sign up
    private String gender;
    private String email;
    private String bio;
    private String location;
    private int phoneNumber;
    private Object profileImg;
    private boolean adminStatus; //to authenticate. Not sure if this is entirely necessary
    

    //private static int comMemberCount = 0; // number of objects in memory, keeps track of all users


     //constructer 
     public User(String first, String last, String name, String pass, int id, String gender, String email, String bio,String location, int phone, Object img)
     {
        firstName = first;
        lastName = last;
        username = name;
        password = pass;
        userID = id;
        gender = gender;
        email = email;
        bio = bio;
        location = location;
        phoneNumber = phone;
        profileImg = img;

        //count++; // increment static count of Users
        //System.out.printf( "User constructor: %s %s; count = %d\n",
          // firstName, lastName, count);
     }

     //This maybe removes the user from the count?
     // subtract 1 from static count when garbage
     // collector calls finalize to clean up object;
     // confirm that finalize was called
     /*protected void finalize()
     {
        count--; // decrement static count of users
        System.out.printf( "User finalizer: %s %s; count = %d\n",
           firstName, lastName, count );
     }*/

   // set first name
     public String setFirstName(String firstName)
     {
        this.firstName = firstName;
     }

     // set last name
     public String setLastName(String lastName)
     {
        this.lastName = lastName;
     }

    // set user name
     public String setUserName(String name)
     {
        this.username = name;
     }

     // set password
     public String setPassword(String password)
     {
        this.password = password;
     }

     // set gender
     public String setGender(String gender)
     {
        this.gender = gender;
     }
     
    // set email
     public String setEmail(String email)
     {
        this.email = email;
     }
     
     // set bio
     public String setBio(String bio)
     {
        this.bio = bio;
     }
     
     //set phone number
     public String setPhone(String phone)
     {
        this.phoneNumber = phone;
     }
     
     //set profile image
     public String setImage(String img)
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
        return username;
     }

     // get gender
     public String getGender()
     {
        this.gender;
     }
     
     // get email
     public String getEmail()
     {
        this.email;
     }
     
     // get bio
     public String getBio()
     {
        this.bio;
     }
     
     // get phone number
     public String getPhone()
     {
        this.phoneNumber;
     }
     
     // get profile image
     public Object getImage()
     {
        this.profileImg;
     }

     // static method to get static count value
     public static int getMemberCount()              
     {                                         
        return count;                          
     }

    public void setApproved(boolean b) {
    }
}
