package com.retapped.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "beverage types")
public class BeverageType {

    @Id
    private String type;
    private float userScore;

    //getter and setter for the score
    public void setUserScore(float userScore){
        this.userScore = userScore;
    }

    public float getUserScore(){
        return this.userScore;
    }

}
