/****************************************************/
//this class will calculate the user's "Flavor Profile" (FP)
//the initial FP will be calulated at the creation of the user's profile
//the FP will be updated each time the user rates a beer that they are logging
//a positive rating means that that type of beverage will be suggested
//a negative rating means that that type of beverage will not be suggested 
/****************************************************/

package com.retapped.service;

//import com.retapped.domain.Beer;
import com.retapped.domain.BeverageType;
import java.util.*;

public class FlavorProfileService {

    //"database" to hold the user's top flavors
    ArrayList<String> topFlavors = new ArrayList<String>();

    //beaverage types for testing
    //fill from teh database?
    ArrayList<BeverageType> beverageTypes = new ArrayList<BeverageType>();

    //constructor
    public FlavorProfileService(){

    }

    //set each beverage type to the basic score of 5
    //each beverage has a score that can change with a log
    public void setDefaultScores(){

        //get each beaverage type
        //would be from the database in the future
        for(int i = 0; i <beverageTypes.size(); i++ ){
            //set the score to 5 (neutral)
            beverageTypes.get(i).setUserScore(5);
        }

    }

    //if a flavor has a high enough score it will be added to the TopFlavors list
    public void addTopFlavor(){
        
    }

    //show the user's favorite flavors
    //shows the types of beverages with the highest scores
    public void topFlavors(){
    }

    //method for adding points to a beaverage type 
    //if the log rating is higher than 6
    //@PARAM the beer that is being logged and the rating given
    public void addPoints(BeverageType beverageType, float rating){
        
        //variable to determine what to add to the score
        float scoreAddition = 0;

        //if the rating is 7, add one to the score
        if(rating >= 7 && rating < 8)
            scoreAddition = 1;
        
        //if the rating is 8, add 2
        else if(rating >= 8 && rating < 9)
            scoreAddition = 2;

        //if the rating is 9,10 add 3
        else if(rating >= 9)
            scoreAddition = 3;

        //check that the score will not go over 10
        float newScore = 0;
        float currentScore = beverageType.getUserScore();
        if((currentScore + scoreAddition) > 10)
            newScore = 10;
        else
            newScore = (currentScore + scoreAddition);

        //set the score
        beverageType.setUserScore(newScore);


        //compare to top flavors' scores


    }

    //methhod for removing points from a beaverage type
    //if the log score is lower than a 4
    //@PARAM the beer that is being logged and the rating given
    public void removePoints(BeverageType beverageType, float rating){

        //variable to determine what to add to the score
        float scoreSubtraction = 0;

        //if the rating is 3-4 , subtract one from the score
        if(rating <= 4 && rating > 3)
            scoreSubtraction = 1;
        
        //if the rating is 2-3 , subtract one from the score
        else if(rating <= 3 && rating > 2)
            scoreSubtraction = 2;

        //if the rating is 0-2 , subtract one from the score
        else if(rating <= 2)
            scoreSubtraction = 3;

        //check that the score will not go over 10
        float newScore = 0;
        float currentScore = beverageType.getUserScore();
        if((currentScore - scoreSubtraction) < 0)
            newScore = 0;
        else
            newScore = (currentScore - scoreSubtraction);

        //set the score
        beverageType.setUserScore(newScore);
        
    }


}
