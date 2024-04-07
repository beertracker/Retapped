/****************************************/
//this class defines the service of Retapped that allows the user to create a "Log"
//a log is an update to the user's profile that says that the user has consumed a beverage
//the log contains the beverage, when it was consumed, and the user's rating
//logs will be combined into a user diary showing all the beverages that they have logged
//logs will also be used to update the user's flavor profile
//logs can be seen by friends of the user
/****************************************/
package com.retapped.service;

public class EnterLogService {

    //GLOBALS:
    String beverageName; //name of the beverage that is being logged
    float userRating; //the users rating of the beverage (1-10)

    //GETTERS AND SETTERS
    public void setBeverageName(String beverageName){
        this.beverageName = beverageName;
    }

    public String getBeverageName(){
        return this.beverageName;
    }

    public void setUserRating(float userRating){
        this.userRating = userRating;
    }

    public float getUserRating(){
        return this.userRating;
    }



    //get the beverage type from the database using the beverage name
    public void getBeverageType() {
        
    }

    //check the score of the user's rating
    //if it is high, add points to the beverage type's score
    //if it is low, remove points from the beverage type's score
    public void checkScore(){

    }
}
