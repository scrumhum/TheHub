     private class CommunityMember extends User
{
    //should be inherting all these from the main User class
    /*private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int userID; //Will be created automatically after sign up
    private String gender;
    private String email;
    private String bio;
    private int phoneNumber;
    private Object profileImg;
    */
    private boolean volunteerStatus;
    

    //private static int comMemberCount = 0; // number of objects in memory, keeps track of all users (Maybe also include this in the main User class)


     //constructer 
     public CommunityMember(String first, String last, String name, String pass, int id, String gender, String email, String bio, int phone, Object img, boolean volunteer)
     {
        firstName = first;
        lastName = last;
        username = name;
        password = pass;
        userID = id;
        gender = gender;
        email = email;
        bio = bio;
        phoneNumber = phone;
        profileImg = img;
        
        volunteerStatus = volunteer;

        //comMemberCount++; // increment static count of Users
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
     
     //set volunteer status
     public boolean setVolunteerStatus(boolean volunteer)
     {
        this.volunteerStatus = volunteer;
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


    // get volunteer status
    public boolean getVolunteerStatus
     {
        this.volunteerStatus;
     }


     // static method to get static count value
     public static int getComMemberCount()              
     {                                         
        return count;                          
     }

}
