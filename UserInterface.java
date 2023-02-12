public interface UserInterface {

    //AT THIS POINT, NONE OF MY SETTERS WORK!!!

    String setFirstName();

    String setLastName();

    String setUserName();

    String setPassword();

    String setGender();

    String setEmail();

    String setBio();

    int setPhone();

    Object setImage();



    String getFirstName();

    String getLastName();

    String getUserName();

    String getPassword();

    //int getUserID(); //Needs to be updated to get primary Key

    String getGender();

    String getEmail();

    String getBio();

    int getAuthorizationLevel();

    String getPhone();

    Object getImage();

}
