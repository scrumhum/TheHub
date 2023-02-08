     public class CommunityMember extends User
{
    private boolean volunteerStatus;
    

    private static int comMemberCount = 0; // number of objects in memory, keeps track of all users (Maybe also include this in the main User class)


     //constructor
     public void CommunityMember() {
        /*firstName = first;
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
     }
     public void setFirstName(String firstName) {
        this.firstName = firstName;
     }

     // set last name
     public void setLastName(String lastName) {
        this.lastName = lastName;
     }

    // set user name
     public void setUserName(String name) {
        this.username = name;
     }

     // set password
     public void setPassword(String password) {
        this.password = password;
     }

     // set gender
     public void setGender(String gender) {
        this.gender = gender;
     }
     
    // set email
     public void setEmail(String email) {
        this.email = email;
     }
     
     // set bio
     public void setBio(String bio) {
        this.bio = bio;
     }
     
     //set phone number
     public void setPhone(int phone) {
        this.phoneNumber = phone;
     }
     
     //set profile image
     public void setImage(String img) {
        this.profileImg = img;
     }
     
     //set volunteer status
     public void setVolunteerStatus(boolean volunteer) {
        this.volunteerStatus = volunteer;
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


    // get volunteer status
    public boolean getVolunteerStatus() {
       return this.volunteerStatus;
     }


     // static method to get static count value
     public static int getComMemberCount() {
        return comMemberCount;
     }

}
