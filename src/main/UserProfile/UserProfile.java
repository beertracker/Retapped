package com.retapped.RetappedUserProfile; // Declare a package for the user profile creation program.

import java.util.regex.Matcher; //Used to search for patterns.
import java.util.regex.Pattern; //Defines patterns.

import java.util.ArrayList; // import the ArrayList class

// Annotations to interact with the database.
@Entity
@Data
@Table(name = user)
@Table(name = friends)
// Construct a user profile based on the user's input in Main.
public class UserProfile {

    //global fields
    private String username; //username for the account; each is unique
    private String password; //case sensitive password for the account
    private ArrayList<String> friendLst = new ArrayList<String>(); // friend list in database.

    //default constructor
    //creates a new user profile with null values
    public userProfile() {
        this.username = null;
        this.password = null;
    }

    //constructor for the profile
    //creates a profile with a unique username and a password
    public userProfile(String username, String password) {
        // Username requirements: each user must have a unique username by creating it with characters [a-z], [0-9], and special characters (@, !, etc). The user will not be able to create them with invalid characters such as `[]` and `\`.

        // Define patterns to search for in usernames and passwords.
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@]");
        Pattern invalid_special = Pattern.compile("[\\[\\]/\\/]");

        // Create matcher variables for the username.
        Matcher UN_hasletter = letter.match(username);
        Matcher UN_hasDigit = digit.match(username);
        Matcher UN_hasSpecial = special.match(username);
        Matcher UN_hasInvalid = invalid_special.match(username);

        // Create matcher variables for the password.
        Matcher PW_hasletter = letter.match(password);
        Matcher PW_hasDigit = digit.match(password);
        Matcher PW_hasSpecial = special.match(password);
        Matcher PW_hasInvalid = invalid_special.match(password);

        //check to make sure the input is not null
        //then do the following code:
        if(username != null && password != null){
            //Check if username is valid and print a message if it isn't.
            if(!UN_hasletter.find() == true || !UN_hasDigit.find() == true || !UN_hasSpecial.find() == true || !UN_hasInvalid.find() == false){
                System.out.println("INVALID USERNAME!");
            }
            // Check if password is valid and print a message if it isn't.
            else if(!PW_hasletter.find() == true || !PW_hasDigit.find() == true || !PW_hasSpecial.find() == true || !PW_hasInvalid.find() == false){
                System.out.println("INVALID PASSWORD!");
            }
            // Set the username and password if both are true.
            else{
                this.username = username;
                this.password = password;
            }
        }

    }

    //getter for the username
    public String getUsername(){
        return username;
    }

    //Check to see if the Username entered exists.
    public boolean usernameExists(String inputUsername){
        //Return true if the inputted username matches a username in the database.
        if(inputUsername == username){
            return true;
        }
        // Return false otherwise.
        else{
            return false;
        }
    }

    //check to see if the password entered is the correct password.
    public boolean isPasswordCorrect(String inputPassword){
        //Return true if the inputted password matches the password in the database and corresponds with the inputted username. 
        if(inputPassword == password){
            return true;
        }
        // Return false otherwise.
        else{
            return false;
        }
    }

    //Function: Add and remove a friend
    public updateFriendList(int update, String friendName){
        // If update = 1, then add friendName to friend list.
        if(update == 1){
            friendLst.add(friendName);
        }

        // If update = 0, then remove friendName from friend list.
        if(update == 0){
            friendLst.remove(friendName);
        }
    }
}
