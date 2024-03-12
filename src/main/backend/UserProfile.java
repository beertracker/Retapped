public class UserProfile {

    //global fields
    private String username; //username for the account; each is unique
    private String password; //case sensitive password for the account


    //default constructor
    //creates a new user profile with null values
    //values will be changes later
    public userProfile() {
        this.username = null;
        this.password = null;
    }

    //constructor for the profile
    //creates a profile with an input unique username and a password
    public userProfile(String username, String password) {

        //check to make sure the input is not null
        //then set the username and password
        if(username != null && password != null){
            this.username = username;
            this.password = password;
        }

        //password requirements?

    }

    //getter for the username
    public String getUsername(){
        return username;
    }

    //check to see if the password entered is the correct password
    public boolean isPasswordCorrect(String inputPassword){


        return false;
    }

}
